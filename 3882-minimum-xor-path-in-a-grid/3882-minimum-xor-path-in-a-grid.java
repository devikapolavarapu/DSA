class Solution {
    static final int LIM = 1 << 10;
    public int minCost(int[][] A) {
        int m = A.length, n = A[0].length;
        long[][] dp = new long[n][LIM / 64];
        dp[0][A[0][0] >>> 6] |= 1L << (A[0][0] & 63);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                long[] curr = dp[j];
                long[] prev = j > 0 ? dp[j - 1] : null;
                if (prev != null) {
                    for (int w = 0; w < 16; w++) {
                        curr[w] |= prev[w];
                    }
                }
                long[] transformed = new long[16];
                for (int w = 0; w < 16; w++) {
                    long bits = curr[w];
                    while (bits != 0) {
                        int b = Long.numberOfTrailingZeros(bits);
                        int x = (w << 6) + b;
                        int y = x ^ A[i][j];
                        transformed[y >>> 6] |= 1L << (y & 63);
                        bits &= bits - 1;
                    }
                }
                System.arraycopy(transformed, 0, curr, 0, 16);
            }
        }
        for (int k = 0; k < LIM; k++) {
            if ((dp[n - 1][k >>> 6] & (1L << (k & 63))) != 0) {
                return k;
            }
        }
        return 0;
    }
}