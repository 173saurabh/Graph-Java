import java.util.ArrayList;

public class AdjacencyList {

    public static void addEdge(ArrayList<ArrayList<Integer>> arr, int u, int v) {

        arr.get(u).add(v);
        arr.get(v).add(u);

    }

    public static void print(ArrayList<ArrayList<Integer>> arr) {

        for (int i = 0; i < arr.size(); i++) {
            for (int j : arr.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(v);

        for (int i = 0; i < 4; i++)
            arr.add(new ArrayList<Integer>());

        addEdge(arr, 0, 1);
        addEdge(arr, 0, 2);
        addEdge(arr, 1, 3);
        addEdge(arr, 1, 2);

        print(arr);
    }

}
