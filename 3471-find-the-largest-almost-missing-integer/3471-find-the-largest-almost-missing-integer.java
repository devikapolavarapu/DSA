class Solution {
    public int largestInteger(int[] nums, int k) {
        int [] count = new int[51];
        for(int i = 0; i <= nums.length - k; i++){
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++){
                set.add(nums[j]);
            }
            for(int num: set){
                count[num] ++;
            }
        }
        for(int num = 50; num >= 0; num --){
            if (count[num] == 1){
                return num;
            }
        }
        return -1;
    }
}