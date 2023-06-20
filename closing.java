import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class closing {
    static int N;
    static int M;
    static int nodes;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static boolean[] deleted;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("closing.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");
        N = Integer.parseInt(parts[0]);
        M = Integer.parseInt(parts[1]);

        visited = new boolean[N];
        deleted = new boolean[N];
        adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            line = in.readLine();
            parts = line.split(" ");
            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] order = new int[N];
        for (int i = 0; i < N; i++) order[i] = Integer.parseInt(in.readLine()) - 1;

        BufferedWriter out = new BufferedWriter(new FileWriter("closing.out"));

        for (int i = 0; i < N; i++) {
            nodes = 0;
            floodfill(order[N-1]);
            if (nodes == N - i) out.write("YES\n");
            else out.write("NO\n");
            Arrays.fill(visited, false);
            deleted[order[i]] = true;
        }
        in.close();
        out.close();

    }
    public static void floodfill(int node) {
        if (visited[node] || deleted[node]) return;
        visited[node] = true;
        nodes++;
        for (int i : adj.get(node)) {
            floodfill(i);
        }
    }
}
