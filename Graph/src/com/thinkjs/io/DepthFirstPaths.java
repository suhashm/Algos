package com.thinkjs.io;

import java.util.Queue;
import java.util.Stack;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class DepthFirstPaths {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int S;
	
	public DepthFirstPaths(Graph G, int S){
		this.S = S;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, S);
	}
	
	private void dfs(Graph G, int V){
		marked[V] = true;
		for(int w: G.adj(V)){
			if(!marked[w]){
				edgeTo[w] = V;
				dfs(G, w);
			}
		}
	}
	
	private boolean hasPathTo(int V){
		return marked[V];
	}
	
	public Iterable<Integer> pathTo( int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		
		for(int x = v; x!= S; x = edgeTo[x]){
			path.push(x);			
		}
		path.push(S);		
		return path;
	}
	
	

	public static void main(String[] args) {
		
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DepthFirstPaths dfp = new DepthFirstPaths(G, s);
				
		for(int v = 0; v< G.V(); v++){
			StdOut.print(s + " to "+ v + ": ");
			if(dfp.hasPathTo(v)){
				for(int x : dfp.pathTo(v)){									
					if(x == s) StdOut.print("-"+x);
					else StdOut.print("-"+ x);
				}		
				StdOut.println();
			}
		}

	}

}
