import java.util.Scanner;

public class StdInOut
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      double sum = 0;
      double num;
      String expression = "";
      String operator = " + ";
      
      while (in.hasNextDouble())
      {
         num = in.nextDouble();
         sum += num;
         expression += num + operator;
      }
      
      System.out.println(expression.substring(0, expression.length() - operator.length()) + " = " + sum);
   }
}
