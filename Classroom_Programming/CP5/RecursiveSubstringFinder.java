/*
   This program searches for substring sub in string s.
   The method returns -1 if it does not fing the substring, otherwise it returns the index in string s where the substring begins.

   Example
      If s is "Hello" and sub is "el", the method return 1
**/


public class RecursiveSubstringFinder
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.out.println("Please provide a string and substring as arguments.");
      }
      String s = args[0];
      String sub = args[1];
      int idx = recursiveSubstringFinder(s, sub, 0);
      System.out.println(idx);
   }
   public static int recursiveSubstringFinder(String s, String sub, int idx)
   {
      if (sub.length() > s.length())
      {
         return -1;
      }
      if (sub.equals(s))
      {
         return idx;
      }
      idx++;
      return recursiveSubstringFinder(s.substring(1, s.length()), sub, idx);
   }
}
