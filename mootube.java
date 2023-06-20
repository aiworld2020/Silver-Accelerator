import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class mootube {
    static int N;
    static int Q;
    static ArrayList<ArrayList<Integer>> adj;
    static int[][] recs;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("mootube.in"));
        String[] parts = in.readLine().split(" ");
        N = Integer.parseInt(parts[0]);
        Q = Integer.parseInt(parts[1]);

        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }

        recs = new int[N][N];
        for (int i = 0; i < N-1; i++) {
            parts = in.readLine().split(" ");
            int p = Integer.parseInt(parts[0]) - 1;
            int q = Integer.parseInt(parts[1]) - 1;
            int r = Integer.parseInt(parts[2]);
            adj.get(p).add(q);
            adj.get(q).add(p);
            recs[p][q] = r;
            recs[q][p] = r;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("mootube.out"));
        for (int i = 0; i < Q; i++) {
            parts = in.readLine().split(" ");
            int rec = Integer.parseInt(parts[0]);
            int start = Integer.parseInt(parts[1]) - 1;
            int answer = 0;
            ArrayList<Integer> queue = new ArrayList<Integer>();
            queue.add(start);
            boolean[] visited = new boolean[N];
            visited[start] = true;
            while(!queue.isEmpty()) {
                int node = queue.remove(0);
                for (int j : adj.get(node)) {
                    if (!visited[j] && recs[node][j] >= rec) {
                        visited[j] = true;
                        queue.add(j);
                        answer++;
                    }
                }
            }
            out.write(answer + "\n");
        }
        in.close();
        out.close();
    }
}
