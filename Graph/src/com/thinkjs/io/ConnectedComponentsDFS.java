package com.thinkjs.io;

public class ConnectedComponentsDFS {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int count;
	private int[] id;
	
	public ConnectedComponentsDFS(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int i = 0; i<G.V();i++){
			if(!marked[i]){
				dfs(G, i);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int k:G.adj(v)){
			if(!marked[k]){
				dfs(G,k);
			}
		}
	}
	
	public boolean isConnected(int v, int w){
		return id[v] == id[w];
	}

}
