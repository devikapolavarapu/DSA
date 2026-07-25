class Solution {
    public int maxProduct(int n) {
        int rem=0;
        int div=n;
        int first=0;
        int second=0;
        for(int i=0;div!=0;i++){
            rem=div%10;
            div=div/10;
            if(rem>first){
                if(first>second){
                    second=first;
                }
                first=rem;
                continue;
            }
            if(rem>second){
                second=rem;
            }
        }
        return first*second;
    }
}