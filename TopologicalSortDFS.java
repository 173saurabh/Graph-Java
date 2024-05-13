import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk, int u, boolean[] visited) {
        visited[u] = true;
        for (int i : adj.get(u)) {
            if (!visited[i])
                dfs(adj, stk, i, visited);
        }
        stk.push(u);
    }

    public static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(adj, stk, i, visited);
        }

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);

        topologicalSort(adj, v);
    }
}