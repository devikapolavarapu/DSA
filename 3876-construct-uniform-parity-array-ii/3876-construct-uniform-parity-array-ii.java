class Solution
{
    public boolean uniformArray(int[] nums1)
    {
        int m = Integer.MAX_VALUE;
        boolean o = false;
        for(int n : nums1)
            if(n%2==1)
            {
                o = true;
                m = Math.min(m,n);
            }
        if(!o)
            return true;
        for(int n : nums1)
            if(n%2==0 && m>n)
                return false;
        return true;
    }
}