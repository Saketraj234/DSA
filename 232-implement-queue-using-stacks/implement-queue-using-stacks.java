/**
 * Problem: Implement Queue using Array
 *
 * We implement Queue using Circular Array.
 *
 * Queue follows FIFO:
 * First In First Out
 *
 * Variables:
 * size     -> Maximum capacity of queue
 * q[]      -> Array for storing elements
 * curSize  -> Current number of elements
 * start    -> Front index
 * end      -> Rear index
 *
 * Push:
 * If queue empty:
 *      start = 0
 *      end = 0
 *
 * Else:
 *      end = (end + 1) % size
 *
 * Pop:
 * Remove element from start.
 *
 * If only one element:
 *      start = end = -1
 *
 * Else:
 *      start = (start + 1) % size
 *
 * Time Complexity:
 * push  -> O(1)
 * pop   -> O(1)
 * peek  -> O(1)
 * empty -> O(1)
 *
 * Space Complexity:
 * O(n)
 */

class MyQueue {

    int size;

    int[] q;

    int curSize;

    int start;

    int end;

    public MyQueue() {

        size = 100;

        q = new int[size];

        curSize = 0;

        start = -1;

        end = -1;
    }

    // PUSH
    public void push(int x) {

        // Queue Full
        if (curSize >= size) {
            return;
        }

        // First Element
        if (curSize == 0) {

            start = 0;

            end = 0;
        }

        else {

            end = (end + 1) % size;
        }

        q[end] = x;

        curSize += 1;
    }

    // POP
    public int pop() {

        // Queue Empty
        if (curSize == 0) {
            return -1;
        }

        int el = q[start];

        // Only One Element
        if (curSize == 1) {

            start = -1;

            end = -1;
        }

        else {

            start = (start + 1) % size;
        }

        curSize -= 1;

        return el;
    }

    // PEEK
    public int peek() {

        // Queue Empty
        if (curSize == 0) {
            return -1;
        }

        return q[start];
    }

    // EMPTY
    public boolean empty() {

        return curSize == 0;
    }
}