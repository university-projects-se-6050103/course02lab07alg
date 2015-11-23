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
            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove( v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        // mark all the vertices
        Vertex V1 = new Vertex("V1");
        Vertex V2 = new Vertex("V2");
        Vertex V3 = new Vertex("V3");
        Vertex V4 = new Vertex("V4");
        Vertex V5 = new Vertex("V5");
        Vertex V6 = new Vertex("V6");
        Vertex V7 = new Vertex("V7");
        Vertex V8 = new Vertex("V8");
        Vertex V9 = new Vertex("V9");
        Vertex V10 = new Vertex("V10");
        Vertex V11 = new Vertex("V11");
        Vertex V12 = new Vertex("V12");

        // set the edges and weight
        V1.adjacencies = new Edge[]{new Edge(V2, 25), new Edge(V3, 47), new Edge(V6, 52), new Edge(V5, 34), new Edge(V4, 40)};
        V2.adjacencies = new Edge[]{new Edge(V3, 15)};
        V3.adjacencies = new Edge[]{new Edge(V6, 31), new Edge(V7, 72)};
        V4.adjacencies = new Edge[]{new Edge(V5, 11), new Edge(V8, 25)};
        V5.adjacencies = new Edge[]{new Edge(V9, 85), new Edge(V8, 28)};
        V6.adjacencies = new Edge[]{new Edge(V7, 63), new Edge(V11, 144), new Edge(V8, 37)};
        V7.adjacencies = new Edge[]{new Edge(V9, 20), new Edge(V10, 10)};
        V8.adjacencies = new Edge[]{new Edge(V12, 120), new Edge(V10, 92)};
        V9.adjacencies = new Edge[]{new Edge(V8, 93), new Edge(V12, 42)};
        V10.adjacencies = new Edge[]{new Edge(V11, 74)};
        V11.adjacencies = new Edge[]{new Edge(V12, 65)};
        V12.adjacencies = new Edge[]{};

        computePaths(V1); // run Dijkstra
        for(int i=0; i<12;i++)
        V1Array.add(V1.minDistance);
        V1Array.add(V2.minDistance);
        V1Array.add(V3.minDistance);
        V1Array.add(V4.minDistance);
        V1Array.add(V5.minDistance);
        V1Array.add(V6.minDistance);
        V1Array.add(V7.minDistance);
        V1Array.add(V8.minDistance);
        V1Array.add(V9.minDistance);
        V1Array.add(V10.minDistance);
        V1Array.add(V11.minDistance);
        V1Array.add(V12.minDistance);



        System.out.println("Distance from V1 to " + V2 + ": " + V2.minDistance);
        System.out.println("Distance from V1 to " + V3 + ": " + V3.minDistance);
        System.out.println("Distance from V1 to " + V4 + ": " + V4.minDistance);
        System.out.println("Distance from V1 to " + V5 + ": " + V5.minDistance);
        System.out.println("Distance from V1 to " + V6 + ": " + V6.minDistance);
        System.out.println("Distance from V1 to " + V7 + ": " + V7.minDistance);
        System.out.println("Distance from V1 to " + V8 + ": " + V8.minDistance);
        System.out.println("Distance from V1 to " + V9 + ": " + V9.minDistance);
        System.out.println("Distance from V1 to " + V10 + ": " + V10.minDistance);
        System.out.println("Distance from V1 to " + V11 + ": " + V11.minDistance);
        System.out.println("Distance from V1 to " + V12 + ": " + V12.minDistance);
        System.out.println();



        //  List<Vertex> path = getShortestPathTo(V12);
      //  System.out.println("Path: " + path);
    }
}
