/**
   Tset class of ChessRook class
   
   @author A. Luchetta
   @version 20201021
*/
public class ChessRookTester
{
   public static void main(String[] args)
   {
      final String INITIAL_CHESS_SQUARE = "d5";
      final String MOVE1 = "d7";
      final String MOVE2 = "b7";
      final String MOVE3 = "b5";
      final String MOVE4 = "d5";
      final String MOVE5 = "e6";

      ChessRook b1 = new ChessRook(INITIAL_CHESS_SQUARE);     
      System.out.println(b1);
      
      b1.moveToSquare(MOVE1);
      System.out.println(b1);
      
      b1.moveToSquare(MOVE2);
      System.out.println(b1); 
           
      b1.moveToSquare(MOVE3);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE4);
      System.out.println(b1); 
      
      b1.moveToSquare(MOVE5);  // chess square not reachable
      System.out.println(b1);
      
      b1.moveToSquare("abc");  // invalid chess square
      System.out.println(b1);                     

      b1.moveToSquare("p9");  // invalid chess square
      System.out.println(b1);           
   }

}
