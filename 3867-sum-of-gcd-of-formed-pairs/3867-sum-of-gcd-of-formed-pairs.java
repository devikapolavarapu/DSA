class Solution
{
    public long gcdSum(int[] nums)
    {
        int n = nums.length;
        int [] p = new int[n];
        p[0] = nums[0];
        for(int i=1, m=nums[0]; i<n; i++)
        {
            m = Math.max(m,nums[i]);
            p[i] = gcd(nums[i],m);
        }
        Arrays.sort(p);
        long s = 0;
        for(int l=0, r=n-1; l<r; l++, r--)
            s += gcd(p[l],p[r]);
        return s;
    }
    private int gcd(int a, int b)
    {
        for(int t=b; b!=0;)
        {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}