package com.thinkjs.io;
import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;



public class BinarySearch {
	
	public static int rank(int key, int[] a){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			if(key < a[mid]) hi = mid-1;
			else if(key > a[mid]) lo = mid+1;
			else
				return key;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {24, 2, 33, 45, 25, 120};
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(a);
		Arrays.sort(whitelist);
		//int key = 44;
		/*if(rank(key, a) == -1){
			System.out.println("Not Found");
		}else{
			System.out.println("Key Found");
		}*/
	 	System.out.println("running");
		 // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                //StdOut.println(key);
            	System.out.println(key);
            else
            	System.out.println(" found");
        }
	 	System.out.println("Completed");
	}

}
