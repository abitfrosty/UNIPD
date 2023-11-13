/** Triangular numbers
      The k-th triangular number Tk, k > 0, is given by the sum of

      k + (k - 1) + (k - 2) +…+ 2 + 1.

      Triangular numbers have the following property:

      T_1 = 1

      T_n = n + T_(n-1)     for n > 1
*/
import java.util.Scanner;

public class TriangularNumberGenerator
{
   public static final int INITIAL_T = 1;
   private static int k;
   
   public static void main(String[] args)
   {
      System.out.println("*** This program prints on standard output the first k-th triangular integers. ***");
      System.out.print("Please enter integer k: ");
      
      Scanner in = new Scanner(System.in);
      
      if (in.hasNextInt())
      {
         k = in.nextInt();
      }
      else
      {
         k = 1;
      }
      
      in.close();
      
      long t[] = new long[k + 1];
      t[1] = INITIAL_T;
      
      for (int n = 2; n <= k; n++)
      {
         t[n] = n + t[n - 1];
      }
      
      for (int i = 1; i <= k; i++)
      {
         System.out.printf("%d%n", t[i]);
      }
      System.exit(0);
   }
}
