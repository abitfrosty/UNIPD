/**
  * Implements a library, that is a collection of books
  *
  * @see MyBook
  *
  * @author: A. Luchetta
  * @version 04-12-2023
  */
public class MyBookLibrary
{
   // private part - partially filled array
   private static final int INITIAL_CAPACITY = 1;
   private Object[] v;                        // note we use Object
   private int vSize;                         // item counter
   
   /**
      Constructs an empty library
   */
   public MyBookLibrary()
   {
      v = new MyBook[INITIAL_CAPACITY];  // polymorphism allows this statement
      vSize = 0;
   }
   
   /**
      Adds this book the the book library
      @param anAuthor this book's author
      @param aTitle this book's title
      @param aYear this book's publication year
      @throws IllegalArgumentException if anAuthor is null or aTitle is null
   */
   public void add(String anAuthor, String aTitle, int aYear)
   {
      // preconditions
      if (anAuthor == null || aTitle == null)
      {
         throw new IllegalArgumentException("author = " + anAuthor
                                        + " title = " + aTitle);
      }
      
      // dynamic resizing if needed
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
      }
      
      // insertion of the new book
      v[vSize++] = new MyBook(anAuthor, aTitle, aYear);
   }   
   
   /**
      Check if this book library is empty
      @return true if this book library is empty
   */ 
   public boolean isEmty()
   {
      return vSize <= 0;
   }
   
   /**
      removes from the library one of the  books with the specified author,
      title, and publication year 
      @param anAuthor the specified author
      @aTitle the specified title
      @aYear the specified year
   */
   public void remove(String anAuthor, String aTitle, int aYear)
   {
      // prerequisites
      if (anAuthor == null || aTitle == null) 
      {
         return;                       // no need to remove
      }
      
      // book to search
      MyBook s = new MyBook(anAuthor, aTitle, aYear);
      
      // linear search     
      for (int i = 0; i < vSize; i++) // Note: the loop end vSize
      {
         if (s.equals(v[i])) 
         {
            v[i] = v[vSize - 1];      // sequence is not important
            v[vSize - 1] = null;      // cleaning of duplicated item
            vSize--;                  // decrement of item counter
            return;                   
         }   
      }
   }
   
   /**
      Returns the number of books in this book library
      @return the number of books in this book library
   */
   public int size()
   {
      return vSize;
   }   
   
   /**
      Returns an arry containing the books in the library
      @return an arry containing the books in the library if the library is not
              empty, an empty array otherwise
   */
   public MyBook[] toArray()
   {
      MyBook[] a = new MyBook[vSize];
      
      for (int i = 0; i < vSize; i++)
      {
         a[i] = (MyBook)v[i];   // type cast is needed
      }
      
      return a;
   }
   /**
      Returns the textual desciption of this library in which each line contains
      a book in the format "author, title, publication year"
      @return textual description in which each book takes a line and each line
              has the format "author, title, publication year"
   */
   public String toString()
   {
      String s = "";
      
      for (int i = 0; i < vSize; i++)
      {
         MyBook e = (MyBook)v[i];
         s = s + e + "\n";
      }
      
      return s;
   }
}

