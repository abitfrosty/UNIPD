import java.util.Scanner;

public class PrimeNumberRicognizer
{
   public static void main(String[] args)
   {
      System.out.println("*** This program checks if an integer is prime number ***");
      
      Scanner scan = new Scanner(System.in);
      
      // User input of an integer
      int n = scan.nextInt();
      
      scan.close();
      
      int n_sqrt = (int) Math.floor(Math.sqrt(n));
      
      int divisor = 1;
      
      for (int i = 2; i <= n_sqrt; i++)
      {
         if (n % i == 0)
         {
            divisor = i;
            break;
         }
      }
      
      if (divisor == 1)
      {
         System.out.printf("The number %d is a prime number%n", n);
      } 
      else
      {
         System.out.printf("The number %d divides by %d%n", n, divisor);
      }
   }
}
