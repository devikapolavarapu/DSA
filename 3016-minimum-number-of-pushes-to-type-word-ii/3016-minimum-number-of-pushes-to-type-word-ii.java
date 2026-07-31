class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int temp = 0, sum = 0, a = 1;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[word.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) break;  
            temp++;
            sum += count[i] * a;
            if (temp % 8 == 0) a++;
        }
        return sum;
    }
}