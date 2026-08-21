class Solution {
    public long findKthSmallest(int[] coins, long k) {
        Arrays.sort(coins);
        int m = 0;
        int[] arr = new int[coins.length];
        outer:
        for (int c : coins) {
            for (int j = 0; j < m; j++) {
                if (c % arr[j] == 0) continue outer;
            }
            arr[m++] = c;
        }
        int total = 1 << m;
        long[] lcm = new long[total];
        int[] sign = new int[total];
        long max = k * arr[0];
        lcm[0] = 1;
        for (int mask = 1; mask < total; mask++) {
            int i = Integer.numberOfTrailingZeros(mask);
            int prev = mask ^ (1 << i);
            if (lcm[prev] == -1) {
                lcm[mask] = -1;
            } else {
                long g = gcd(lcm[prev], arr[i]);
                long val = lcm[prev] / g * arr[i];
                lcm[mask] = val > max ? -1 : val;
            }
            sign[mask] = (Integer.bitCount(mask) & 1) == 1 ? 1 : -1;
        }
        long lo = arr[0], hi = max;
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            long cnt = 0;
            for (int mask = 1; mask < total; mask++) {
                if (lcm[mask] > 0) cnt += sign[mask] * (mid / lcm[mask]);
            }
            if (cnt >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private long gcd(long a, long b) {
        while (b != 0) { long t = b; b = a % b; a = t; }
        return a;
    }
}