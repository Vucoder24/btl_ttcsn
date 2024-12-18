import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    private int n, m; // Số đỉnh và số cạnh
    private List<Edge> edges; // Danh sách cạnh

    public KruskalAlgorithm(int n, int m) {
        this.n = n;
        this.m = m;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }

    public void kruskal() {
        // Sắp xếp các cạnh theo trọng số tăng dần
        Collections.sort(edges);

        // Khởi tạo Disjoint Set
        DisjointSet ds = new DisjointSet(n);

        // Tạo cây khung nhỏ nhất
        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (mst.size() == n - 1) break;

            // Nếu hợp nhất được thì thêm cạnh vào MST
            if (ds.union(edge.u, edge.v)) {
                mst.add(edge);
                totalWeight += edge.w;
            }
        }

        // In kết quả
        if (mst.size() != n - 1) {
            System.out.println("Đồ thị không liên thông");
        } else {
            System.out.println("MST tổng trọng số: " + totalWeight);
            for (Edge edge : mst) {
                System.out.println(edge.u + " - " + edge.v + " : " + edge.w);
            }
        }
    }
}