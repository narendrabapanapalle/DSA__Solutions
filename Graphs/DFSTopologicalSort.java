import java.util.*;

class DFSTopologicalSort {

    // DFS function
    private static void dfs(int node, int vis[],
                            Stack<Integer> st,
                            ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }

        // push after visiting all neighbors
        st.push(node);
    }

    // Topological Sort function
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int ans[] = new int[V];
        int i = 0;

        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }

    // MAIN METHOD (User Input)
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

        int result[] = topoSort(V, adj);

        System.out.println("Topological Order:");

        for (int x : result)
            System.out.print(x + " ");
    }
}