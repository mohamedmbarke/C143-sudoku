
import java.io.*;
import java.util.*;

public class SudokuBoard {

    private char[][] board;

   
    public SudokuBoard(String fileName) {
        board = new char[9][9];

        try {
            Scanner input = new Scanner(new File(fileName));

            int row = 0;

            while (input.hasNextLine() && row < 9) {
                String line = input.nextLine();

                for (int col = 0; col < 9; col++) {
                    board[row][col] = line.charAt(col);
                }

                row++;
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public boolean isValid() {


        for (int i = 0; i < 9; i++) {
            boolean[] rowUsed = new boolean[10];
            boolean[] colUsed = new boolean[10];

            for (int j = 0; j < 9; j++) {
                char rowValue = board[i][j];
                char colValue = board[j][i];

                if (rowValue != '.') {
                    if (rowValue < '1' || rowValue > '9') {
                        return false;
                    }

                    int num = rowValue - '0';

                    if (rowUsed[num]) {
                        return false;
                    }
                    rowUsed[num] = true;
                }

                if (colValue != '.') {
                    if (colValue < '1' || colValue > '9') {
                        return false;
                    }

                    int num = colValue - '0';

                    if (colUsed[num]) {
                        return false;
                    }
                    colUsed[num] = true;
                }
            }
        }

   
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] used = new boolean[10];

                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        char value = board[r][c];

                        if (value != '.') {
                            int num = value - '0';

                            if (used[num]) {
                                return false;
                            }
                            used[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    // Checks if is complete and valid
    public boolean isSolved() {
        if (!isValid()) {
            return false;
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    return false;
                }
            }
        }

        return true;
    }

    // Returns 
    public String toString() {
        String result = "";

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                result += board[row][col] + " ";

                if (col == 2 || col == 5) {
                    result += "| ";
                }
            }

            result += "\n";

            if (row == 2 || row == 5) {
                result += "---------------------\n";
            }
        }

        return result;
    }
}
