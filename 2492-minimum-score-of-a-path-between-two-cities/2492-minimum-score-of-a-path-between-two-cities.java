class Solution {
    public int minScore(int n, int[][] roads) {
        int[] parent = new int[n+1], rank = new int[n+1];
        for(int i = 1; i <= n; ++i){
            parent[i] = i;
            rank[i] = Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE, u, v;
        for(int[] road : roads){
            union(parent, rank, road[0], road[1], road[2]);
        }
        u = find(parent, 1); v = find(parent, n);
        if(u == v){
            ans = rank[u];
        }
        return ans;
    }
    private int find(int[] parent, int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent, parent[x]);
    }
    private void union(int[] parent, int[] rank, int u, int v, int w){
        u = find(parent, u);
        v = find(parent, v);
        if(rank[u] <= rank[v]){
            parent[v] = u;
            rank[u] = (int)Math.min(rank[u], w);
        }
        else{
            parent[u] = v;
            rank[v] = (int)Math.min(rank[v], w);
        }
        return;
    }    
}