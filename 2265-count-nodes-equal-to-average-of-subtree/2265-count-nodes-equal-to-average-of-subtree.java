class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        sumAndAvg(root);
        return count;
    }
    private int[] sumAndAvg(TreeNode node) {
        if(node == null)
            return new int[]{0,0};
        
        int[] left = sumAndAvg(node.left);
        int[] right = sumAndAvg(node.right);
        int sum = left[0] + right[0] + node.val;
        int n = left[1] + right[1] + 1;
        int avg = sum/n;
        if(node.val == avg)
            count++;
        return new int[]{sum,n};
    }
}