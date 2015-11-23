public class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex targetVertex, double weightToVertex) {
        target = targetVertex;
        weight = weightToVertex;
    }
}
