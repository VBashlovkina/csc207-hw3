package edu.grinnell.csc207.bashlovk.utils;

import java.math.BigInteger;

public class Calculator {
	/**
	   * Computes simple operations including addition, 
	   * subtraction, multiplication, division and
	   * exponentiation.
	   * 
	   * @param String expr 
	   *          the expression to evaluate
	   * @return the value of the expression
	   * @pre expr is non null. It consists exclusively of
	   * 	sequences of digits (integers) and the operators +, -, *, / or ^
	   * 	numbers and operators are separated by a space
	   *    every other element is an operator
	   * 	the first and the last element of the expression are numbers
	   * @post operations are done in the order in which they appear
	   * 	the value of the expression is returned
	   */
	public static BigInteger eval0(String expr) {
		String[] parsed = expr.split(" ");
		BigInteger soFar = new BigInteger(parsed[0]);
		String oper = new String("");
		for (int i = 1; i < parsed.length; i++) 
		{
			if (i % 2 != 0) // if i is odd, it's an operator
			{
				oper = parsed[i];
			} 
			else
			{
				BigInteger arg = new BigInteger(parsed[i]);
				if (oper.compareTo("+") == 0) 
					soFar = soFar.add(arg);
				else if (oper.compareTo("-") == 0)
					soFar = soFar.subtract(arg);
				else if (oper.compareTo("*") == 0)
					soFar = soFar.multiply(arg);
				else if (oper.compareTo("/") == 0)
					soFar = soFar.divide(arg);
				else if (oper.compareTo("^") == 0)
					soFar = soFar.pow(arg.intValue());
				else {
					System.out.println(":(");
					return null;
				}
			}// else (it's a number)
		}// for
		return soFar;
	}// eval0 (String)

}
