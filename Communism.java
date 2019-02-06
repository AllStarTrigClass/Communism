/**
 * Connect Communism: The original vertical destroy the bourgeoisie game.
 */
import java.util.Scanner;
public class Communism {
  
  
  public static void main(String[] args) 
  {
    Boolean full = true;
    String name1 = "";
    String name2 = "";
    int turn = 0;
    int col = 0;
    int winner = 0;
    Scanner input = new Scanner(System.in);
    int[][] board = new int[6][7];
    for(int i = 0; i <= board.length - 1; i++)
    {
      for(int j = 0; j <= board[i].length - 1; j++)
      {
        board[i][j] = 0;
      }
    }
    System.out.println("Welcome to Connect Four! Player 1, enter a name!");
    name1 = input.nextLine();
    System.out.println("Player 2, enter a name!");
    name2 = input.nextLine();
    while(true)
    {
      full = true;
      if(turn != 1)
      {
        turn = 1;
      } else 
      {
        turn = 2;
      }
        printBoard(board);
        if(turn == 1)
        {
          System.out.println(name1 + ", choose a column to put your piece in! (1-6)");
        } else 
        {
          System.out.println(name2 + ", choose a column to put your piece in! (1-6)");
        }
        while(true)
        {
          col = input.nextInt();
          if(col >= 1 && col <= 7)
          {
            for(int i = 0; i <= board.length - 1; i ++)
            {
              if(board[i][col - 1] == 0)
              {
                full = false;
              }
            }
            if(!full)
            {
              board = insertPiece(board, col, turn);
              break;
            } else 
            {
              System.out.println("Column full! Choose a different one.");
            }
          } else 
          {
            System.out.println("Invalid choice! Please enter an integer from 1-6");
          }
        }
      winner = checkForWinner(board);
      if(winner != 0)
      {
        break;
      }
    }
    switch(winner)
    {
      case 1:
        System.out.println(name1 + " wins!");
        break;
      case 2:
        System.out.println(name2 + " wins!");
        break;
      default:
        System.out.println("You broke the game! Nobody wins.");
        break;
    }
  }
  public static int checkForWinner(int[][] board)
  {
    for(int i = 0; i <= board.length - 1; i++)
    {
      for(int j = 0; j <= board[i].length - 1; j++)
      {
        if(i <= board.length - 4)
        {
         if(board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j] && board[i][j] != 0)
          {
            return board[i][j];
          } 
        }
        if(j <= board[i].length - 4)
        {
          if(board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3] && board[i][j] != 0)
          {
            return board[i][j];
          } 
        }
        if(i <= board.length - 4 && j <= board[i].length - 4)
        {
          if(board[i][j] == board[i+1][j + 1] && board[i][j] == board[i+2][j + 2] && board[i][j] == board[i+3][j + 3] && board[i][j] != 0)
          {
            return board[i][j];
          } 
        }
        if(i <= board.length - 4 && j > board.length - 4)
        {
          if(board[i][j] == board[i+1][j -1] && board[i][j] == board[i+2][j - 2] && board[i][j] == board[i+3][j - 3] && board[i][j] != 0)
          {
            return board[i][j];
          } 
        }
      }
    }
    return 0;
  }
  public static int[][] insertPiece(int[][] board, int col, int player)
  {
    Boolean pieceDown = false;
    for(int i = board.length - 1; i >= 0; i--)
    {
      if(board[i][col - 1] == 0 && !pieceDown)
      {
        board[i][col - 1] = player;
        pieceDown = true;
      }
    }
    return board;
  }
  public static void printBoard(int[][] board)
  {
    for(int i = 0; i <= board.length - 1; i++)
    {
      for(int j = 0; j <= board[i].length - 1; j++)
      {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
  
  /* ADD YOUR CODE HERE */
  
}
