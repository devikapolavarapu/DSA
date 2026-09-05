class Solution
{
    public int firstStableIndex(int[] nums, int k)
    {
        int l = nums.length;
        int [] r = new int[l];
        r[l-1] = nums[l-1];
        for(int i=l-2; i>-1; i--)
            r[i] = Math.min(r[i+1],nums[i]);
        for(int i=0, m=nums[0]; i<l; i++)
            if((m=Math.max(m,nums[i]))-r[i]<=k)
                return i;
        return -1;
    }
}