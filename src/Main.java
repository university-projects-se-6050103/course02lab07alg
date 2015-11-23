import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final int verticiesCount = 9;
    private static Map<Integer, ArrayList<Double>> nearestPaths = new HashMap<>();

    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < verticiesCount; i++) {
            Vertex vertex = new Vertex("вершина " + (i + 1));
            vertices.add(vertex);
        }

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


        Dijkstra.computePaths(vertices.get(0));

        nearestPaths.put(0, new ArrayList<>());
        for (int i = 0; i < verticiesCount; i++) {
            nearestPaths.get(0).add(vertices.get(0).minDistance);
        }

        for (int i = 0; i < verticiesCount; i++) {
            nearestPaths.get(0).add(vertices.get(i).minDistance);
        }


        for (int i = 0; i < verticiesCount; i++) {
            System.out.println("Відстань від першої вершини до вершини " + (i + 1) + ": " + vertices.get(i).minDistance);
        }

        //  List<Vertex> path = getShortestPathTo(V12);
        //  System.out.println("Path: " + path);
    }
}
