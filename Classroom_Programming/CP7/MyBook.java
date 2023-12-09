/**
  * Defines a book
  * 
  * @author: A. Luchetta
  * @version 04-12-2023
  */
public class MyBook implements Comparable
{
   // private part
   private String author;  // book's author
   private String title;   // book's title
   private int year;       // book's publication year
   
   public static enum ComparisonBy {BY_AUTHOR, BY_TITLE, BY_YEAR}
   private static ComparisonBy compare = ComparisonBy.BY_AUTHOR;
   
   /** 
      Constructs a new book with the specified author, title, and publication
      year
      @param anAuthor the author of this book
      @param aTitle the title of this book
      @param aYear the publication year of this book
   */
   public MyBook(String anAuthor, String aTitle, int aYear)
   {
      author = anAuthor;
      title = aTitle;
      year = aYear;
   }
   
   @Override  // annotation to the compiler to check if method overrides the
              // equals method in class Object
   /**
      Checks if this book and the specified object are equal
      This method considers two books equal if they have the same author, 
      title, and publication year 
      @param other the object to be checked for equality
      @return true if this book and the specified object are equal
   */
   public boolean equals(Object other)
   {
      // check on argument
      if (!(other instanceof MyBook)) // if the object other is not a book
      {                               // it cannot be equal to this book
         return false;
      }
      
      // type cast
      MyBook b = (MyBook) other;
      
      return author.equals(b.author) && title.equals(b.title) && year == b.year;
   
   }
   
   @Override  // annotation to the compiler to check if method overrides the
              // equals method in class Object
   /**
      Checks if this book and the specified object are equal
      This method considers two books equal if they have the same author, 
      title, and publication year 
      @param other the object to be checked for equality
      @return true if this book and the specified object are equal
   */
   public int compareTo(Object other)
   {
      // type cast
      MyBook b = (MyBook) other;
      if (compare == ComparisonBy.BY_AUTHOR)
      {
         return author.compareTo(b.author);
      }
      else if (compare == ComparisonBy.BY_TITLE)
      {
         return title.compareTo(b.title);
      }
      else // comparison by year
      {
         return year - b.year;
      }
   }
   
   public static void useCompare(ComparisonBy item)
   {
      compare = item;
   }
   
   /** 
      Returns the author of this book
      @return the author of this book
   */
   public String getAuthor()
   {
      return author;
   }
   
   /** 
      Returns the title of this book
      @return the title of this book
   */
   public String getTitle()
   {
      return title;
   }       
   
   /** 
      Returns the publication year of this book
      @return the publication year of this book
   */
   public int getYear()
   {
      return year;
   } 
   
   /** 
      Returns the text description of this book in the format
      "Book: author, title, publication year"
      @return the textual description of this book
   */
   public String toString()
   {
      return "Book: " + author +", " + title + ", " + year;
   }        
}

