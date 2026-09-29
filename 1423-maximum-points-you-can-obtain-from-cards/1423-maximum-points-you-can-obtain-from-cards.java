class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Start by taking k cards from the right
        int currentSum = 0;

        for (int i = n - k; i < n; i++) {
            currentSum += cardPoints[i];
        }

        int maxScore = currentSum;

        // Replace right cards one by one with left cards
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
            currentSum -= cardPoints[n - k + i];

            maxScore = Math.max(maxScore, currentSum);
        }

        return maxScore;
    }
}