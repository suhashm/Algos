package com.thinkjs.io;

public class DepthFirstSearch {
	
	private boolean[] marked;
	int count;
	
	public DepthFirstSearch(Graph G, int S){
		marked = new boolean[G.V()];
		dfs(G, S);
	}
	
	private void dfs(Graph G, int s){
		marked[s] = true;
		count++;
		for(int w: G.adj(s)){
			if(!marked[w])
				dfs(G, w);
		}
	}

}
