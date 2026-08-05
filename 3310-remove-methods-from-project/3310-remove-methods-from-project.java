class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        boolean vis[]=new boolean[n];
    	ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		adj.add(new ArrayList<>());
    	}    	
    	for(int i=0;i<arr.length;i++) adj.get(arr[i][0]).add(arr[i][1]);
    	ArrayDeque<Integer> dq =new ArrayDeque<>();  	
    	dq.add(k);
    	vis[k]=true;
    	while(!dq.isEmpty()) {
    		int rem=dq.remove();
    		for(int it: adj.get(rem)) {
    			if(vis[it]==false) {
    				vis[it]=true;
    				dq.add(it);
    			}
    		}
    	}    	
    	boolean fl=true;
    	for(int i=0;i<n;i++) {
    		if(vis[i]==false) {
        		for(int it: adj.get(i)) {
        			if(vis[it]==true) {
        				fl=false;
        				break;
        			}
        		}
    		}
    	}
    	if(fl==true) {
    		List<Integer> res=new ArrayList<>();
    		for(int i=0;i<n;i++) if(vis[i]==false) res.add(i);   	
    		return res;   		
    	}else {
    		List<Integer> res=new ArrayList<>();
    		for(int i=0;i<n;i++) res.add(i);   			
    		return res;
    	}
    }
}