public class board {
    private pieces[][] board1;
    private int redCount; // red checker count
    private int blackCount; //black checker count

    private char Move; // keeps track of whose turn it is

    //new board with pieces is created
    public board() {
        board1 = new pieces[8][8];
        redCount = 12;
        blackCount = 12;
        Move = 'r';

        int i, j;
        for (i = 0; i < 8; i++)
            for (j = 0; j < 8; j++)
                board1[i][j] = null;

        for (i = 1; i < 8; i += 2) {
            board1[i][1] = new pieces(i, 1, false, 'r');
            board1[i][5] = new pieces(i, 5, false, 'b');
            board1[i][7] = new pieces(i, 7, false, 'b');
        }
        for (i = 0; i < 8; i += 2) {
            board1[i][0] = new pieces(i, 0, false, 'r');
            board1[i][2] = new pieces(i, 2, false, 'r');
            board1[i][6] = new pieces(i, 6, false, 'b');
        }
    }

    //this method shows board
    public void display() {
        int i, j;
        System.out.println("  1 2 3 4 5 6 7 8 X");
        for (i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
            for (j = 0; j < 8; j++) {
                if (board1[j][i] == null) {
                    System.out.print("_ ");
                } else {
                    System.out.print(board1[j][i].getColor() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Y");
    }

    public char getPlayerTurn() {
        return Move;
    }

    public void setTurn(char x) {
        Move = x;
    }

    public int getRedCount() {
        return redCount;
    }

    public int getBlackCount() {
        return blackCount;
    }

    public void setRedCount(int x) {
        redCount = x;
    }

    public void setBlackCount(int x) {
        blackCount = x;
    }

    public pieces[][] getBoard() {
        return board1;
    }

    public void setBoard(int x, int y, pieces board2) {
        board1[x][y] = board2;
    }
}
