class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0, right = 0, count =0; 
        String minSub = null;
        while ( right < s.length()){
            if ( s.charAt(right) == '1'){
                count++; 
            }
            right++;  
            while ( count > k || ( count == k && s.charAt(left) == '0')){
                if ( s.charAt(left) == '1'){
                    count--; 
                }
                left++; 
            }
            if ( count < k){
                continue; 
            }
            int len = right - left; 
            String sub = s.substring(left, right); 
            if ( minSub  == null || minSub.length() > len || ( minSub.length() == len && minSub.compareTo(sub) > 0)){
                minSub = sub;
            }
        }
        if ( minSub == null){
            return "";
        }
        return minSub;
    }
}