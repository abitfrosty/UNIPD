/**
   Chess is a game based on a square chessboard, composed by 64 smaller squares alternatively colored,
   and on 64 pieces and the king is one of them. Each chessboard square is described by
   the column letter (a b c d e f g h) and by the row number (1 2 3 4 5 6 7 8).
   During the game, the king is placed in one of the squares and it can move to another one.
*/
public class ChessKing
{
   // Init public constants of the chessboard
   public final char CHESS_MIN_X = 'a';
   public final char CHESS_MAX_X = 'h';
   public final char CHESS_MIN_Y = '1';
   public final char CHESS_MAX_Y = '8';
   
   // Init public constants of the King
   public static final char KING_INITIAL_X = 'a';
   public static final char KING_INITIAL_Y = '1';
   
   private char king_x;
   private char king_y;
   
   public ChessKing(String xy)
   {
      if (isChessValidSquare(xy))
      {
         king_x = xy.charAt(0);
         king_y = xy.charAt(1);
      }
   }

   public ChessKing()
   {
      this(new String(new char[]{KING_INITIAL_X, KING_INITIAL_Y}));
   }
   
   public void moveToSquare(String xy)
   {
      if (isChessValidSquare(xy) && isKingReachableSquare(xy))
      {
         king_x = xy.charAt(0);
         king_y = xy.charAt(1);
      }
   }
   
   private boolean isChessValidSquare(String xy)
   {
      return xy.length() == 2
             && xy.charAt(0) >= CHESS_MIN_X 
             && xy.charAt(0) <= CHESS_MAX_X
             && xy.charAt(1) >= CHESS_MIN_Y 
             && xy.charAt(1) <= CHESS_MAX_Y;
   }
   
   private boolean isKingReachableSquare(String xy)
   {
      return Math.abs(xy.charAt(0) - king_x) <= 1 &&
             Math.abs(xy.charAt(1) - king_y) <= 1 &&
             Math.abs(xy.charAt(0) - king_x) + Math.abs(xy.charAt(1) - king_y) > 0;
   }
   
   public String toString()
   {
      return "The King is on the square: " + king_x + king_y;
   }
}
