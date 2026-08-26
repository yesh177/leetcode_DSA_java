import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int ind = i % n;

            while (!st.isEmpty() && st.peek() <= nums[ind]) {
                st.pop();
            }

            if (i < n && !st.isEmpty()) {
                ans[ind] = st.peek();
            }

            st.push(nums[ind]);
        }

        return ans;
    }
}