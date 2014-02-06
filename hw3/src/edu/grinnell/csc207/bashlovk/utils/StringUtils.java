package edu.grinnell.csc207.bashlovk.utils;

import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Credits:
 * overall: I went to the mentor session on Monday and Earnest went over 
 * each exercise briefly.
 * splitAt:
 * Asked Alex Greenberg about a more efficient way to initialize 
 * the result string other than counting separators with a for loop.
 * She said she did the same exact thing.
 * splitCSV:
 * Talked to Eli, Alex, Helen and Graeme
 * deLeet:
 * Peter Dixon helped me debug it.
 * 
 */
public class StringUtils
{

  /**
   * Separate string at the given character
   * 
   * @param str
   *          , a string
   * @param separator
   *          , the character at which the string should be separated
   * @return the array of substrings after splitting
   * @pre none
   */

  public static String[] splitAt(String str, char separator)
  {

    // try to implement with variable size arrays.
    // think about concat
    // ArrayList<String> temp = new ArrayList<String>();
    int length = 0;
    for (int j = 0; j < str.length(); j++)
      {
        if (str.charAt(j) == separator)
          length++;
      }
    length++;
    String[] result = new String[length];
    int index = 0;
    int nextIndex;
    int counter = 0;
    while (str.indexOf(separator, index) != -1)
      {
        nextIndex = str.indexOf(separator, index);
        result[counter] = str.substring(index, nextIndex);
        counter++;
        index = nextIndex + 1;
      }
    result[counter] = str.substring(index);
    return result;
  } // splitA

  /**
   * Separate string at commas using CSV format
   * 
   * @param str
   *          , a string
   * @return the array of substrings after splitting
   * @pre the string complies with CSV format
   */
  public static String[] splitCSV(String str)
  {

	ArrayList<String> tempArray = new ArrayList<String>();
	char ch;
	int currentIndex = 0, commaIndex, quoteIndex, numberOfQuotes, doubleQuoteIndex;
	String element = new String("");
	while (str.indexOf(',', currentIndex+1) != -1)
	      {
	         //if there are both commas and slashes
	        quoteIndex = str.indexOf('\"', currentIndex);
	        commaIndex = str.indexOf(',', currentIndex+1); 
	            if (commaIndex < quoteIndex)// if comma precedes the quote
	              {
	                tempArray.add(str.substring(currentIndex,commaIndex));
	                currentIndex = commaIndex;
	              }//if comma comes first
	            else //otherwise 
	              {
	                currentIndex = quoteIndex;
	                numberOfQuotes = 1;
	                for (int j = currentIndex+1; j<str.length(); j++)
	                  {
	                    
	                    ch = str.charAt(j);
	                   
	                    if (ch  == ',')
	                      {
	                      
	                      //if it's the comma after an even number of quotes
	                      //add the substring
	                      if (numberOfQuotes % 2 == 0)
	                        {
	                          element = str.substring(currentIndex+1, j-1);
	                         //getting rid of double quotes
	                          StringBuffer sb = new StringBuffer(element);
	                          
	                          while ((doubleQuoteIndex = sb.indexOf("\"\"")) != -1)
	                               {
	                                 sb.deleteCharAt(doubleQuoteIndex);
	                                 if (sb.indexOf("\"\"", doubleQuoteIndex) != -1)
	                                     doubleQuoteIndex = sb.indexOf("\"\"", doubleQuoteIndex);
	                               }
	                          element = sb.toString();
	                          
	                          tempArray.add(element);
	                         
	                          currentIndex = j;
	                          break;
	                        }
	                      }
	                    else if (ch == '\"')
	                      {
	                        numberOfQuotes++;
	                      }
	                      
	                  }//for loop checking commas surrounded by strings
	              }// if the quote precedes the comma
	       
	      }//big while
	 tempArray.add(str.substring(currentIndex+1));
	 String[] resultArray = new String[tempArray.size()];
	 resultArray = tempArray.toArray(resultArray);
         return resultArray; 
 }//split CSV
	
  /*Translates leet into English
   * @param str, string in leet or English
   * @pre the string str consists entirely of letters and leet symbols. For
   * instance, | can only be used as a part of b or n.
   */
  public static String deLeet(String str)
  {

    String string = new String("");
    Character ch = new Character('0');
    // Go through the string
    // and look for characters that are potentially in 133+
    for (int i = 0; i < str.length(); i++)
      {
        ch = str.charAt(i);
        if (ch == '@')
          string = string.concat("a");
        else if (ch == '|')// it's either b or n
          {
            i++;
            if (str.charAt(i) == '3') // then it's b
              string = string.concat("b");
            else
              // otherwise it's n
              {
                string = string.concat("n");
                i++;
              }
          }
        else if (ch == '3')
          string = string.concat("e");
        else if (ch == '1')
          string = string.concat("l");
        else if (ch == '0')
          string = string.concat("o");
        else if (ch == '+')
          string = string.concat("t");
        // if nothing matched, then it must be a regular character
        else
          string = string.concat(ch.toString());
      }// for
    return string;
  }// deLeet(str)

  /**
   * Display a rhyme based on a given name (implementation of the Name Game by
   * Shirley Ellis)
   * 
   * @param str
   *          a name
   * @pre the name is capitalized, contains a vowel but does not start with it
   * @post the rhyme is displayed
   */
  public static void nameGame(String name)
  {
    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
    char ch;
    String ending = name;
    int i, j;
    PrintWriter pen = new PrintWriter(System.out, true);
    // Finding the ending of the name (after the first vowel)
    for (i = 0; i < name.length(); i++)
      {
        ch = name.charAt(i);
        for (j = 0; j < 5; j++)
          if (ch == vowels[j])
            {
              ending = name.substring(i);
              break;
            }
        if (ending != name)
          break;
      }// outer for
       // Printing out the rhyme
    pen.println(name + "!");
    pen.println(name + ", " + name + " bo B" + ending + " Bonana fanna fo F"
                + ending);
    pen.println("Fee fy mo M" + ending + ", " + name + "!");
  }// nameGame(String)

  
  //Used for testing the output of nameGame
  public static void main(String[] args)
    throws Exception
  {

    nameGame("Shirley");
    nameGame("Lincoln");
    nameGame("Rebelsky");
    nameGame("Wesley");
    nameGame("Dana");
    nameGame("Strahinja");
   /*
    * Output: as expected
Shirley!
Shirley, Shirley bo Birley Bonana fanna fo Firley
Fee fy mo Mirley, Shirley!
Lincoln!
Lincoln, Lincoln bo Bincoln Bonana fanna fo Fincoln
Fee fy mo Mincoln, Lincoln!
Rebelsky!
Rebelsky, Rebelsky bo Bebelsky Bonana fanna fo Febelsky
Fee fy mo Mebelsky, Rebelsky!
Wesley!
Wesley, Wesley bo Besley Bonana fanna fo Fesley
Fee fy mo Mesley, Wesley!
Dana!
Dana, Dana bo Bana Bonana fanna fo Fana
Fee fy mo Mana, Dana!
Strahinja!
Strahinja, Strahinja bo Bahinja Bonana fanna fo Fahinja
Fee fy mo Mahinja, Strahinja!
    */
  }//main
}//StringUtils
