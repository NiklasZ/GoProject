public class GameEngine{
  /** Class to keep track of the current game of Go and make moves on the board */
  
  // Attributes
  /** Instance of LegalMoveChecker, used in functions to check the legality of moves */
  LegalMoveChecker moveChecker;
  /** The object representing the current Go board */
  Board currentBoard;
  
  // Operations
  /** Default Constructor */
  public void GameEngine(){
    // same as newGame?
    newGame();
  }
  
  /** Initialises a new game with a blank board */
  public void newGame(){
    currentBoard = new Board();
    moveChecker = new LegalMoveChecker();
  }

  /** Initialises a new game with a scenario on the board */
  public void newGame(Board board){
    currentBoard = board;
    moveChecker = new LegalMoveChecker();
  }

  /** Checks entire board for legal moves and returns them as a 2D boolean array */
  public Boolean[][] getLegalMoves(String colour){
    Boolean[][] legalMoves = new Boolean[19][19];
    for (int i; i<19; i++){
      for (int j; j<19; j++){
        legalMoves[i][j] = checkMove(currentBoard, i, j, colour);
      }
    }
    return legalMoves;
  }

  /** Returns the current board to the caller */
  public Board getCurrentBoard(){
    return currentBoard;
  }

  /**Places a piece at the co-ordinates (x,y) given a respective colour (black or white
  Checks whether the move is legal and if so, place the piece and return true
  if the move is illegal, return false */
  public Boolean makeMove(int x, int y, String colour){
    if (getLegalMoves(colour)[x][y]){
      currentBoard.set(x, y, colour);
      return true;
    }
    else
      return false;
  }

  