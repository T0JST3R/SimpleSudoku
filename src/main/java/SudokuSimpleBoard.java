import java.util.Arrays;

public class SudokuSimpleBoard {

    private Integer[][] board;
    public final static int BOARDSIZE = 9;

    private SudokuSimpleBoard(Integer[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == null) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public Integer[][] getBoard() {
        return board;
    }

    public static class BoardBuilder {

        private Integer[][] board = new Integer[9][9];

        public BoardBuilder setDigit(int row, int column, int digit) {
            board[row][column] = digit;

            return this;
        }

        public SudokuSimpleBoard build() {
            return new SudokuSimpleBoard(board);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            stringBuilder.append("\n");
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        return stringBuilder.toString();
    }
}