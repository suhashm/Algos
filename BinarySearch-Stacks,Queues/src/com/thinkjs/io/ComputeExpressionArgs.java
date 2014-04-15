package com.thinkjs.io;

import java.util.Stack;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class ComputeExpressionArgs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();		
		for(int i=0;i< args.length;i++){			
			String s = args[i];
			if(s.equals("(")) ;
			else if (s.equals("+"))  ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals(")")){
				String op = ops.pop();
				Double val = vals.pop();
				if(op.equals("+")) val = vals.pop() + val;
				else if(op.equals("-")) val = vals.pop() - val;
				else if(op.equals("*")) val = vals.pop() * val;
				else if(op.equals("/")) val = vals.pop() / val;
				else if(op.equals("sqrt")) val = Math.sqrt(val);
				vals.push(val);
			}
			else
				vals.push(Double.parseDouble(s));				
		}
		StdOut.println(vals.pop());

	}

}
