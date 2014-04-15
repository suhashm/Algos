package com.thinkjs.io;

import java.io.BufferedReader;
import java.io.IOException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class FixedCapacityStackOfStrings {
	private String[] a ;
	private int n;
	public FixedCapacityStackOfStrings(int Capacity){
		a = new String[Capacity];
	}
	
	public int size(){ return n;}
	
	public boolean isEmpty() { return n==0;}
	
	public void push(String s){
		a[n++] = s;
	}
	
	public String pop(){
		if(!isEmpty()) return a[--n];
		else
			return null;
	}
	
	public void display(){
		for(int i=0;i<n;i++)
			System.out.print(a[i]);
	}
	

	public static void main(String[] args) throws IOException {
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		BufferedReader b = null;
		
		//while (!StdIn.isEmpty()){
			while (b.readLine() != null){
			String item = StdIn.readString();
			if(!item.equals("-")){
				s.push(item);
				s.display();
			}
			else
				StdOut.println(s.pop());
		}

	}

}