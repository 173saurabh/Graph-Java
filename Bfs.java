import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void addEdge(ArrayList<ArrayList<Integer>> arr, int u, int v) {
        arr.get(u).add(v);
        arr.get(v).add(u);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> arr, int v, int s) {

        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);

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

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(v);

        for (int i = 0; i < 5; i++)
            arr.add(new ArrayList<Integer>());

        addEdge(arr, 0, 1);
        addEdge(arr, 0, 2);
        addEdge(arr, 1, 2);
        addEdge(arr, 2, 3);
        addEdge(arr, 1, 3);
        addEdge(arr, 3, 4);
        addEdge(arr, 2, 4);

        bfs(arr, v, 0);
    }
}
