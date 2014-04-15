package com.thinkjs.io;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;

public class ThreeSumFast {

	public static int count(int[] a){
		int n = a.length;
		int c =0;
		Arrays.sort(a);
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int k = Arrays.binarySearch(a, -(a[i]+a[j]));
				if(k > j) c++; 
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in = new In(args[0]);
		int[] a = in.readAllInts();
		System.out.print("count is " +count(a));
	}

}
