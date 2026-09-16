class Solution {
    public void sortColors(int[] nums) {
       int c=0;
       int a=0;
       int b=0;
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==0) 
            {
                c++;
            }
            else if(nums[i]==1) 
            {
                a++;
            }
            else 
            {
                b++;
            }
        }
        int i=0; 
        while(c-->0)
        {
            nums[i]=0;
          
            i++;
             
        }
          while(a-->0)
        {
            nums[i]=1;
            i++;
        }
          while(b-->0)
        {
            nums[i]=2;
            i++;
        }
    }
}