import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final int verticiesCount = 9;
    private static List<Vertex> vertices = new ArrayList<>();
    private static Map<Integer, ArrayList<Double>> nearestPaths = new HashMap<>();

    static {
        createVertices();
        addArcs();
    }

    public static void main(String[] args) {
        calculateShortestPathForVertex(0);

        for (int i = 0; i < verticiesCount; i++) {
            System.out.println("Відстань від першої вершини до вершини " + (i + 1) +
                    ": " + vertices.get(i).minDistance);
        }
    }

    private static void calculateShortestPathForVertices() {
        for (int i = 0; i < verticiesCount; i++) {
            calculateShortestPathForVertex(i);
        }
    }

    private static void calculateShortestPathForVertex(int vertexIndex) {
        nearestPaths.put(vertexIndex, new ArrayList<>());
        DijkstraAlgorithm.computeShortestPaths(vertices.get(vertexIndex));
        for (int i = 0; i < verticiesCount; i++) {
            nearestPaths.get(vertexIndex).add(vertices.get(vertexIndex).minDistance);
        }
    }

    private static void createVertices() {
        for (int i = 0; i < verticiesCount; i++) {
            Vertex vertex = new Vertex("вершина " + (i + 1));
            vertices.add(vertex);
        }
    }

    private static void addArcs() {
        vertices.get(0).addEdge(vertices.get(1), 290);
        vertices.get(0).addEdge(vertices.get(2), 320);
        vertices.get(0).addEdge(vertices.get(3), 480);

        vertices.get(1).addEdge(vertices.get(3), 560);
        vertices.get(1).addEdge(vertices.get(4), 780);

        vertices.get(2).addEdge(vertices.get(3), 295);
        vertices.get(2).addEdge(vertices.get(5), 470);

        vertices.get(3).addEdge(vertices.get(4), 315);
        vertices.get(3).addEdge(vertices.get(5), 265);
        vertices.get(3).addEdge(vertices.get(8), 820);

        vertices.get(4).addEdge(vertices.get(6), 270);
        vertices.get(4).addEdge(vertices.get(5), 445);

        vertices.get(5).addEdge(vertices.get(7), 290);

        vertices.get(6).addEdge(vertices.get(7), 250);
        vertices.get(6).addEdge(vertices.get(8), 225);

        vertices.get(7).addEdge(vertices.get(6), 260);
        vertices.get(7).addEdge(vertices.get(8), 315);
    }
}
