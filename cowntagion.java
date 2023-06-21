import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class cowntagion {
    static int N;    
    static int days;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("cowntagion.in"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N-1; i++) {
            String[] parts = in.readLine().split(" ");
            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        DFS(0);
        System.out.println(days);
    }
    static void DFS(int node) {
        if (visited[node]) return;
        if (days != 0) days++;
        int infected = 1;
        while(infected < adj.get(node).size()) {
            infected *= 2;
            days++;
        }
        visited[node] = true;
        for (int i : adj.get(node)) {
            DFS(i);
        }
    }
}
