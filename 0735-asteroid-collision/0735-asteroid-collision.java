class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> st = new ArrayList<>();

        for (int a : asteroids) {
            if (a > 0) {
                st.add(a);
            } else {
                while (!st.isEmpty() &&
                       st.get(st.size() - 1) > 0 &&
                       st.get(st.size() - 1) < -a) {
                    st.remove(st.size() - 1);
                }

                if (!st.isEmpty() && st.get(st.size() - 1) == -a) {
                    st.remove(st.size() - 1);
                } else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(a);
                }
            }
        }

        int[] ans = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }
        
        return ans;
    }
}