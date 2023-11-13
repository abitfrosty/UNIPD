/**
   Chess is a game based on a square chessboard, composed by 64 smaller squares alternatively colored, and
   on 64 pieces and the Rook is one of them. Each chessboard square is described by
   the column letter (a b c d e f g h) and by the row number (1 2 3 4 5 6 7 8).
   During the game, a Rook is always placed on one of the squares and can move to another one.
*/
public class ChessRook
{
   // Init public constants of the chessboard
   public final char CHESS_MIN_X = 'a';
   public final char CHESS_MAX_X = 'h';
   public final char CHESS_MIN_Y = '1';
   public final char CHESS_MAX_Y = '8';
   
   // Init public constants of the rook
   public static final char ROOK_INITIAL_X = 'a';
   public static final char ROOK_INITIAL_Y = '1';
   
   private char rook_x;
   private char rook_y;
   
   public ChessRook(String xy)
   {
      if (isChessValidSquare(xy))
      {
         rook_x = xy.charAt(0);
         rook_y = xy.charAt(1);
      }
   }

   public ChessRook()
   {
      this(new String(new char[]{ROOK_INITIAL_X, ROOK_INITIAL_Y}));
   }
   
   public void moveToSquare(String xy)
   {
      if (isChessValidSquare(xy) && isRookReachableSquare(xy))
      {
         rook_x = xy.charAt(0);
         rook_y = xy.charAt(1);
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
   
   private boolean isRookReachableSquare(String xy)
   {
      if (!isChessValidSquare(xy))
      {
         return false;
      }
      
      return (xy.charAt(0) > rook_x || xy.charAt(0) < rook_x) && xy.charAt(1) == rook_y
             || (xy.charAt(1) > rook_y || xy.charAt(1) < rook_y) && xy.charAt(0) == rook_x;
   }
   
   public String toString()
   {
      return "The rook is on the square: " + rook_x + rook_y;
   }
}
