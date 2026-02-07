import java.util.*;

class BipartiteGraph {

    // BFS check for one component
    private boolean check(int start, int V,
                          ArrayList<ArrayList<Integer>> adj,
                          int[] color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {

                // if the adjacent node is not colored
                if (color[it] == -1) {

                    color[it] = 1 - color[node];
                    q.add(it);
                }

                // if adjacent node has same color
                else if (color[it] == color[node]) {
                    return false;
                }
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
                if (!check(i, V, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    // MAIN METHOD (USER INPUT)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

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

        BipartiteGraph obj = new BipartiteGraph();

        boolean ans = obj.isBipartite(V, adj);

        if (ans)
            System.out.println("Graph is Bipartite");
        else
            System.out.println("Graph is NOT Bipartite");

        sc.close();
    }
}
