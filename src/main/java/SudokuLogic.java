import javax.swing.*;


public class SudokuLogic {
    private  SudokuSimpleBoard sudokuSimpleBoard;

    public SudokuLogic(SudokuSimpleBoard sudokuSimpleBoard) {
        this.sudokuSimpleBoard = sudokuSimpleBoard;
    }

    public boolean solveSudoku() {

        for (int row = 0; row < SudokuSimpleBoard.BOARDSIZE; row++) {
            for (int column = 0; column < SudokuSimpleBoard.BOARDSIZE; column++) {
                if (sudokuSimpleBoard.getBoard()[row][column] == 0) {
                    for (int digit = 1; digit <= SudokuSimpleBoard.BOARDSIZE; digit++) {
                        if (isOk(digit, row, column)) {
                            sudokuSimpleBoard.getBoard()[row][column] = digit;
                            if (solveSudoku()) {
                                return true;
                            } else sudokuSimpleBoard.getBoard()[row][column] = 0;
                        }
                    }
                    return false;
                }

            }
        }
        sudokuDisplay();
        return true;
    }

    private boolean isDigitInRow(int digit, int row) {
        for (int i = 0; i < SudokuSimpleBoard.BOARDSIZE; i++) {
            if (sudokuSimpleBoard.getBoard()[row][i] == digit) {
                return true;
            }

        }
        return false;
    }

    private boolean isDigitInColumn(int digit, int column) {
        for (int i = 0; i < SudokuSimpleBoard.BOARDSIZE; i++) {
            if (sudokuSimpleBoard.getBoard()[i][column] == digit) {
                return true;
            }
        }
        return false;
    }

    private boolean isDigitinBox(int digit, int row, int column) {
        int row1 = row - row % 3;
        int colum1 = column - column % 3;
        for (int i = row1; i < row1 + 3; i++) {
            for (int j = colum1; j < colum1 + 3; j++) {
                if (sudokuSimpleBoard.getBoard()[i][j] == digit) {
                    return true;
                }

            }

        }
        return false;
    }

    private boolean isOk(int digit, int row, int column) {
        return (!isDigitinBox(digit, row, column) && !isDigitInColumn(digit, column) && !isDigitInRow(digit, row));

    }

    private void sudokuDisplay() {
        System.out.println(sudokuSimpleBoard);
    }
}
