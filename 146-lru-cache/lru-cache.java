/**
 * Problem: 146. LRU Cache
 *
 * Design a data structure that follows
 * the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement:
 * 1. get(key)
 *    - Return value if key exists
 *    - Else return -1
 *
 * 2. put(key, value)
 *    - Update key if already exists
 *    - Else insert new key-value pair
 *    - If capacity exceeds, remove least recently used key
 *
 * Approach:
 * We use:
 * 1. HashMap -> O(1) access
 * 2. Doubly Linked List -> maintain recent order
 *
 * Most Recently Used  -> head side
 * Least Recently Used -> tail side
 *
 * Whenever a node is accessed:
 * remove it from current position
 * and move it to front.
 *
 * Time Complexity:
 * get()  -> O(1)
 * put()  -> O(1)
 *
 * Space Complexity:
 * O(capacity)
 */

class LRUCache {

    class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    int capacity;

    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Add node right after head
    private void addNode(Node node) {

        Node temp = head.next;

        head.next = node;
        node.prev = head;

        node.next = temp;
        temp.prev = node;
    }

    // Remove node from linked list
    private void deleteNode(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {

        // Key not present
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Move node to front
        deleteNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node oldNode = map.get(key);

            deleteNode(oldNode);
            map.remove(key);
        }

        // Cache full
        if (map.size() == capacity) {

            // Remove LRU node
            Node lru = tail.prev;

            deleteNode(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        addNode(newNode);

        map.put(key, newNode);
    }
}