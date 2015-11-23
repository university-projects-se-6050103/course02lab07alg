import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void computeShortestPaths(Vertex startingVertex) {
        startingVertex.minDistance = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(startingVertex);

        while (!vertexQueue.isEmpty()) {
            Vertex topQueueVertex = vertexQueue.poll();
            for (Edge edge : topQueueVertex.neighbours) {
                Vertex currentVertex = edge.target;
                double weight = edge.weight;
                double distanceThroughTopQueueVertex = topQueueVertex.minDistance + weight;
                if (distanceThroughTopQueueVertex < currentVertex.minDistance) {
                    vertexQueue.remove(currentVertex);

                    currentVertex.minDistance = distanceThroughTopQueueVertex;
                    currentVertex.previous = topQueueVertex;
                    vertexQueue.add(currentVertex);
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
