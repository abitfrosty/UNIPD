/**
   This program prints on standard output the substrings of a given string passed as an argument on the command line.

   Execution example:
      $java SubstringGeneratorREC givenString

      where givenString is the substrings generator.

   Example of substrings generation:

      The substring set of the string "abcde" is {a b c d e ab bc cd de abc bcd cde abcd bcde abcde}.
*/

import java.lang.IllegalArgumentException;

public class SubstringGeneratorREC
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         throw new IllegalArgumentException("Please provide a word as first argument");
      }
      String s = args[0];
      String[] sub = substringsREC(s);
      for (String e : sub)
      {
         System.out.println(e);
      }
   }
   public static String[] substringsREC(String s)
   {
      // Preconditions
      if (s == null)
      {
         throw new IllegalArgumentException();
      }
      // Base case
      if (s.length() < 1)
      {
         return new String[s.length()];
      }
      // Substrings that contain first char
      int k = 0;
      String[] sub_1 = new String[s.length()];
      for (int i = 0; i < s.length(); i++)
      {
         sub_1[i] = s.substring(0, 1 + k++);
      }
      // Recursive call
      String[] sub_2 = substringsREC(s.substring(1));
      // Union
      int length = sub_1.length + sub_2.length;
      String[] sub = new String[length];
      k = 0;
      for (String e : sub_1)
      {
         sub[k++] = e;
      }
      for (String e : sub_2)
      {
         sub[k++] = e;
      }
      return sub;
   }
}
