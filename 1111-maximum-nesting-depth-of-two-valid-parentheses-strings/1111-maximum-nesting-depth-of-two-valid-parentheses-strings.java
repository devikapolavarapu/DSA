class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int dep=0;
        int[]ans=new int[n];
        int i=0;
        for(char ch:seq.toCharArray()){
            if(ch=='('){
                ans[i++]=(dep%2);
                dep++;
            }
            else{
                  dep--;
                ans[i++]=(dep%2);
              
            }
        }
        return ans;
    }
}