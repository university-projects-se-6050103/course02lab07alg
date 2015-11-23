import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final int verticesCount = 9;
    private static List<Vertex> vertices = new ArrayList<>();
    private static List<Vertex> minimumSpanningTree = new ArrayList<>();
    private static Map<Integer, ArrayList<Double>> nearestPaths = new HashMap<>();

    static {
        createVertices();
        addArcs();
    }

    public static void main(String[] args) {
        calculateShortestPathForVertices();

        for (int i = 0; i < verticesCount; i++) {
            minimumSpanningTree.add(new Vertex("вершина " + (i + 1)));
            for (int j = 0; j < verticesCount; j++) {
                Double minDistance = nearestPaths.get(i).get(j);
                if (minDistance != 0) {
                    System.out.println("Від " + (i + 1) + " до " + (j + 1) + " відстань: " +
                            minDistance);
                    minimumSpanningTree.get(i).addEdge(new Vertex("вершина " + (j + 1)), minDistance);
                }
            }
            System.out.println();
        }

        System.out.println("Каркасне дерево з мінімальними відтанями: ");
        minimumSpanningTree.stream().forEach(System.out::println);
    }

    private static void calculateShortestPathForVertices() {
        for (int i = 0; i < verticesCount; i++) {
            calculateShortestPathForVertex(i);
        }
    }

    private static void calculateShortestPathForVertex(int vertexIndex) {
        nearestPaths.put(vertexIndex, new ArrayList<>());
        DijkstraAlgorithm.computeShortestPaths(vertices.get(vertexIndex));
        for (int i = 0; i < verticesCount; i++) {
            nearestPaths.get(vertexIndex).add(vertices.get(i).minDistance);
        }
    }

    private static void createVertices() {
        for (int i = 0; i < verticesCount; i++) {
            Vertex vertex = new Vertex("вершина " + (i + 1));
            vertices.add(vertex);
        }
    }

    private static void addArcs() {
        vertices.get(0).addEdge(vertices.get(1), 290.0);
        vertices.get(0).addEdge(vertices.get(2), 320.0);
        vertices.get(0).addEdge(vertices.get(3), 480.0);

        vertices.get(1).addEdge(vertices.get(3), 560.0);
        vertices.get(1).addEdge(vertices.get(4), 780.0);

        vertices.get(2).addEdge(vertices.get(3), 295.0);
        vertices.get(2).addEdge(vertices.get(5), 470.0);

        vertices.get(3).addEdge(vertices.get(4), 315.0);
        vertices.get(3).addEdge(vertices.get(5), 265.0);
        vertices.get(3).addEdge(vertices.get(8), 820.0);

        vertices.get(4).addEdge(vertices.get(6), 270.0);
        vertices.get(4).addEdge(vertices.get(5), 445.0);

        vertices.get(5).addEdge(vertices.get(7), 290.0);

        vertices.get(6).addEdge(vertices.get(7), 250.0);
        vertices.get(6).addEdge(vertices.get(8), 225.0);

        vertices.get(7).addEdge(vertices.get(6), 260.0);
        vertices.get(7).addEdge(vertices.get(8), 315.0);
    }
}
