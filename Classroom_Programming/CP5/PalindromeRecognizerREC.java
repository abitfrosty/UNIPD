/*
   Checks if a string is a palindrome and then prints the result of the check on standards output.
   This is a recursive solution.
**/

import java.lang.IllegalArgumentException;

public class PalindromeRecognizerREC
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
      
      System.out.printf("The word %s is %sa palindrome %n", s, isPalindromeREC(s) ? "" : "not ");
   }
   
   public static boolean isPalindromeREC(String s)
   {
      if (s.length() < 2)
      {
         return true;
      }
      if (s.charAt(0) != s.charAt(s.length() - 1))
      {
         return false;
      }
      return isPalindromeREC(s.substring(1, s.length() - 1));
   }
}
