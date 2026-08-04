class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=101;
        int max=0;
        for(int i : nums){
            min=Math.min(min,i);
            max = Math.max(max,i);
        }
        int arr[] = new int[max+1];
        for(int i : nums){
            arr[i]++;
        }
        List<Integer>list = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(arr[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}