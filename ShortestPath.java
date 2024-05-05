import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    public static void addEdge(ArrayList<ArrayList<Integer>> arr, int v, int u) {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> arr, int n, int s, int[] dist) {

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : arr.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        int[] dist = new int[v];
        Arrays.fill(dist, 0);
        bfs(adj, v, 0, dist);

        for (int i = 0; i < v; i++) {
            System.out.println(dist[i]);
        }
    }
}