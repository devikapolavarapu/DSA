class Solution
{
    int m, n;
    public int closedIsland(int[][] grid)
    {
        m = grid.length;
        n = grid[0].length;
        for(int i=0; i<m; i++)
        {
            fill(grid,i,0);
            fill(grid,i,n-1);
        }
        for(int j=0; j<n; j++)
        {
            fill(grid,0,j);
            fill(grid,m-1,j);
        }
        int r = 0;
        for(int i=1; i<m-1; i++)
            for(int j=1; j<n-1; j++)
                if(grid[i][j]==0)
                {
                    r++;
                    fill(grid,i,j);
                }
        return r;
    }
    private void fill(int [][] g, int x, int y)
    {
        if(x==-1 || x==m || y==-1 || y==n || g[x][y]!=0)
            return;
        g[x][y] = 1;
        fill(g,x+1,y);
        fill(g,x,y+1);
        fill(g,x-1,y);
        fill(g,x,y-1);
    }
}