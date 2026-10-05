class Solution
{
    public int scoreOfParentheses(String s)
    {
        int l = s.length();
        final int [] t = new int[l/2];
        int r = 0;
        
        for(int i=0, p=-1; i<l; i++)
        {
            if(s.charAt(i)=='(')
            {
                t[++p] = r;
                r = 0;
            }

            else
                r = t[p--] + Math.max(2*r,1);
        }

        return r;
    }
}