package com.thinkjs.io;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.algs4.*;

public class Graph {
	
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	
	//Constructor with number of Vertices mentioned
	public Graph(int v){
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[v];
		for(int i = 0; i< v; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	
	//constructor with graph from InputStream
	public Graph(In in){
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	
	//Adding edge between two vertices
	private void addEdge( int u, int w){
		adj[u].add(w);
		adj[w].add(u);
		E++;
	}
	
	//Number of vertices in a graph
	public int V() { return V;}
	
	//Number of edges in a graph
	public int E() { return E;}
	
	//Return an Iterable object
	public Iterable<Integer> adj(int V){
		return adj[V];
	}
	
	//Compute Degree of Vertex V
	public static int degree(Graph G, int v){
		int degree = 0;
		for(int w: G.adj(v)) degree++;
		return degree;
	}
	
	//Compute max Degree for a graph
	public static int maxDegree(Graph G){
		int max = 0;
		for(int v = 0; v<G.V(); v++){
			if(degree(G, v) > max)
				max = degree(G, v);
		}
		return max;		
	}
	
	//Compute average degree
	public static int averageDegree(Graph G){
		return 2*G.E()/G.V();
	}
	
	//Compute number of self loops
	public static int selfLoops(Graph G){
		int count = 0;
		for(int i = 0; i<G.V(); i++){
			for(int w: G.adj(i)){
				if(w == i) count++;
			}
		}
		return count/2; // each edge counted twice
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
	}
	
	/*public static void main(String[] args) {
		In in = new In(args[0]);
		Graph g = new Graph(in);
		StdOut.println(g);
	}*/

}
