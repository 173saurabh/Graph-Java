import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectDG2 {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void cycleDetectionUsingTopoAlgo(ArrayList<ArrayList<Integer>> adj, int v) {
        int indegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (int u : adj.get(i))
                indegree[u]++;
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i : adj.get(u))
                if (--indegree[i] == 0)
                    q.add(i);
            count++;
        }
        if (count != v)
            System.out.println("Cycle detected");
        else
            System.out.println("No cycle detected");
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 4, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        cycleDetectionUsingTopoAlgo(adj, v);
    }
}
