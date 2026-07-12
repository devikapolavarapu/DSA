class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer,Integer> rankmap = new HashMap<>();
        int rank= 1;
        for(int num:sortedArr){
            if(!rankmap.containsKey(num)){
                rankmap.put(num,rank++);
            }
        }
        int[] result = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            result[i] = rankmap.get(arr[i]);
        }
        return result;
    }
}