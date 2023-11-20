// Computes the arithmetic mean and the standard deviation of a set X of integer numbers

import java.util.Scanner;
import java.util.Arrays;

public class MyStatistics
{
   public static final int INITIAL_ARRAY_SIZE = 10;
   public static final String END_OF_DATA = "";
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int[] integers = new int[INITIAL_ARRAY_SIZE];
      int idx = 0;
      
      for (int i = 0; in.hasNextLine(); i++)
      {
         String nextLine = in.nextLine();
         
         if (nextLine.equals(END_OF_DATA))
         {
            break;
         }
         
         String[] batch = nextLine.split("\\s+");
         
         for (int j = 0; j < batch.length; j++)
         {
            if (integers.length < (i + 1) * batch.length)
            {
               integers = increaseArray(integers);
            }
            idx = i * batch.length + j;
            System.out.printf("batch[%d] = %s%n", j, batch[j]);
            integers[idx] = Integer.parseInt(batch[j]);
         }
      }
      
      in.close();
      
      if (integers.length == 0)
      {
         System.out.println("Please provide data");
         System.exit(0);
      }
      
      if (idx < integers.length)
      {
         integers = decreaseArray(integers, idx);
      }
      
      double mean = computeMean(integers);
      double std = computeStd(integers, mean);
      
      System.out.printf("Mean: %.2f, std: %.2f%n", mean, std);
   }
   
   private static int[] increaseArray(int[] oldArray)
   {
      int[] newArray = new int[oldArray.length * 2];
      
      for (int i = 0; i < oldArray.length; i++)
      {
         newArray[i] = oldArray[i];
      }
      return newArray;
   }

   private static int[] decreaseArray(int[] oldArray, int idx)
   {
      int[] newArray = new int[idx + 1];
      System.arraycopy(oldArray, 0, newArray, 0, idx + 1);
      
      return newArray;
   }
   
   private static double computeMean(int[] integers)
   {
      double sum = 0;
      int n = 0;
      for (int e : integers)
      {
         sum += e;
      }
      double mean = sum / integers.length;
      return mean;
   }
   
   private static double computeStd(int[] integers, double mean)
   {
      double std_sq = 0;
      int n = 0;
      for (int e : integers)
      {
         std_sq += (e - mean) * (e - mean);
      }
      std_sq /= integers.length;
      return Math.sqrt(std_sq);
   }
}
