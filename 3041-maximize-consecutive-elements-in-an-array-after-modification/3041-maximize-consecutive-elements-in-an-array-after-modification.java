class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1;i<n;i++) {
            dp[i][0] = nums[i] == nums[i-1] + 1 ? 1 + dp[i-1][0] :
                (nums[i] == nums[i-1] + 2 ? 1 + dp[i-1][1] : 
                (nums[i] == nums[i-1]) ? dp[i-1][0] : 1);
            dp[i][1] = nums[i] == nums[i-1] ? 1 + dp[i-1][0] :
                 (nums[i] == nums[i-1] + 1 ? 1 + dp[i-1][1] : 1);
            if(nums[i] == nums[i-1]) {
                dp[i][0] = dp[i-1][0];
            }
        }

        int ans = 0;
        for(int[] d: dp) {
            ans = Math.max(ans, Math.max(d[0], d[1]));
        }
        return ans;
    }
}