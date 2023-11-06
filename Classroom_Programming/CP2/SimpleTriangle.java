import java.util.Scanner;

public class SimpleTriangle
{
   public static void main(String[] args)
   {
      System.out.println("*** This program defines a simple triangle in the Euclidean plane ***");
   }
   int side1 = 3;
   int side2 = 4;
   int side3 = 5;
   
   public SimpleTriangle​(int a, int b, int c)
   {
      side1 = a;
      side2 = b;
      side3 = c;      
   }
   
   public double area()
   {
      int p = perimeter();
      double s = p / 2;
      // Computes the area of this triangle
      double a = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
      
      return a;
   }
   
   public int perimeter()
   {
      // Computes the perimeter of this triangle
      int p = side1 + side2 + side3;
      
      return p;
   }
   
   public String toString()
   {
      // Returns the textual description of this triangle in the format "SimpleTriangle a b c" where a, b and c are the values of the sides of this triangle
      return "SimpleTriangle " + side1 + " " + side2 + " " + side3;
   }
}
