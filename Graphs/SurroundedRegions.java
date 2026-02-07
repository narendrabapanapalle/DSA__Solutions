import java.util.*;

class SurroundedRegions {

    // DFS function
    static void dfs(int row, int col, int[][] vis,
                    char[][] mat, int[] delrow, int[] delcol) {

        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        // check in 4 directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                vis[nrow][ncol] == 0 &&
                mat[nrow][ncol] == 'O') {

                dfs(nrow, ncol, vis, mat, delrow, delcol);
            }
        }
    }

    // Function to replace surrounded regions
    static char[][] fill(int n, int m, char[][] mat) {

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        int[][] vis = new int[n][m];

        // Traverse first row and last row
        for (int j = 0; j < m; j++) {

            // first row
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol);
            }

            // last row
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delrow, delcol);
            }
        }

        // Traverse first column and last column
        for (int i = 0; i < n; i++) {

            // first column
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol);
            }

            // last column
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delrow, delcol);
            }
        }

        // Convert unvisited O's to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    // MAIN METHOD (USER INPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        char[][] mat = new char[n][m];

        System.out.println("Enter the matrix (X or O):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.next().charAt(0);
            }
        }

        char[][] ans = fill(n, m, mat);

        System.out.println("Result Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
