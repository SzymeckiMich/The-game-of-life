public class Board {

    private final int n;
    private char[][] board;

    char livingCell = 'X';
    char deathCell = ' ';

//    public int[] numberOfParents = {3};
//    public int[] numberOfNeighboursToExist = {2, 3};


    public Board(int n) {
        this.n = n;
        this.board = fillBoard(n);
    }

    private char[][] fillBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = deathCell;
            }
        }
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int i1 = 0; i1 < this.board[i].length; i1++) {
                System.out.print(board[i][i1] + "  ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

//    public void setChar(int X, int Y, char C) {
//        this.board[n - 1 - X][Y] = C;
//    }

    public void setChar(int X, int Y, char C) {
        this.board[n - 1 - Y][X] = C;
    }


    public void drawOnBoard(int[][] cells) {
        for (int[] cell : cells) {
            setChar(cell[0], cell[1], livingCell);
        }
        printBoard();
    }


    public void evolve() {
        char[][] evolvedBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int numberOfNeighbours = checkNeighbours(i, j);

                if (board[i][j] == livingCell) {
                    if (numberOfNeighbours == 2 || numberOfNeighbours == 3) {
                        evolvedBoard[i][j] = livingCell;
                    } else {
                        evolvedBoard[i][j] = deathCell;
                    }
                } else {
                    if (numberOfNeighbours == 3) {
                        evolvedBoard[i][j] = livingCell;
                    } else {
                        evolvedBoard[i][j] = deathCell;
                    }
                }
            }
        }
        board = evolvedBoard;
        printBoard();
    }

    private int checkNeighbours(int i, int j) {
        int Neighbours = 0;

        int[][] neighbours = {
                {i - 1, j - 1}, {i - 1, j}, {i - 1, j + 1},
                {i, j - 1}, {i, j + 1},
                {i + 1, j - 1}, {i + 1, j}, {i + 1, j + 1},
        };

        for (int[] neighbour : neighbours) {
            if (isNeighbourExist(neighbour)) {
                if (board[neighbour[0]][neighbour[1]] == 'X') {
                    Neighbours++;
                }
            }
        }
        return Neighbours;
    }

    private boolean isNeighbourExist(int[] neighbour) {
        boolean isNeighbourExist = true;
        int i = neighbour[0];
        int j = neighbour[1];
        if (i < 0 || i >= n || j < 0 || j >= n) {
            isNeighbourExist = false;
        }
        return isNeighbourExist;
    }
}
