package com.thinkjs.io;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Stopwatch;

public class ThreeSum {
	
	public static int count(int[] a){
		int n = a.length;
		int c = 0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					if(a[i]+a[j]+a[k] == 0){
						c++;
					}
				}
			}
		}
		return c;
	}

	public static void main(String[] args){
		//int[] a ={1, 2, -3};
		In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
		System.out.print("count is "+ count(a)+" time is "+timer.elapsedTime());
	}
}
