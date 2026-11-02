class Solution {
    public int minMoves2(int[] nums) {
        final int n = nums.length;
        final int k = n >> 1;
        int lo = 0, hi = n - 1;
        int seed = 0x9E3779B9;
        while (lo < hi) {
            seed ^= seed << 13; seed ^= seed >>> 17; seed ^= seed << 5;  
            int pivot = nums[lo + (seed >>> 1) % (hi - lo + 1)];
            int i = lo, j = hi;
            while (i <= j) {
                while (nums[i] < pivot) i++;
                while (nums[j] > pivot) j--;
                if (i <= j) {
                    int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
                    i++; j--;
                }
            }
            if (k <= j) hi = j;
            else if (k >= i) lo = i;
            else break;
        }
        int median = nums[k];
        int moves = 0;
        for (int x : nums) moves += Math.abs(x - median);
        return moves;
    }
}