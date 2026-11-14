class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int size = nums.size();
        int min = 1_000_000;
        int[] pref = new int[size + 1];
        for (int i = 0; i < size; i++) {
            pref[i + 1] = nums.get(i) + pref[i];
        }
        for (int left = 0; left <= size - l; left++) {
            for (int right = left + l - 1; right < size; right++) {
                int len = right - left + 1;
                if (len >= l && len <= r) {
                    int sum = pref[right + 1] - pref[left];
                    if (sum > 0 && sum < min) {
                        min = sum;
                    }
                } else if (len > r) {
                    break;
                }
            }
        }
        return min == 1_000_000 ? -1 : min;
    }
}