public class Main {
    public static void main(String[] args) {
        System.out.println("\nTH4: Đồ thị với nhiều cạnh và đỉnh");
        Graph g4 = new Graph(6);
        g4.addEdge(0, 1, 4);
        g4.addEdge(0, 2, 4);
        g4.addEdge(1, 2, 2);
        g4.addEdge(1, 3, 5);
        g4.addEdge(2, 3, 8);
        g4.addEdge(3, 4, 6);
        g4.addEdge(4, 5, 9);
        MST mst4 = new MST();
        mst4.primMST(g4);
    }
}
