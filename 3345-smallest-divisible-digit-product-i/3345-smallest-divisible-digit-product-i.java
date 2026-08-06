class Solution {
    public int smallestNumber(int n, int t) {
        if (t == 1) return n;
        if (n == 100) return 100;
        if (n < 10) {
            for (int i = n; i <= 10; i++) if (i % t == 0) return i;
            return 10;
        }
        int r = n + 10;
        for (int i = n; i <= r; i++) {
            if ((i / 10 * (i % 10)) % t == 0) return i;
        }
        return -1;
    }
}