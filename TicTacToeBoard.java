import java.util.*;

class TicTacToeBoard
{
    private char[][] gameBoard = new char[][] { { ' ', ' ', ' ' },
                                                { ' ', ' ', ' ' },
                                                { ' ', ' ', ' ' } };
    private int numOfMoves;


    // converts game board to printable string
    public String toString()
    {
        return "|" + String.valueOf(gameBoard[0][0]) + " " + String.valueOf(gameBoard[0][1]) + " " + String.valueOf(gameBoard[0][2]) + "|\n"
        + "|" + String.valueOf(gameBoard[1][0]) + " " + String.valueOf(gameBoard[1][1]) + " " + String.valueOf(gameBoard[1][2]) + "|\n"
        + "|" + String.valueOf(gameBoard[2][0]) + " " + String.valueOf(gameBoard[2][1]) + " " + String.valueOf(gameBoard[2][2]) + "|\n";
    }

    // checks if move is valid, and if it is, changes the board
    public boolean makeMove(int row, int col, char c)
    {
        if (row >=1 && row <= 3 && col >=1 && col <= 3)
        {
            if (gameBoard[row-1][col-1] != ' ')
            {
                return false;
            }
            else
            {
                gameBoard[row-1][col-1] = c;
                numOfMoves++;
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    // checks the board to see if there are three of the same characters horizontally, vertically, or diagonally - returns t / f
    public boolean isWin()
    {
        for (int i = 0; i < gameBoard.length; i++)
        {

            if (gameBoard[i][0] != ' ' && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2])
            {
                return true;
            }
            else if (gameBoard[0][i] != ' ' && gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i])
            {
                return true;
            }
            else if ((gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) ||
                     (gameBoard[0][2] != ' ' && gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]))
            {
                return true;
            }
        }
        return false;

    }

    // after 9 moves without a win, all spaces are covered, so it returns that the game has resulted in a tie
    public boolean isTie()
    {
        if (numOfMoves == 9 && isWin() == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
