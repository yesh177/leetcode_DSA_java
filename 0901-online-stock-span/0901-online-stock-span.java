import java.util.*;

class StockSpanner {

    // Stack stores: {price, span}
    private Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        // Combine spans of all previous prices
        // less than or equal to current price
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1];
        }

        // Store current price and its span
        st.push(new int[]{price, span});

        return span;
    }
}