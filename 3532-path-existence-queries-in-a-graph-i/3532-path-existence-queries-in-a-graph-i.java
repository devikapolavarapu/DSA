class Solution
{
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries)
    {
        int [] g = new int[n];
        for(int i=1; i<n; i++)
        {
            if(nums[i-1]+maxDiff>=nums[i])
                g[i] = g[i-1];
            else
                g[i] = i+1;
        }
        int l = queries.length;
        boolean [] r = new boolean[l];
        for(int i=0; i<l; i++)
            r[i] = g[queries[i][0]]==g[queries[i][1]];
        return r;
    }
}