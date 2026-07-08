class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1000000007L;
        int n = s.length();
        long[] pow10 = new long[n + 1];
        int[] nz = new int[n + 1];
        long[] sumPrefix = new long[n + 1];
        long[] valPrefix = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) pow10[i] = (pow10[i - 1] * 10) % MOD;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            sumPrefix[i + 1] = sumPrefix[i] + digit;
            if (c != '0') {
                nz[i + 1] = nz[i] + 1;
                valPrefix[i + 1] = (valPrefix[i] * 10 + digit) % MOD;
            } else {
                nz[i + 1] = nz[i];
                valPrefix[i + 1] = valPrefix[i]; 
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long psum = sumPrefix[r + 1] - sumPrefix[l];
            int cnt = nz[r + 1] - nz[l];
            long numVal = ((valPrefix[r + 1] - valPrefix[l] * pow10[cnt]) % MOD + MOD) % MOD;
            long ans = (numVal * psum) % MOD;
            res[i] = (int) ans;
        }
        return res;
    }
}