
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

                for (int col = 0; col < 8; col++) {
                    board[row][col] = line.charAt(col);
                }

                row++;
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

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
