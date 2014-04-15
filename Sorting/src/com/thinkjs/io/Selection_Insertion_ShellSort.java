package com.thinkjs.io;

import java.util.ArrayList;
import java.util.List;

public class Selection_Insertion_ShellSort {
	private int n;
	
	public static void SelectionSort(Comparable[] a){
		int n = a.length;
		for(int i = 0; i<n; i++){
			int min = i;
			for(int j=i+1;j<n;j++)
				if((less(a[j],a[min]))){
					min = j;
				}
			exch(a, i, min);
		}
	}
	
	public static void InsertionSort(Comparable[] a){
		int n = a.length;
		for(int i = 1;i < n; i++){
			for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
				exch(a, j, j-1);
			}
		}
	}
	
	public static void ShellSort(Comparable[] a){
		int n = a.length;
		int h = 1;
		while(h < n/3) h = 3*h+1;
		while(h>=1){
			for(int i=h;i <n;i++){
				for(int j=i; j >=h && less(a[j],a[j-h]); j-=h){
					exch(a, j, j-h);
				}			
			}
			h/=3;
		}
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t =  a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void Show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+ " ");
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//List<String> myList = new ArrayList<String>();
		List<Comparable> myList = new ArrayList<Comparable>();
		for(int i=0;i<args.length;i++){
			myList.add(args[i]);
		}
		Comparable[] s = myList.toArray(new Comparable[myList.size()]);
		//Comparable[] s = {12, 5};
		//Selection Sort
		SelectionSort(s);
		assert isSorted(s);
		System.out.print("Selection Sorted Array is ");
		Show(s);
		System.out.println();
		
		
		//Insertion Sort
		Comparable[] i = myList.toArray(new Comparable[myList.size()]);
		InsertionSort(i);
		assert isSorted(i);
		System.out.print("Insertion Sorted Array is ");
		Show(i);
		System.out.println();
		
		//Shell Sort
		Comparable[] ss = myList.toArray(new Comparable[myList.size()]);
		ShellSort(ss);
		assert isSorted(ss);
		System.out.print("Shell Sorted Array is ");
		Show(ss);

	}

}
