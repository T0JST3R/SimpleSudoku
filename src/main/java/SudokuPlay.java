import javax.swing.*;

public class SudokuPlay {

    private SudokuSimpleBoard setDigit() {
        int row;
        int column;
        int digit;
        SudokuSimpleBoard.BoardBuilder boardBuilder = new SudokuSimpleBoard.BoardBuilder();
        boolean anotherDigit = true;
        if (JOptionPane.showInputDialog("do you want to add another digit? 1 - yes 2 no").equalsIgnoreCase("2")) {
            anotherDigit = false;
        }
        while (anotherDigit) {
            row = Integer.parseInt(JOptionPane.showInputDialog("in which row add digit? 0-8"));
            column = Integer.parseInt(JOptionPane.showInputDialog("in wich column? 0-8"));
            digit = Integer.parseInt(JOptionPane.showInputDialog("what digit? 0-8"));
            boardBuilder.setDigit(row, column, digit);
            if (JOptionPane.showInputDialog("do you want to add another digit? 1 - yes 2 no").equalsIgnoreCase("2")) {
                anotherDigit = false;
            }
        }
        return boardBuilder.build();
    }

    public static void main(String[] args) {
        SudokuPlay sudokuPlay = new SudokuPlay();
        boolean oneMoreGame = true;
        while (oneMoreGame) {
            SudokuLogic sudokuLogic = new SudokuLogic(sudokuPlay.setDigit());
            sudokuLogic.solveSudoku();
            if (JOptionPane.showInputDialog("One more game? 1- yes , 2 - no").equalsIgnoreCase("2")) {
                oneMoreGame = false;
            }
        }
    }
}

