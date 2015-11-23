import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<Edge> neighbours = new ArrayList<>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
    }

    public String toString() {
        return name;
    }

    public void addEdge(Vertex v, int value) {
        neighbours.add(new Edge(v, value));
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
