import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nqueen {
    public static void printNQueens(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((board[i][j] == 1) ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;

        // Check the left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col) {
        int n = board.length;

        // All Queens are placed successfully
        if (col >= n) {
            return true;
        }

        // Try placing a Queen in each row of the current column
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place the Queen

                // Recur to place the remaining Queens
                if (solveNQueens(board, col + 1)) {
                    return true;
                }

                // If placing the Queen in board[i][col] doesn't lead to a solution, backtrack
                board[i][col] = 0; // Remove the Queen
            }
        }

        // If no row allows a Queen to be placed in this column, return false
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the board size (n): ");
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        System.out.print("Enter the row (0 to n-1) to place the first Queen: ");
        int firstQueenRow = Integer.parseInt(br.readLine());

        if (firstQueenRow < 0 || firstQueenRow >= n) {
            System.out.println("Invalid row for the first Queen. Should be between 0 and " + (n - 1));
            return;
        }

        // Place the first Queen based on user input
        board[firstQueenRow][0] = 1;

        if (solveNQueens(board, 1)) {
            System.out.println("Solution exists. Here's the N-Queens matrix:");
            printNQueens(board);
        } else {
            System.out.println("No solution exists for the given configuration.");
        }

        br.close();
    }
}
