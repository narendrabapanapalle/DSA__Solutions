import java.util.*;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class NumberOfDistinctIslands {

    // DFS to record island shape
    private void dfs(int row, int col, int[][] vis,
                     int[][] grid, ArrayList<String> vec,
                     int row0, int col0) {

        vis[row][col] = 1;

        // store relative position
        vec.add(toString(row - row0, col - col0));

        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, -1, 0, +1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                vis[nrow][ncol] == 0 &&
                grid[nrow][ncol] == 1) {

                dfs(nrow, ncol, vis, grid, vec, row0, col0);
            }
        }
    }

    // Convert relative position to string
    private String toString(int r, int c) {
        return r + " " + c;
    }

    // Function to count distinct islands
    public int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (vis[i][j] == 0 && grid[i][j] == 1) {

                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
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

        NumberOfDistinctIslands obj =
                new NumberOfDistinctIslands();

        int ans = obj.countDistinctIslands(grid);

        System.out.println("Number of Distinct Islands = " + ans);

        sc.close();
    }
}
