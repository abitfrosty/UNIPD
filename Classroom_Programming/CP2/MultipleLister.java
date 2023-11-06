import java.util.Scanner;

public class MultipleLister
{
   public static void main(String[] args)
   {
      System.out.println("*** This program counts multiples of \"n\" in the range [n, max] ***");
      
      System.out.println("Please enter integer \"n\" and integer \"max\":");
      
      Scanner scan = new Scanner(System.in);
      
      int n = scan.nextInt();
      int max = scan.nextInt();
      
      scan.close();
      
      String s = "";
      
      for (int i = max; i >= n; i--) 
      {
         if (i%n == 0)
            {
               s += i + " ";
            }
      }
      
      System.out.printf("Multiples of %d in the range [%d, %d] in desc order: %s%n", n, n, max, s);
      
   }
}
