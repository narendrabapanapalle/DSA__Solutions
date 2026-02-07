import java.util.Scanner;

class FloodFillAlgorithm {

    // DFS function (same style as image)
    private void dfs(int row, int col,
                     int[][] ans,
                     int[][] image,
                     int newColor,
                     int[] delRow,
                     int[] delCol,
                     int iniColor) {

        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                image[nrow][ncol] == iniColor &&
                ans[nrow][ncol] != newColor) {

                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
            }
        }
    }

    // Flood Fill function
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int iniColor = image[sr][sc];
        int[][] ans = image;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }

    // MAIN METHOD (USER INPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] image = new int[n][m];

        System.out.println("Enter image matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row (sr): ");
        int sr = sc.nextInt();

        System.out.print("Enter starting column (sc): ");
        int scCol = sc.nextInt();

        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();

        FloodFillAlgorithm obj = new FloodFillAlgorithm();
        int[][] result = obj.floodFill(image, sr, scCol, newColor);

        System.out.println("Flood Filled Image:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
