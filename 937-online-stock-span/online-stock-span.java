/**
 * Problem: 901. Online Stock Span
 *
 * The stock span of today's price is defined as
 * the number of consecutive days (including today)
 * where price <= today's price.
 *
 * Approach:
 * We use Monotonic Stack.
 *
 * Stack stores:
 * {price, index}
 *
 * We remove all smaller or equal prices
 * because they cannot help in future.
 *
 * If stack becomes empty:
 * span = currentIndex - (-1)
 *
 * Else:
 * span = currentIndex - previousGreaterIndex
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class StockSpanner {

    Stack<int[]> st;
    int idx;

    public StockSpanner() {

        st = new Stack<>();
        idx = -1;
    }

    public int next(int price) {

        idx = idx + 1;

        // remove smaller or equal prices
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int ans;

        // if no greater element on left
        if (st.isEmpty()) {
            ans = idx - (-1);
        }
        else {
            ans = idx - st.peek()[1];
        }

        // store {price, index}
        st.push(new int[]{price, idx});

        return ans;
    }
}