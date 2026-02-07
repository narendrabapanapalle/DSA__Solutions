import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class DetectCycleUndirectedGraph {

    // BFS function to check cycle from a source node
    public boolean checkForCycle(int src, int V,
            ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {

            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (int adjacentNode : adj.get(node)) {

                if (vis[adjacentNode] == false) {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                }
                else if (parent != adjacentNode) {
                    return true;   // cycle detected
                }
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, V, adj, vis))
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

        DetectCycleUndirectedGraph obj = new DetectCycleUndirectedGraph();
        boolean ans = obj.isCycle(V, adj);

        System.out.println("Cycle Present: " + ans);

        sc.close();
    }
}
