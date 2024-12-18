import java.util.*;

class Graph {
    private int vertices; // Số đỉnh
    private List<Edge> edges; // Danh sách các cạnh

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    // Lấy số đỉnh
    public int getVertices() {
        return vertices;
    }

    // Lấy danh sách các cạnh
    public List<Edge> getEdges() {
        return edges;
    }
}
