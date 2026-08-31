class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        if (ans.length() == 0) {
            return "0";
        }

        int i = 0;

        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }

        return ans.substring(i);
    }
}