class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(bestRobbery(nums));
    }
    // Using DP, House Robber (Medium) You are a robber planning to rob houses along a street. Each house has some money, but adjacent houses have security — you can't rob two adjacent houses.
    static int bestRobbery(int[] nums){
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
    
     // Using DP, Climbing Stairs (Easy), You are climbing a staircase. It takes n steps to reach the top. Each time you can climb either 1 or 2 steps. How many distinct ways can you climb to the top?
    static public int climbStairs(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i <= n;i++){
            dp[i] += dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    
}