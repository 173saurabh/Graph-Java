import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void addEdge(ArrayList<ArrayList<Integer>> arr, int u, int v) {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> arr, int v, int s, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int i : arr.get(u)) {
                if (visited[i] == false) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        System.out.println();

    }

    public static void bfs1(ArrayList<ArrayList<Integer>> arr, int v) {
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        int islands = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(arr, v, i, visited);
                islands++;
            }
        }
        System.out.println("Number of islands are: " + islands);
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for (int i = 0; i < 7; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 4, 6);

        bfs1(adj, v);
    }
}
