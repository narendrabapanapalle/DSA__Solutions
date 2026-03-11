import java.util.*;

class Pair {
    int row;
    int col;
    int tm;

    Pair(int _row, int _col, int _tm) {
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}

class RottenOranges {

    // Function to find minimum time required to rot all oranges
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        int cntFresh = 0;

        // Step 1: Store all initially rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int tm = 0;
        int cnt = 0;

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {

            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            q.remove();
            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1) {

                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        // Step 3: Check if all fresh oranges are rotten
        if (cnt != cntFresh)
            return -1;
z
        return tm;
    }

    // MAIN METHOD (USER INPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter the grid values (0, 1, 2):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        RottenOranges obj = new RottenOranges();
        int ans = obj.orangesRotting(grid);

        System.out.println("Minimum time to rot all oranges = " + ans);

        sc.close();
    }
}
