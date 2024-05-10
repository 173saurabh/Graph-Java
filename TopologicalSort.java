import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void topoSort(ArrayList<ArrayList<Integer>> adj, int v) {

        int indegree[] = new int[v];

        for (int i = 0; i < v; i++) {
            for (int u : adj.get(i))
                indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int x : adj.get(u)) {
                if (--indegree[x] == 0) {
                    q.add(x);
                }
            }
        }

    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        topoSort(adj, v);
    }
}
