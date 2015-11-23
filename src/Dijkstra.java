import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static ArrayList<Double> V1Array = new ArrayList<>();
    static ArrayList<Double> V2Array = new ArrayList<>();
    static ArrayList<Double> V3Array = new ArrayList<>();
    static ArrayList<Double> V4Array = new ArrayList<>();
    static ArrayList<Double> V5Array = new ArrayList<>();
    static ArrayList<Double> V6Array = new ArrayList<>();
    static ArrayList<Double> V7Array = new ArrayList<>();
    static ArrayList<Double> V8Array = new ArrayList<>();
    static ArrayList<Double> V9Array = new ArrayList<>();
    static ArrayList<Double> V10Array = new ArrayList<>();
    static ArrayList<Double> V11Array = new ArrayList<>();
    static ArrayList<Double> V12Array = new ArrayList<>();

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            for (Edge e : u.neighbours) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
