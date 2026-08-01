class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        int ans=helper(nums,0,0,nums.length-1,dp);
        return ans>=0;
    }
    public int helper(int[] nums,int ptr,int i,int j,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int ans=0;
        if(ptr==0){
           int first= nums[i]+helper(nums,1,i+1,j,dp);
           int last= nums[j]+helper(nums,1,i,j-1,dp);
           ans=Math.max(first,last);
        }else{
           int first= -nums[i]+helper(nums,0,i+1,j,dp);
           int last= -nums[j]+helper(nums,0,i,j-1,dp);
            ans=Math.min(first,last);
        }
        return dp[i][j]=ans;
    }
}