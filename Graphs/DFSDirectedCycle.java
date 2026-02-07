import java.util.*;

class DFSDirectedCycle {

    // DFS check for cycle
    private boolean dfsCheck(int node,
                             ArrayList<ArrayList<Integer>> adj,
                             int[] vis, int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        // traverse adjacent nodes
        for (int it : adj.get(node)) {

            // if node is not visited
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis))
                    return true;
            }
            // if node is visited and in current path
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        // remove from current path
        pathVis[node] = 0;
        return false;
    }

    // Function to detect cycle in directed graph
    public boolean isCyclic(int V,
                            ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis))
                    return true;
            }
        }
        return false;
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

        System.out.println("Enter directed edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v); // directed edge
        }

        DFSDirectedCycle obj = new DFSDirectedCycle();

        if (obj.isCyclic(V, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle Detected");

        sc.close();
    }
}
