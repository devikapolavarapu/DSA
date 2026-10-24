class Solution
{
    private final int[] daysBeforeMonth = {0,31,59,90,120,151,181,212,243,273,304,334};
    
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob)
    {
        int start = Math.max(dayOfYear(arriveAlice), dayOfYear(arriveBob));
        int end = Math.min(dayOfYear(leaveAlice), dayOfYear(leaveBob));

        return (start > end) ? 0 : end - start + 1;
    }

    public int dayOfYear(String d)
    {
        return daysBeforeMonth[Integer.parseInt(d.substring(0,2))-1] + Integer.parseInt(d.substring(3,5));
    }
}