package com.thinkjs.io;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstSearch {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int S;
	
	public BreadthFirstSearch(Graph G, int S){
		this.S = S;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, S);
	}
	
	private void bfs(Graph G, int V){
		marked[V] = true;
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(V);
		while(!q.isEmpty()){
			int w = q.dequeue();
			for(int i: G.adj(w)){
				if(!marked[i]){
					edgeTo[i] = w;
					marked[i] = true;
					q.enqueue(i);
				}
			}
		}
	}

}
