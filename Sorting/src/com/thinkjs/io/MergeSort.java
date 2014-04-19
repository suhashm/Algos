package com.thinkjs.io;

public class MergeSort {

	private static Comparable[] aux;
	
	public static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}
	
	public static void Merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo, j =mid+1;
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		for(int k=lo; k<=hi;k++){
			if(i > mid)   a[k] = aux[j++];
			else if( j > hi) a [k]= aux[i++];
			else if (less(aux[i], aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	public static void sort(Comparable[] a, int lo, int hi){
		if(hi<=lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a, lo , mid);
		sort(a, mid+1, hi);
		Merge(a, lo , mid, hi);
	}
	
	public static void Sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	public static void main(String[] args) {
		
		Comparable[] i = {90, 5, 44, 12, 35,390};
		Sort(i);
		for(int k = 0 ;k<i.length;k++){
			System.out.print(i[k]+" ");
		}
	}

}
