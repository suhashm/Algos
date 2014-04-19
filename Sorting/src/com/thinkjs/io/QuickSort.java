package com.thinkjs.io;

import edu.princeton.cs.introcs.StdRandom;

public class QuickSort {
	
	public static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}
	
	public static void exch(Comparable[] a , int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static int partition(Comparable[] a, int lo, int hi){
		Comparable v = a[lo];
		int i = lo;
		int j = hi+1;
		while(true){
			while(less(a[++i], v)) if(i == hi) break;
			while(less(v, a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j );
		}
		exch(a, lo, j);
		return j;
	}
	
	public static void sort(Comparable[] a , int lo, int hi){
		if(hi<=lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	public static void Sort(Comparable[] a){
		int lo = 0;
		int hi = a.length - 1;
		StdRandom.shuffle(a);
		sort(a, lo, hi);
	}

	public static void main(String[] args) {
		
		Comparable[] a ={12, 3, 452, 44, 11};
		Sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
