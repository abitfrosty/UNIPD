import java.util.Scanner;

public class Input
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Input and integer: ");
    int number = input.nextInt();
    input.close();
    System.out.println("You have entered: " + number);
    System.exit(0);
  }
}
