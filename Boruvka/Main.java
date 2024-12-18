public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // 6 đỉnh
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 8);
        graph.addEdge(4, 5, 9);

        BoruvkaMST boruvka = new BoruvkaMST();
        boruvka.findMST(graph);
    }
}
