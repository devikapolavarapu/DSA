class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]==1){
                count++;
                sum+=nums[i];
            }
            else{
                break;
            }
        }
        int arr[]=new int[2501];
        for(int i=0;i<n;i++)arr[nums[i]]++;
        int ans=sum;
        for(int i=sum;i<2501;i++){
            if(arr[i]==0){
                ans=i;
                break;
            }
        }
        return ans;

    }
}