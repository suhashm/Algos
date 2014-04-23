package com.thinkjs.io;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;

//public class MaxPriorityQueue<key extends Comparable<key>> {
public class MaxPriorityQueue<key> implements Iterable<key> { 

	private key[] pq;
	private int n = 0;
	
	public MaxPriorityQueue(int size){
		pq = (key[]) new Comparable[size+1];
		//pq[0] = (key) "";
	}
	
	/*public MaxPriorityQueue(){
		pq = (key[]) new Comparable[];
	}*/
	
	
	private boolean less(int i, int j){
		if(pq[i]!=null && pq[j]!=null)
			return ((Comparable) pq[i]).compareTo(pq[j])<0;
		return false;
	}
	
	private void exch(int i, int j){
		key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	private void swim(int k){
		while(k<=n && less(k/2,k)){
			exch(k/2, k);
			k/=2;
		}
	}
	
	private void sink(int k){
		while(2*k<=n){
			int j = 2*k;
			if(j<n && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k=j;
		}
	}
	
	public boolean isEmpty(){
		return n == 0;
	}
	
	public void insert(key item){
		if(n >=(pq.length-1)){
			System.out.println("Cannot Add as the heap is full");
			return;
		}
		pq[++n] = item;
		swim(n);
	}
	
	public key delMax(){
		key max = pq[1];
		exch(1,n--);
		pq[n+1] = null;
		sink(1);
		return max;
	}
	
	public void show(){
		for(int i=0; i<pq.length;i++){
			System.out.print(pq[i]+" ");
		}
	}
	
	public static void main(String[] args) {
	
	MaxPriorityQueue<String> maxPQ = new MaxPriorityQueue<String>(6);
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(item.equals("-")){
				if(!maxPQ.isEmpty()){
					System.out.println("removed item is "+maxPQ.delMax());
					maxPQ.show();
				}else{
					System.out.println("Heap is empty and cannot remove any item");
				}
			}
			else{
				maxPQ.insert(item);
				maxPQ.show();
			}
		}
	}

	@Override
	public Iterator<key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
