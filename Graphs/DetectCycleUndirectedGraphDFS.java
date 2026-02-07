import java.util.*;

class DetectCycleUndirectedGraphDFS {

    // DFS function to detect cycle
    private boolean dfs(int node, int parent,
                        int[] vis,
                        ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;

        for (int adjacentNode : adj.get(node)) {

            if (vis[adjacentNode] == 0) {
                if (dfs(adjacentNode, node, vis, adj) == true)
                    return true;
            }
            else if (adjacentNode != parent) {
                return true;   // cycle detected
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj) == true)
                    return true;
            }
        }
        return false;
    }

    // MAIN METHOD (USER INPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);   // undirected graph
        }

        DetectCycleUndirectedGraphDFS obj =
                new DetectCycleUndirectedGraphDFS();

        boolean ans = obj.isCycle(V, adj);

        System.out.println("Cycle Present: " + ans);

        sc.close();
    }
}
