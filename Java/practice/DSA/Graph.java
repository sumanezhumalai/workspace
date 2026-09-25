import java.util.Scanner;

// using Matrix

class Graph {

  static int adjMatrix[][];

  Graph(int v) {
    adjMatrix = new int[v][v];
  }

  void addEdge(int src, int dest) {
    adjMatrix[src][dest] = 1;
    adjMatrix[dest][src] = 1;
  }

  void printMatrix() {
    int v = Graph.adjMatrix[0].length; // considering a square matrix
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++) {

        System.out.print(adjMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] uio) {

    Scanner sc = new Scanner(System.in);
    int vertex = sc.nextInt();
    Graph g = new Graph(vertex);
    int tot_edge = sc.nextInt();
    for (int i = 0; i < tot_edge; i++) {

      int src = sc.nextInt();
      int dest = sc.nextInt();
      g.addEdge(src, dest);
    }

    g.printMatrix();
    sc.close();
  }
}
