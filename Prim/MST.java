public class MST {
    // Phương thức để tìm đỉnh có giá trị key nhỏ nhất chưa được chọn vào MST
    private int minKey(int key[], Boolean mstSet[], int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Phương thức in ra cây khung nhỏ nhất
    public void printMST(int parent[], int graph[][], int V) {
        System.out.println("Edge \tWeight");
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    // Phương thức chính để tìm cây khung nhỏ nhất bằng thuật toán Prim
    public void primMST(Graph g) {
        int V = g.V;
        int[][] graph = g.graph;

        // Kiểm tra nếu đồ thị có ít hơn 2 đỉnh
        if (V < 2) {
            System.out.println("The graph does not have enough vertices for MST.");
            return;
        }

        // Kiểm tra nếu đồ thị không liên thông bằng cách đếm số cạnh
        int edgeCount = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    edgeCount++;
                }
            }
        }
        if (edgeCount / 2 < V - 1) { // Mỗi cạnh được đếm 2 lần
            System.out.println("The graph is not connected.");
            return;
        }

        int[] parent = new int[V];  // Lưu trữ các cạnh trong cây khung
        int[] key = new int[V];  // Lưu trữ trọng số của các cạnh
        Boolean[] mstSet = new Boolean[V];  // Theo dõi các đỉnh đã được chọn vào MST

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        // Tìm cây khung nhỏ nhất
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // In ra cây khung nhỏ nhất và tổng trọng số
        printMST(parent, graph, V);
    }
}
