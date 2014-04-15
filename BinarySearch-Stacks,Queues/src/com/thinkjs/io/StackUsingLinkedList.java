package com.thinkjs.io;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdIn;

public class StackUsingLinkedList<Item> implements Iterable<Item> {
	
	private node first;
	//private Item [] a;
	private int n;
	
	private class node{
		Item item;
		node next;
	}
	
	public int size() {return n;}
	
	public boolean isEmpty() {return first == null;}
	
	public void push(Item item){
		node oldfirst = first;
		first = new node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}
	
	public Item pop(){
		Item value = first.item;
		first = first.next;
		n--;
		return value;
	}
	
	public void display(){
		for(node s =first ; s!=null;s=s.next){
			System.out.print(s.item);
		}
	}

	public static void main(String[] args) {
		StackUsingLinkedList<String> a = new StackUsingLinkedList<String>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			int n = 0;
			if(!item.equals("-")){				
				a.push(item);
				 n = a.size();
				System.out.print("Items count "+n+" "); a.display();
			}
			else{
				if(!a.isEmpty())
					System.out.println("popped value is "+ a.pop());
				else
					System.out.println("Empty stack");
				n = a.size();
				System.out.print("Items count "+n+" "); a.display();
			}
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
