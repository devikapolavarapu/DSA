class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int len=String.valueOf(low).length();
        int j=1,num=0,adder=0;
        while(j<=len){
            num=num*10+j;
            adder=adder*10+1;
            j++;
        }
        List<Integer> ans=new ArrayList<>();
        int temp=num;        
        while(num<=high){
            if(num>=low)ans.add(num);
            if(num%10==9){
                adder=adder*10+1;
                num=temp*10+len+1;
                temp=num;
                len=String.valueOf(adder).length();
            }else{
                num+=adder;
            }
        }
        return ans;
    }
}