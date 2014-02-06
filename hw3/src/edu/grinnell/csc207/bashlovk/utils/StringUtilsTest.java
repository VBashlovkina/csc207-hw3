package edu.grinnell.csc207.bashlovk.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void splitAt1() 
	{
		assertArrayEquals (new String[] { "a", "b", "c" },
                StringUtils.splitAt ("a:b:c", ':'));
	}//splitAt1

	@Test
	public void splitAt2() 
	{
		assertArrayEquals (new String[] { "a", "b", "c" },
                StringUtils.splitAt ("a b c", ' '));
	}//splitAt2
	
	@Test
	public void splitAt3() 
	{
		assertArrayEquals (new String[] { "a:b:c" },
                StringUtils.splitAt ("a:b:c", ' '));	
	}//splitAt3
	@Test
	public void splitAt4() 
	{
		assertArrayEquals ("one field", new String[] { "a" },
                StringUtils.splitAt ("a", ':'));	
	}//splitAt4
	@Test
	public void splitAt5()
	{
		assertArrayEquals ("empty inner field", new String[] { "a", "", "c" },
                StringUtils.splitAt ("a::c", ':'));	
	}//splitAt5
	@Test
	public void splitAt6()
	{
		assertArrayEquals ("leading empty field", new String[] { "", "a" },
                StringUtils.splitAt (":a", ':'));	
	}//splitAt6
	@Test
	public void splitAt7()
	{
		assertArrayEquals ("trailing empty field", new String[] { "a", "" },
                StringUtils.splitAt ("a:", ':'));	
	}//splitAt7
	@Test
	public void splitAt8()
	{
		assertArrayEquals ("null", new String[] {""},
                StringUtils.splitAt ("", ':'));	
	}//splitAt8
	@Test
	public void splitAt9()
	{
		assertArrayEquals ("multiple chars", new String[] {"abc", "efg"},
                StringUtils.splitAt ("abc:efg", ':'));	
	}//splitAt9
	@Test
	public void splitCSV1()
	{
		assertArrayEquals (new String[] { "a", "b", "c" },
                StringUtils.splitCSV("a,b,c"));
	}//splitCSV1
	@Test
	public void splitCSV2()
	{
		assertArrayEquals (new String[] { "a,b", "c" },
                StringUtils.splitCSV("\"a,b\",c"));
	}//splitCSV2
	@Test
	public void splitCSV3()
	{
		assertArrayEquals (new String[] { "a", "b,b\"", "c" },
                StringUtils.splitCSV("a,\"b,b\"\"\",c"));	
	}//splitCSV3
	
	//@Test
	public void deLeet1()
	{
		assertEquals ("e", StringUtils.deLeet ("3"));
	}//deLeet1
	@Test
	public void deLeet2()
	{
		assertEquals ("leet", StringUtils.deLeet ("133+"));
	}//deLeet2
	@Test
	public void deLeet3()
	{
		assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
	}//deLeet3
}
