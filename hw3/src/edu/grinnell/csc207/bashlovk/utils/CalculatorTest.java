package edu.grinnell.csc207.bashlovk.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void eval01() {
		assertEquals ("single number", 
				BigInteger.valueOf (0), Calculator.eval0 ("0"));
	}//eval01
	@Test
	public void eval02() {
		assertEquals ("single operation", 
				BigInteger.valueOf (2), Calculator.eval0 ("1 + 1"));
	}//eval02
	@Test
	public void eval03() {
		assertEquals ("same operation", 
				BigInteger.valueOf (4), Calculator.eval0 ("1 + 2 + 1"));
	}//eval03
	@Test
	public void eval04() {
		assertEquals ("different operations", 
				BigInteger.valueOf (9), Calculator.eval0 ("1 + 2 * 3"));
	}//eval04
	@Test
	public void eval05() {
		BigInteger reallyBig = new BigInteger("2"); 
		reallyBig = reallyBig.pow(64);
		assertEquals ("really big number", reallyBig,
				Calculator.eval0 ("2 ^ 64"));
	}//eval05
	@Test
	public void eval06() {
		assertEquals ("all operations",
				BigInteger.valueOf (32), 
				Calculator.eval0 ("1 + 4 * 3 / 5 - 1 ^ 5"));
	}//eval06
}
