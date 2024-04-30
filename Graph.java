/**
 * Graph
 */
public class Graph {

    int vertices;
    boolean ajdMax[][];

    public Graph(int vertices) {
        this.vertices = vertices;
        ajdMax = new boolean[vertices][vertices];
    }

}