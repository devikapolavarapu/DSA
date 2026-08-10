class Solution {
    Boolean[] arr;
    public boolean winnerSquareGame(int n) {
        arr= new Boolean[n+1];
        arr[0]=false;
        for(int i=1;i*i<=n;i++)
            arr[i*i]=true;
        return dp(n);
    }
    boolean dp(int n){
        if(arr[n]!=null) return arr[n];
        boolean temp=true;
        for(int i=(int)Math.sqrt(n);i*i>=1;i--) temp=temp&&dp(n-i*i);
        arr[n]=!temp;
        return arr[n];
    }
}