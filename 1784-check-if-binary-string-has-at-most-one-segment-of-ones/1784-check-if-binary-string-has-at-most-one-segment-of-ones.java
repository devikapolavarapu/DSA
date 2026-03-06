class Solution {
    public boolean checkOnesSegment(String s) {
        boolean foundSegment = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (foundSegment) {
                    return false;
                }
                foundSegment = true;
                while (i < s.length() && s.charAt(i) == '1') {
                    i++;
                }
            }
        }
        return true;
    }
}
