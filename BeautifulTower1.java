public class BeautifulTower1{
    public long maximumSumOfHeights(int[] heights) {

        int n = heights.length;
        long maxHeight = 0;
        long min = heights[0];
        for (int i = 1; i < n; i++)
            min = Math.min(min, heights[i]);
        for (int i = 0; i < n; i++) {

            int left = i - 1;
            int right = i + 1;
            long minHeight = heights[i];
            long sum = heights[i];
            while (left >= 0) {
                if (heights[left] == min) {
                    sum += min * (left + 1);
                    break;
                } else if (heights[left] < minHeight) {
                    sum += heights[left];
                    minHeight = heights[left];
                } else {
                    sum += minHeight;
                }

                left--;
            }

            minHeight = heights[i];

            while (right < n) {
                if (heights[right] == min) {
                    sum += min * (n - right);
                    break;
                } else if (heights[right] < minHeight) {
                    sum += heights[right];
                    minHeight = heights[right];
                } else {
                    sum += minHeight;
                }
                right++;
            }

            maxHeight = Math.max(maxHeight, sum);

        }

        return maxHeight;
    }
}