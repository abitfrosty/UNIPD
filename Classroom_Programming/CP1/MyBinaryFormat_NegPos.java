import java.util.Scanner;

public class MyBinaryFormat_NegPos
{
  public static void main(String[] args)
  {
    System.out.println("Welcome! This program converts decimal integer in the range [-128, 127] to binary 8-bit two's complement.");
    // Define binary 8-bit 2's complement size
    final byte BINARY_SIZE = 8;
    // User input of decimal number
    System.out.print("Enter decimal integer: ");
    Scanner scan = new Scanner(System.in);
    byte input = scan.nextByte();
    scan.close();
    // Define array of binary 8-bit 2's complement size
    byte[] numberBin = new byte[BINARY_SIZE];
    // Check for sign of the input
    if (input >= 0) {
      // Set most significant digit to "0" for positive numbers
      numberBin[0] = 0;
      // Convert from decimal to binary
      numberBin = fromDecToBin(input, numberBin);
    } else {
      // Set most significant digit to "1" for negative numbers
      numberBin[0] = 1;
      // Convert from decimal to binary
      numberBin = fromDecToBin((byte)(input + 128), numberBin);
    }
    // Print the result
    printBinary(numberBin);
    // Exit program
    System.exit(0);
  }
  public static byte[] fromDecToBin(byte numberDec, byte[] numberBin)
  {
    byte binarySize = (byte)numberBin.length;
    byte leftOver = numberDec;
    // Most significant digit is already assigned that's 1 less cycle
    byte loops = (byte)(binarySize - 1);
    for (int i = loops; i > 0; i--) {
      // Even gives 0, odd gives 1
      numberBin[i] = (byte)Math.round(leftOver % 2);
      // Keep integer part from the division for the next round
      leftOver /= 2;
    }
    return numberBin;
  }
  public static void printBinary(byte[] numberBin)
  {
    final String BINARY_PREFIX = "0b";
    final char BINARY_SPLITTER = '_';
    final byte BINARY_GROUP = 4;
    final byte BINARY_SIZE = (byte)numberBin.length;
    // 8/4 = 2 loops, 7/4 = 2 loops still to print the remaining 3 digits
    byte batches = (byte)(BINARY_SIZE / BINARY_GROUP + ((BINARY_SIZE % BINARY_GROUP > 0) ? 1 : 0));
    // Print prefix of the binary number
    System.out.print(BINARY_PREFIX);
    for (int i = 0; i < batches; i++) {
      // Print each group, last group might have less length
      for (int j = i * BINARY_GROUP; j < Math.min(BINARY_GROUP * (i + 1), BINARY_SIZE); j++) {
        System.out.print(numberBin[j]);
      }
      // Add splitter between groups
      if (i < batches -  1) {
        System.out.print(BINARY_SPLITTER);
      }
    }
    // Add linebreak after the output of converted binary number
    System.out.println();
  }
}
