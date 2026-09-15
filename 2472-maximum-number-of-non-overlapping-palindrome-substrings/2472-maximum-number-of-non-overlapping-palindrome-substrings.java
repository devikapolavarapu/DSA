class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int left = 0;
        int cnt = 0;
        while (left <= n - k) {
            if (Helper(s, left, left + k - 1)) {
                cnt++;
                left = left + k;
            }
            else if (left + k < n &&
                     Helper(s, left, left + k)) {
                cnt++;
                left = left + k + 1;
            }
            else {
                left++;
            }
        }
        return cnt;
    }
    public boolean Helper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}