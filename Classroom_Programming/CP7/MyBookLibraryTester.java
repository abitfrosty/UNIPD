import java.util.Scanner;
/**
  * Test class of the MyBookLibrary class
  *
  * @see MyBookLibrary
  * @see MyBook
  *
  * @author: A. Luchetta
  * @version 04-12-2023
  */
public class MyBookLibraryTester
{
   public static void main(String[] args)
   {
      // constant definition
      final char COMMENT_CHAR = '#';
      final String SEPARATOR = "[:]+";
       
      // creation of a new book library
      MyBookLibrary bl = new MyBookLibrary();
      
      // readout of data from standard input and insertion of bookd into library
      Scanner in = new Scanner(System.in);
      while (in.hasNextLine())
      {
         // redout of new line
         String line = in.nextLine();
         
         // check if comment line
         if (line.length() == 0 || line.charAt(0) == COMMENT_CHAR)
         {
            continue;
         }
         
         // line decomposition
         Scanner tok = new Scanner(line);
         tok.useDelimiter(SEPARATOR);
         String author = tok.next();
         String title = tok.next();
         int year = Integer.parseInt(tok.next());        
         tok.close();
                 
         // insertion of new book in the library
         bl.add(author, title, year);
      }
      in.close();
      
      // print library on standard output
      System.out.println("Unsorted:");
      System.out.println(bl);
      
      MyBook[] bl_array = bl.toArray();

      MyBook.useCompare(MyBook.ComparisonBy.BY_AUTHOR);
      System.out.println("Sorted by author:");
      ArrayAlgorithms4.mergeSort(bl_array);
      for (MyBook e : bl_array)
      {
         System.out.println(e);
      }
      System.out.println();
      
      MyBook.useCompare(MyBook.ComparisonBy.BY_TITLE);
      System.out.println("Sorted by title:");
      ArrayAlgorithms4.mergeSort(bl_array);
      for (MyBook e : bl_array)
      {
         System.out.println(e);
      }
      System.out.println();
      
      MyBook.useCompare(MyBook.ComparisonBy.BY_YEAR);
      System.out.println("Sorted by year:");
      ArrayAlgorithms4.mergeSort(bl_array);
      for (MyBook e : bl_array)
      {
         System.out.println(e);
      }
   }
}

