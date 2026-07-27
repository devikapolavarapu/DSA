class Solution {
    public int maxProduct(int[] nums) {
        int i = 0, j = 0;
        for (int element : nums) {
            if (element >= j) {
                i = j;
                j = element;
            } else if (element >= i) {
                i = element;
            }
        }
        return (i - 1) * (j - 1);
    }
}