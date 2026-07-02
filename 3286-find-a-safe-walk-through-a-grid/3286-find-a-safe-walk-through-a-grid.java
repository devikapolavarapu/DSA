class Solution {
    Boolean[][][] dp;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        if(grid.get(0).get(0)==1)health--;
        dp = new Boolean[grid.size()][grid.get(0).size()][grid.get(0).size() + grid.size()+1];
        return safe(0, 0, health, new boolean[grid.size()][grid.get(0).size()], grid);
    }
    int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean safe(int x, int y, int health, boolean[][] vis, List<List<Integer>> g){
        if(health<1)
            return false;
        if(x==g.size()-1 && y==g.get(0).size()-1)
            return true;
        if(dp[x][y][health]!=null)
            return dp[x][y][health];
        vis[x][y]=true;
        boolean works = false;
        for(int[] m : moves){
            int nx = x+m[0];
            int ny = y+m[1];
            if(!valid(nx, ny, g) || vis[nx][ny])
                continue;
            int cost = g.get(nx).get(ny)==1?1:0;            
            if(safe(nx, ny, health-cost, vis, g)){
                return dp[nx][ny][health]=true;
            }
        }
        vis[x][y]=false;
        return dp[x][y][health] = works; 
    }
    public boolean valid(int x, int y, List<List<Integer>> g){
        return x>=0 && x<g.size() && y>=0 && y<g.get(0).size();
    }
}