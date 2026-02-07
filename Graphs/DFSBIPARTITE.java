import java.util.*;

class DFSBIPARTITE {

    // DFS function to color graph
    private boolean dfs(int node, int col, int[] color,
                        ArrayList<ArrayList<Integer>> adj) {

        color[node] = col;

        for (int it : adj.get(node)) {

            if (color[it] == -1) {
                if (!dfs(it, 1 - col, color, adj))
                    return false;
            }
            else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    // Function to check bipartite graph
    public boolean isBipartite(int V,
            ArrayList<ArrayList<Integer>> adj) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj))
                    return false;
            }
        }
        return true;
    }

    // MAIN METHOD – USER INPUT
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);   // Undirected graph
        }

        DFSBIPARTITE obj = new DFSBIPARTITE();

        if (obj.isBipartite(V, adj))
            System.out.println("Graph is Bipartite");
        else
            System.out.println("Graph is NOT Bipartite");

        sc.close();
    }
}
