public class AdjacencyMat {

    public void addEdge(int i, int j, int vertices, boolean adjMat[][]) {
        if ((i >= 0 && i < vertices) && (j >= 0 && j < vertices)) {
            adjMat[i][j] = true;
            adjMat[j][i] = true;
        } else {
            System.out.println("Enter valid input");
        }
    }

    public void removeEdge(int i, int j, int vertices, boolean adjMat[][]) {
        if ((i >= 0 && i < vertices) && (j >= 0 && j < vertices)) {
            adjMat[i][j] = false;
            adjMat[j][i] = false;
        } else {
            System.out.println("Enter valid input");
        }
    }
}