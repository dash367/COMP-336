public class Knapsack {
    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        int[] weights = {1,3,4,5};
        int capacity = 7;
        System.out.println(bestCapacity(nums, weights, capacity));
    }

    static int bestCapacity(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];
    
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                }
            }
        }
    
        return dp[n][capacity];
    }
    
}
