import java.util.Stack;

class MaximalRectangle{
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res[] = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = 0;
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            // update MAH Array than calculate area
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    res[j] = 0;
                } else {
                    res[j] = res[j] + matrix[i][j] - '0';
                }
            }

            ans = Math.max(ans, largestRectangleArea(res));
        }

        return ans;

    }

    public int largestRectangleArea(int[] heights) {

        int nrs[] = nearestRightSmallerInderArray(heights);
        int nls[] = nearestLeftSmallerInderArray(heights);
        for (int i = 0; i < heights.length; i++) {
            System.out.println(nrs[i]);
            System.out.println(nls[i]);
        }
        int ans = -1;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max((nrs[i] - nls[i] - 1) * heights[i], ans);
        }

        return ans;

    }

    public int[] nearestRightSmallerInderArray(int height[]) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[height.length];

        for (int i = height.length - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                if (height[st.peek()] < height[i]) {
                    res[i] = st.peek();
                    st.push(i);
                    break;
                } else {
                    st.pop();
                }
            }

            if (st.isEmpty()) {
                st.push(i);
                res[i] = height.length;
            }
        }

        return res;
    }

    public int[] nearestLeftSmallerInderArray(int height[]) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty()) {
                if (height[st.peek()] < height[i]) {
                    res[i] = st.peek();
                    st.push(i);
                    break;
                } else {
                    st.pop();
                }
            }

            if (st.isEmpty()) {
                st.push(i);
                res[i] = -1;
            }
        }

        return res;
    }
}