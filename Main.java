public class Main {

    public static void print(int vertices, boolean adjMat[][]) {
        System.out.println("Current Adjacency Matrix: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(i + "" + j + " " + adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        AdjacencyMat adj = new AdjacencyMat();
        adj.addEdge(0, 1, g.vertices, g.ajdMax);
        adj.addEdge(0, 2, g.vertices, g.ajdMax);
        adj.addEdge(1, 2, g.vertices, g.ajdMax);
        adj.addEdge(2, 0, g.vertices, g.ajdMax);
        adj.addEdge(2, 3, g.vertices, g.ajdMax);
        print(g.vertices, g.ajdMax);

        adj.removeEdge(0, 1, g.vertices, g.ajdMax);
        print(g.vertices, g.ajdMax);
    }
}
