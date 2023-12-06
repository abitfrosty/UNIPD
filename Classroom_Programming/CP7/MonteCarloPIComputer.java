/**
   Monte Carlo methods, or Monte Carlo experiments, are a broad class of computational algorithms that 
   rely on repeated random sampling to obtain numerical results. The underlying concept is
   to use randomness to solve problems that might be deterministic in principle.
   They are often used in physical and mathematical problems and are most useful when it is difficult or
   impossible to use other approaches.
   
   Stop the generation of points when the error has the following values:
   1E-3
   1E-4
   1E-5
   1E-6
   1E-7
   1E-8
*/
import java.math.BigDecimal;
import java.util.Random;

public class MonteCarloPIComputer
{
   private static double[] errorThreshold = new double[6];
   private static int radius;
   
   public static void main(String[] args)
   {
      MonteCarloPIComputer simulation = new MonteCarloPIComputer();
      Random random = new Random();
      System.out.println("Starting simulation...");
      for (double threshold : simulation.errorThreshold)
      {
         double delta = 1.0;
         double inside = 0;
         double total = 1;
         System.out.println("====================================");
         System.out.printf("Current treshold: %.3e%n", threshold);
         while (delta > threshold)
         {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x*x + y*y < radius*radius)
            {
               inside++;
            }
            total++;
            delta = Math.abs(4 * inside/total - Math.PI);
            /**if (total % 100000 == 0)
            {
               System.out.printf("Current ERROR: %.10e, Pi: %.10e, delta: %.10e, inside: %.0f, total: %.0f%n", threshold, Math.PI, Math.abs(4 * inside/total - Math.PI), inside, total);
            }*/
         }
         System.out.printf("Final ERROR: %.3e, Pi: %.10e, delta: %.10e%n", threshold, Math.PI, delta);
      }
   }
   public MonteCarloPIComputer()
   {
      this(new double[]{BigDecimal.valueOf(1E-3).doubleValue(),
                        BigDecimal.valueOf(1E-4).doubleValue(),
                        BigDecimal.valueOf(1E-5).doubleValue(),
                        BigDecimal.valueOf(1E-6).doubleValue(),
                        BigDecimal.valueOf(1E-7).doubleValue(),
                        BigDecimal.valueOf(1E-8).doubleValue()}, 1);
   }
   public MonteCarloPIComputer(double[] errs, int r)
   {
      errorThreshold = errs;
      radius = r;
   }
}
