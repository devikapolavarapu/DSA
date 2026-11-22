class Solution {
    public boolean checkString(String s) {
        char[] t= s.toCharArray();
        int flag =0;
        for(int i=0;i<s.length();i++){
if(t[i]=='b' ){
    flag=1;
}else if(t[i]=='a' && flag==1){
 return false;
    }
    }
   return true; 
    }
}