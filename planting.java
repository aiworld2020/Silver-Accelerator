import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class planting {
    static int N, answer;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("planting.in"));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 1; i < N; i++) {
            String[] parts = in.readLine().split(" ");
            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int M = 0;
        int start = 0;
        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() > M) {
                start = i;
                M = adj.get(i).size();
            }
        }
        answer = M;
        DFS(start);
        //System.out.println(answer);
        BufferedWriter out = new BufferedWriter(new FileWriter("planting.out"));
        out.write(answer + "\n");
        out.close();
    }
    static void DFS(int node) {
        if (visited[node]) return;
        visited[node] = true;
        if (adj.get(node).size() >= answer) answer++;
        for (int i : adj.get(node)) DFS(i);
    }

}
