class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ans = 0, cur = 0, pz = 0, max =0;
        for(char c : s.toCharArray()){
            if( c == '0') cur++;
            else{
                if( cur >0 && pz > 0) max = Math.max(max, cur + pz);
                if( cur > 0) pz = cur;
                cur = 0;
                ans++;
            }
        }
        if( cur >0 && pz > 0) max = Math.max(max, cur + pz);
        return ans + max;
    }
}