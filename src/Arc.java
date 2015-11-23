public class Arc {
    public final Vertex target;
    public final double weight;

    public Arc(Vertex targetVertex, double weightToVertex) {
        target = targetVertex;
        weight = weightToVertex;
    }

    @Override
    public String toString() {
        return "Дуга{" +
                "вага=" + weight +
                ", прилягаюча вершина=" + target +
                '}';
    }
}
