/**
   Prints the prime numbers less than or equal to the integer number n, n  > 1,
   where n is read from standard input.
*/
import java.util.Scanner;

public class EraPrimeLister
{
   public static final int INITIAL_N = 10;
   
   public static void main(String[] args)
   {
      System.out.println("*** This program prints the prime numbers in the range [1, n] ***");
      System.out.print("Please enter n (> 1): ");
      
      Scanner in = new Scanner(System.in);
      
      int n;
      
      if (in.hasNextInt())
      {
         n = in.nextInt();
      }
      else
      {
         n = INITIAL_N;
      }
      
      String primes = findPrimes(n);
      
      System.out.printf("Primes in the range [1, %d]: %s%n", n, primes);
   }
   
   private static String findPrimes(int n)
   {
      boolean[] isMultiple = new boolean[n];
      
      isMultiple[0] = true; // 1 is not prime

      for (int i = 2; i * i <= n; i++)
      {
         if (!isMultiple[i - 1]) // is prime
         {
            for (int j = i + i; j <= n; j += i)
               {
                  isMultiple[j - 1] = true;
               }
         }
      }
      
      String s = "";
      
      for (int i = 0; i < isMultiple.length; i++)
      {
         if (!isMultiple[i])
         {
            s += " " + (i + 1);
         }
      }
      return s;
   }
}
