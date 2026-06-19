class Solution {
    public int largestAltitude(int[] arr) {
        int prefixSum[]=new int[arr.length+1];
        prefixSum[0]=0;
        for (int i=1; i<=arr.length; i++)
            prefixSum[i]=prefixSum[i-1]+arr[i-1];
    int res=Integer.MIN_VALUE;
    for (int i=0; i<prefixSum.length; i++)
        res=Math.max(prefixSum[i],res);
    return res;
    }
}