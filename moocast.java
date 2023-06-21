import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class moocast {
    static Coords[] locations;
    static int[] transmissions;
    static ArrayList<ArrayList<Integer>> adj;
    static int nodes, N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("moocast.in"));
        N = Integer.parseInt(in.readLine());
        locations = new Coords[N];
        transmissions = new int[N];
        visited = new boolean[N];
        adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N; i++) {
            String[] parts = in.readLine().split(" ");
            locations[i] = new Coords(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            transmissions[i] = Integer.parseInt(parts[2]);
        }
        in.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (checkDist(locations[i], locations[j], (double)transmissions[i])) {
                    adj.get(i).add(j);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            DFS(i);
            answer = Math.max(answer, nodes);
            nodes = 0;
            Arrays.fill(visited, false);
        }
        //System.out.println(answer);
        BufferedWriter out = new BufferedWriter(new FileWriter("moocast.out"));
        out.write(answer + "\n");
        out.close();
    }
    static boolean checkDist(Coords c1, Coords c2, double t) {
        double dist = Math.sqrt(((c1.x - c2.x) * (c1.x - c2.x)) + ((c1.y - c2.y) * (c1.y - c2.y)));
        return dist <= t;
    }

    static void DFS(int node) {
        if (visited[node]) return;
        visited[node] = true;
        nodes++;
        for (int i : adj.get(node)) {
            DFS(i);
        }
    }

    static class Coords {
        public int x, y;
        public Coords(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
