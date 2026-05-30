/**
 * Problem: 460. LFU Cache
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity)
 * Initializes the object with the capacity of the data structure.
 *
 * int get(int key)
 * Gets the value of the key if the key exists in the cache.
 * Otherwise, returns -1.
 *
 * void put(int key, int value)
 * Updates the value of the key if present,
 * or inserts the key if not already present.
 *
 * When the cache reaches its capacity,
 * invalidate and remove the least frequently used key.
 *
 * If there is a tie,
 * remove the least recently used key.
 *
 * ---------------------------------------------------
 *
 * Approach:
 *
 * We use:
 *
 * 1. HashMap -> key to node mapping
 * 2. Frequency Map -> freq to doubly linked list
 *
 * Each node stores:
 * key, value, frequency
 *
 * Every frequency has its own DLL.
 *
 * We always:
 * - Increase frequency on get/put
 * - Remove least freq node when full
 *
 * ---------------------------------------------------
 *
 * Time Complexity:
 * get()  -> O(1)
 * put()  -> O(1)
 *
 * Space Complexity:
 * O(capacity)
 */

class LFUCache {

    // Node of DLL
    class Node {

        int key;
        int val;
        int freq;

        Node prev;
        Node next;

        Node(int key, int val) {

            this.key = key;
            this.val = val;

            // initial frequency
            this.freq = 1;
        }
    }

    // Doubly Linked List
    class DLL {

        Node head;
        Node tail;

        int size;

        DLL() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // insert node at front
        void addFirst(Node node) {

            Node temp = head.next;

            head.next = node;
            node.prev = head;

            node.next = temp;
            temp.prev = node;

            size++;
        }

        // remove node
        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // remove least recently used node
        Node removeLast() {

            if (size > 0) {

                Node node = tail.prev;

                remove(node);

                return node;
            }

            return null;
        }
    }

    int capacity;
    int minFreq;

    // key -> node
    HashMap<Integer, Node> map;

    // freq -> DLL
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        // key not present
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // update frequency
        updateFreq(node);

        return node.val;
    }

    public void put(int key, int value) {

        // capacity zero
        if (capacity == 0) {
            return;
        }

        // key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.val = value;

            // increase frequency
            updateFreq(node);

            return;
        }

        // cache full
        if (map.size() == capacity) {

            DLL list = freqMap.get(minFreq);

            Node removeNode = list.removeLast();

            map.remove(removeNode.key);
        }

        // create new node
        Node newNode = new Node(key, value);

        // new node freq always 1
        minFreq = 1;

        DLL list = freqMap.getOrDefault(1, new DLL());

        list.addFirst(newNode);

        freqMap.put(1, list);

        map.put(key, newNode);
    }

    // update node frequency
    private void updateFreq(Node node) {

        int freq = node.freq;

        DLL list = freqMap.get(freq);

        // remove from old freq list
        list.remove(node);

        // if old minFreq list becomes empty
        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        // increase freq
        node.freq++;

        // add into new freq list
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());

        newList.addFirst(node);

        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 *
 * LFUCache obj = new LFUCache(capacity);
 *
 * int param_1 = obj.get(key);
 *
 * obj.put(key,value);
 */