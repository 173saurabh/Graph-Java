import java.util.ArrayList;
import java.util.Arrays;

public class Dfs {

    public static void addEdge(ArrayList<ArrayList<Integer>> arr, int u, int v) {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }

    public static void dfsRec(ArrayList<ArrayList<Integer>> arr, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(" " + s);

        for (int i : arr.get(s)) {
            if (!visited[i])
                dfsRec(arr, i, visited);
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> arr, int v, int s) {
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);

        for (int i = 0; i < v; i++) {
            if (visited[i] == false)
                dfsRec(arr, i, visited);
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for (int i = 0; i < 7; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);

        dfs(adj, v, 0);
    }
}
