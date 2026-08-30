class Solution {
    public int minimumDeletions(int[] nums) {
        int min=nums[0],max=nums[0];
        int MinIndex=0,MaxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                MaxIndex=i;
            }
            else if(nums[i]<min){
                min=nums[i];
                MinIndex=i;
            }
        }
        int countfb=nums.length-(Math.max(MaxIndex,MinIndex))+Math.min(MaxIndex,MinIndex)+1;
        int countb=nums.length-(Math.min(MaxIndex,MinIndex));
        int countf=Math.max(MaxIndex,MinIndex)+1;
        return Math.min(Math.min(countf,countb),countfb);
    }
}