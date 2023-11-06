// Defines a simple car on the track
public class SimpleCar
{
   // public constants
   /** Initial speed - value is set to 10 km/h */
   public final double INITIAL_SPEED = 10;

   /** Lower gear - value is set to neutral (0 means neutral) */
   public final int MIN_GEAR = 0;

   /** Upper gear - value is set to 6 */
   public final int MAX_GEAR = 6;
      
   /** percentage of speed increment - value is set to 50% */
   public final double SPEED_INCREMENT_PERCENT = 0.5;

   /** percentage of speed decrement - value is set to 30% */
   public final double SPEED_DECREMENT_PERCENT = 0.3;
   
   public double speed;
   public int gear;
   
   public static void main(String[] args)
   {
      System.out.println("*** This program defines a simple car on the track ***");
   }
   
   public SimpleCar()
   {
      // initialize this car with zero speed and neutral gear
      speed = 0;
      gear = MIN_GEAR;
   }
   
   public void speedUp()
   {
      /** if the gear is other than neutral, sets the speed to INITIAL_SPEED if the car is stationary,
       otherwise increases the speed by SPEED_INCREMENT_PERCENT. If the gear is neutral, the speed is not increased
      Examples: if the gear is not neutral and the car is stationary the speed becomes 10 km/h.
       If, instead, the gear is not neutral and the car speed is equal to 50 km/h, the new speed becomes 75 km/h. */
      if (speed == 0 && gear != MIN_GEAR)
      {
         speed = INITIAL_SPEED;
      }
      else if (gear == MIN_GEAR)
      {
         // Speed doesn't change
      }
      else
      {
         speed += speed * SPEED_INCREMENT_PERCENT;
      }
   }
   
   public void brake()
   {
      /** decreases the speed by the SPEED_DECREMENT_PERCENT, if the speed is greater than the INITIAL_SPEED, otherwise it stops the car
      Example: if the car speed is 100 km/h, the new speed becomes 70 km/h, If the speed is 5 km/h, the new speed becomes zero */
      if (speed > INITIAL_SPEED)
      {
         speed = speed * SPEED_DECREMENT_PERCENT;
      }
      else
      {
         speed = 0;
      }
   }
   
   public void gearUp()
   {
      // increases the gear unless it has already reached the max value
      if (gear < MAX_GEAR)
      {
         gear++;
      }
   }
   public void gearDown()
   {
      // decreases the gear unless it has already reached the min value
      if (gear > MIN_GEAR)
      {
         gear--;
      }
   }
   public String toString()
   {
      /** returns the textual description of this simple car in the format:
      "SimpleCar: gear = g, speed = v km/h"
      where g and v are respectively the gear and speed values of this car */
      return "SimpleCar: gear = " + gear + ", speed = " + speed + " km/h";
   }
}
