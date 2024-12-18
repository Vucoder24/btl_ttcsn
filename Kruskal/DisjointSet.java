public class DisjointSet {
    private int[] parent;
    private int[] rank;

    // Khởi tạo tập hợp ban đầu
    public DisjointSet(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Tìm gốc của tập hợp với tối ưu hóa đường đi (Path Compression)
    public int find(int v) {
        if (v != parent[v]) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    // Hợp nhất hai tập hợp theo thứ bậc (Union by Rank)
    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return false; // Hai đỉnh đã thuộc cùng một tập hợp

        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        return true;
    }
}