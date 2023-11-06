import java.util.Scanner;

public class MyBinaryFormatNeg
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome! This program converts negative decimal number from the range [-128, -1] to binary 2's complement.");
    System.out.print("Enter decimal: ");
    int input = scan.nextInt();
    scan.close();
    int a = input + 128;
    String binPart1 = "";
    String binPart2 = "";
    // 8th digit
    binPart1 = (int)(a % 2) + binPart1;
    a /= 2;
    // 7th digit
    binPart1 = (int)(a % 2) + binPart1;
    a /= 2;
    // 6th digit
    binPart1 = (int)(a % 2) + binPart1;
    a /= 2;
    // 5th digit
    binPart1 = (int)(a % 2) + binPart1;
    a /= 2;
    // 4th digit
    binPart2 = (int)(a % 2) + binPart2;
    a /= 2;
    // 3rd digit
    binPart2 = (int)(a % 2) + binPart2;
    a /= 2;
    // 2nd digit
    binPart2 = (int)(a % 2) + binPart2;
    a /= 2;
    // Print the result
    System.out.println("Converted: 0b0" + binPart2 + '_' + binPart1);
    System.exit(0);
  }
}
