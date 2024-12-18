import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Nhập số đỉnh: ");
        int n = sc.nextInt();
        System.out.print("Nhập số cạnh: ");
        int m = sc.nextInt();

        KruskalAlgorithm kruskal = new KruskalAlgorithm(n, m);

        System.out.println("Nhập các cạnh (u v w):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            kruskal.addEdge(u, v, w);
        }

        // Thực thi thuật toán Kruskal
        kruskal.kruskal();
    }
}
