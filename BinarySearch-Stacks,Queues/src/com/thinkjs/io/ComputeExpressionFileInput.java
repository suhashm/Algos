package com.thinkjs.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

import edu.princeton.cs.introcs.StdOut;

public class ComputeExpressionFileInput {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		//StringBuilder s = new StringBuilder();
		InputStream i = new FileInputStream("expression.txt");
		InputStreamReader ir = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(ir);
		int c = 0;
		while((c=br.read())!=-1){			
			//char s = (char) c;
			//s.append((char) c);
			String s = String.valueOf(br.read());
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
