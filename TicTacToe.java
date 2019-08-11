import java.util.*;

class TicTacToe
{
    // establishes player1 and player2, prints rules, then loops moves until there is a win or a tie
    public static void main(String[] args)
    {
        TicTacToeBoard board = new TicTacToeBoard();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome! Tic tac toe is a two player game.");

        System.out.print("Enter player one's name: ");
        String playerOne = keyboard.next();

        System.out.print("Enter player two's name: ");
        String playerTwo = keyboard.next();

        printRules();

        System.out.println("\nGame board:");
        System.out.println(board);

        while (board.isWin() == false && board.isTie() == false)
        {
            playerMove(playerOne, board, 'X');
            if (checkTieOrWin(playerOne, board))
            {
                break;
            }

            playerMove(playerTwo, board, 'O');
            if (checkTieOrWin(playerTwo, board))
            {
                break;
            }
        }
    }

    // prints the rules of tic tac toe
    public static void printRules()
    {
        System.out.printf("\nPlayers take turns marking a square.\nOnly squares not already marked can be picked.\nOnce a player has ");
        System.out.printf("marked three squares in a row, he or she wins!\nIf all squares ");
        System.out.printf("are marked and no three squares are the same, a tied game is declared. Have Fun!\n");
    }

    // takes input from player for move, then if it is valid changes the board using that player's character
    public static void playerMove(String player, TicTacToeBoard board, char c)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("It is %s's turn.\nPick a row between 1 and 3: ", player);
        int row = keyboard.nextInt();
        System.out.printf("Pick a column between 1 and 3: ");
        int col = keyboard.nextInt();
        if (board.makeMove(row, col, c) == false)
        {
            do
            {
                System.out.println("ILLEGAL CHOICE! TRY AGAIN...");
                System.out.printf("Pick a row between 1 and 3: ");
                row = keyboard.nextInt();
                System.out.printf("Pick a column between 1 and 3: ");
                col = keyboard.nextInt();
            } while (board.makeMove(row, col, c) == false);
        }

        System.out.println("\nGame board:");
        System.out.println(board);

    }

    // checks if there is a win or a tie, returns true or false
    public static boolean checkTieOrWin(String player, TicTacToeBoard board)
    {
        if (board.isTie() == true)
        {
           System.out.println("Tie game. Thanks for playing!");
           return true;
        }
        else if (board.isWin() == true)
        {
            System.out.printf("Game over! %s wins!\n", player);
            return true;
        }
        else
        {
            return false;
        }
    }
}