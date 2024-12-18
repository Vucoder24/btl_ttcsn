import java.util.List;
import java.util.ArrayList;

class BoruvkaMST {
    public void findMST(Graph graph) {
        int vertices = graph.getVertices();
        List<Edge> edges = graph.getEdges();

        DisjointSet ds = new DisjointSet(vertices);
        List<Edge> mst = new ArrayList<>();

        int numComponents = vertices;

        while (numComponents > 1) {
            Edge[] cheapest = new Edge[vertices];

            // Tìm cạnh rẻ nhất cho từng thành phần
            for (Edge edge : edges) {
                int setU = ds.find(edge.u);
                int setV = ds.find(edge.v);

                if (setU != setV) {
                    if (cheapest[setU] == null || edge.weight < cheapest[setU].weight) {
                        cheapest[setU] = edge;
                    }
                    if (cheapest[setV] == null || edge.weight < cheapest[setV].weight) {
                        cheapest[setV] = edge;
                    }
                }
            }

            boolean hasAddedEdge = false;

            // Thêm các cạnh rẻ nhất vào MST và hợp nhất các thành phần
            for (int i = 0; i < vertices; i++) {
                if (cheapest[i] != null) {
                    Edge edge = cheapest[i];
                    int setU = ds.find(edge.u);
                    int setV = ds.find(edge.v);

                    if (setU != setV) {
                        mst.add(edge);
                        ds.union(setU, setV);
                        System.out.println("Adding " + edge);
                        numComponents--;
                        hasAddedEdge = true;
                    }
                }
            }

            // Nếu không thể thêm cạnh nào, đồ thị không liên thông
            if (!hasAddedEdge) {
                System.out.println("The graph is disconnected. Minimum Spanning Tree cannot be formed.");
                return;
            }
        }

        // In kết quả MST
        System.out.println("Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight: " + totalWeight);
    }
}
