import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectUG {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, int parent) {

        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (dfsRec(adj, visited, u, s))
                    return true;
            } else if (u != parent) {
                return true;
            }
        }

        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfsRec(adj, visited, i, -1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);

        if (dfs(adj, v))
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }
}
