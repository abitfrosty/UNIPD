/**
Code the StringReverser.java class which reads a string of unknown length from standard input and then prints a string with the characters in reverse sequence on standard output
*/
import java.util.Scanner;

public class StringReverser
{
   public static void main(String[] args)
   {
      System.out.println("*** This program reads a string from stdin and outputs it in reverse order ***");
      System.out.print("Please enter sentence: ");
      Scanner in = new Scanner(System.in);
      String s = "";
      String s_rev = "";
      if (in.hasNextLine())
      {
         s = in.nextLine();
         
         for (int i = 0; i < s.length(); i++)
         {
            s_rev = s.charAt(i) + s_rev;
         }
         System.out.printf("'%s' reversed: '%s'%n", s, s_rev);
      }
      in.close();
      System.exit(0);
   }
}
