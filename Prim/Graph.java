public class Graph {
    int V;  // Số lượng đỉnh
    int[][] graph;  // Ma trận trọng số

    // Constructor để khởi tạo đồ thị với số đỉnh và ma trận trọng số
    public Graph(int v) {
        this.V = v;
        this.graph = new int[v][v];
    }

    // Phương thức để thêm cạnh giữa các đỉnh u và v với trọng số w
    public void addEdge(int u, int v, int w) {
        graph[u][v] = w;
        graph[v][u] = w;  // Đồ thị vô hướng, nên thêm cạnh cho cả hai phía
    }
}

