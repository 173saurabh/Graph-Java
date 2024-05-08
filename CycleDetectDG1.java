import java.util.ArrayList;
import java.util.Arrays;

//Cycle detection code on a directed graph

public class CycleDetectDG1 {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] temp) {

        visited[s] = true;
        temp[s] = true;

        for (int u : adj.get(s)) {
            if (!visited[u] && dfsRec(adj, u, visited, temp))
                return true;
            else if (temp[u])
                return true;
        }
        temp[s] = false;
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        boolean[] temp = new boolean[v];

        Arrays.fill(temp, false);
        Arrays.fill(visited, false);

        for (int i = 0; i < v; i++) {
            if (!visited[i] && dfsRec(adj, i, visited, temp)) {
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
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);

        if (dfs(adj, v))
            System.out.println("    Cycle detected  ");
        else
            System.out.println("    No cycle detected   ");

    }
}
