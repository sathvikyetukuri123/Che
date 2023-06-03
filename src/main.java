import java.util.*;
//Sathvik Y per.2
public class main {

    //creates board for the checkers game
    private static board board2 = new board();

    //until there is only one player left the game keeps looping and continuing with this while loop
    public static void main(String args[]){

        board2.display();
        while (!endgame()) {
            execute();
            board2.display();
        }
        //displays the winner of the match
        System.out.println("The winner is " + winner());
    }

    //takes in the inputted coordinates so board can adjust to that and game can continue
    public static void execute(){

        Scanner scan = new Scanner(System.in);

        if (board2.getPlayerTurn()=='r')
            System.out.println("It's red's turn.");
        else
            System.out.println("It's black's turn.");

        boolean move = false;
        while (!move) {
            System.out.println("Enter from square you are moving from.");
            System.out.print("For example if you are moving from x=0 y=0 enter 00.");
            int og = scan.nextInt();

            System.out.print("Enter from the square you would like to move to. ");
            int end = scan.nextInt();

            if (check(og,end)) {
                executeMove(og,end);
                move = true;
            }
            else
                //ensures errors are accounted for
                System.out.println("That move cannot happen try again.");
        }
        //flips turn into other player's
        if (board2.getPlayerTurn() == 'r')
            board2.setTurn('b');
        else
            board2.setTurn('r');
    }

    // checks to see illegal moves are not made and notifys player of illegal moves
    public static boolean check(int og, int end) {

        int x1 = og/10 - 1;
        int y1 = og%10 - 1;
        int x_end = end/10 - 1;
        int y_end = end%10 - 1;

        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7 ||
                x_end < 0 || x_end > 7 || y_end < 0 || y_end > 7){
            return false;
        }

        else if (board2.getBoard()[x1][y1].getColor() == board2.getPlayerTurn() && board2.getBoard()[x_end][y_end] == null) {

            if (Math.abs(x1-x_end)==1) {
                if ((board2.getPlayerTurn() == 'r') && (y_end - y1 == 1))
                    return true;
                else if ((board2.getPlayerTurn() == 'b') && (y_end- y1 == -1))
                    return true;
            }

            else if (Math.abs(x1-x_end)==2) {
                if (board2.getPlayerTurn() == 'r' && (y_end - y1 == 2) &&
                        board2.getBoard()[(x1+x_end)/2][(y1+y_end)/2].getColor() == 'b')
                    return true;
                else if (board2.getPlayerTurn() == 'b' && (y_end - y1 == -2) &&
                        board2.getBoard()[(x1+x_end)/2][(y1+y_end)/2].getColor() == 'r')
                    return true;
            }
        }
        return false;
    }

    //prints the moves from execute method onto the board
    public static void executeMove(int og, int end) {
        //mod and divide by ten to get location on board
        int x_og = og/10 - 1;
        int y_og = og%10 - 1;
        int x_end = end/10 - 1;
        int y_end = end%10 - 1;


        pieces temp = board2.getBoard()[x_og][y_og];
        board2.setBoard(x_end, y_end, temp);
        board2.setBoard(x_og, y_og, null);
        if (Math.abs(x_end - x_og) == 2) {
            board2.setBoard((x_og+x_end)/2, (y_og+y_end)/2, null);
            if (board2.getPlayerTurn() == 'r')
                board2.setRedCount(board2.getRedCount()-1);
            else
                board2.setBlackCount(board2.getBlackCount()-1);
        }

    }

    //boolean returns true if player is out of bounds or a winner has occurred to end game
    public static boolean endgame() {
        return (board2.getRedCount() == 0 || board2.getBlackCount() == 0);
    }

    //prints the winning color
    public static String winner() {
        if (board2.getBlackCount() == 0)
            return "Congrats red won!";
        else
            return "Congrats black won!";
    }
}