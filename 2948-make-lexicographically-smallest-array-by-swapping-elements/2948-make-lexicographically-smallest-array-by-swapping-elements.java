class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = ((long) nums[i] << 32) | (i & 0xffffffffL);
        Arrays.sort(a);
        int start = 0;
        while (start < n) {
            int end = start;
            while (end + 1 < n &&
                   ((int) (a[end + 1] >> 32) - (int) (a[end] >> 32)) <= limit)
                end++;
            int size = end - start + 1;
            int[] idx = new int[size];
            for (int i = 0; i < size; i++)
                idx[i] = (int) a[start + i];
            Arrays.sort(idx);
            for (int i = 0; i < size; i++)
                nums[idx[i]] = (int) (a[start + i] >> 32);
            start = end + 1;
        }
        return nums;
    }
}