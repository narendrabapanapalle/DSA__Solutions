import java.util.*;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class NumberOfEnclaves {

    // Function to count number of enclaves
    public int numberOfEnclaves(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        // Step 1: Push all boundary land cells into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // first row, first col, last row, last col
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {

            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // traverse all 4 directions
            for (int i = 0; i < 4; i++) {

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1) {

                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        // Step 3: Count unvisited land cells
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }

    // MAIN METHOD (USER INPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter the grid (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        NumberOfEnclaves obj = new NumberOfEnclaves();
        int ans = obj.numberOfEnclaves(grid);

        System.out.println("Number of Enclaves = " + ans);

        sc.close();
    }
}
