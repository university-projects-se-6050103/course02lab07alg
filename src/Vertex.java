import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<Arc> neighbours = new ArrayList<>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Вершина{" +
                name + '\'' +
                (neighbours.size() > 0 ?
                        ", сусідні вершини=" + (neighbours.size() != 1 ?
                                neighbours.subList(1, neighbours.size() - 1) :
                                neighbours) :
                        "") +
                ", відстань=" + minDistance +
                "}";
    }

    public void addEdge(Vertex v, Double value) {
        neighbours.add(new Arc(v, value));
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
