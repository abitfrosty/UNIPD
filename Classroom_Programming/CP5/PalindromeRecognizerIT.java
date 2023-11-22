/*
   A palindrome is a word, number, phrase, or other sequence of symbols that reads the same backwards as forwards.
   Examples of palindrome strings: "madam", "radar", "neveroddoreven", "DoGeeseseeGoD"
   Code the executable PalindromeRecognizerIT.java class that checks if a string is a palindrome and
   then prints the result of the check on standard output.
   **/

import java.lang.IllegalArgumentException;

public class PalindromeRecognizerIT
{
   public static void main(String[] args)
   {
      String s = "";
      
      if (args.length == 0)
      {
         throw new IllegalArgumentException("Please provide a word as first argument");
      } 
      else
      {
         s = args[0];
      }
      
      System.out.printf("The word %s is %sa palindrome %n", s, isPalindromeIt(s) ? "" : "not ");
   }
   
   public static boolean isPalindromeIt(String s)
   {
      int i = 0;
      while (s.length() - i * 2 > 1)
      {
         String sub_s = s.substring(i, s.length() - i);
         if (sub_s.charAt(0)  != sub_s.charAt(sub_s.length() - 1))
         {
            return false;
         }
         i++;
      }
      return true;
   }
}
