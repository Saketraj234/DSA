/**
 * Problem: 225. Implement Stack using Queues
 *
 * Implement a last-in-first-out (LIFO) stack
 * using only two queues.
 *
 * Approach:
 * We use one queue.
 *
 * push(x):
 * 1. Insert element into queue.
 * 2. Rotate previous elements behind it.
 *
 * So newest element always stays at front.
 *
 * Time Complexity:
 * push()  -> O(n)
 * pop()   -> O(1)
 * top()   -> O(1)
 * empty() -> O(1)
 *
 * Space Complexity: O(n)
 */

class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {

        q.offer(x);

        for (int i = 0; i < q.size() - 1; i++) {

            q.offer(q.poll());
        }
    }

    public int pop() {

        return q.poll();
    }

    public int top() {

        return q.peek();
    }

    public boolean empty() {

        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */