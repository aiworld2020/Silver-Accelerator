import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class milkvisits {
    static int N,M, currColor;
    static char[] types;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("milkvisits.in"));
        String[] parts = in.readLine().split(" ");
        N = Integer.parseInt(parts[0]);
        M = Integer.parseInt(parts[1]);
        types = new char[N];
        visited = new boolean[N];
        colors = new int[N];
        adj = new ArrayList<ArrayList<Integer>>();

        String line = in.readLine();
        for (int i = 0; i < N; i++) {
            types[i] = line.charAt(i);
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 1; i < N; i++) {
            parts = in.readLine().split(" ");
            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        currColor = 1;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) DFS(i, types[i]);
            currColor++;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("milkvisits.out"));
        for (int i = 0; i < M; i++) {
            parts = in.readLine().split(" ");
            int start = Integer.parseInt(parts[0]) - 1;
            int end = Integer.parseInt(parts[1]) - 1;
            char c = parts[2].charAt(0);
            if (colors[start] == colors[end] && types[start] != c) out.write("0");
            else out.write("1");
        }
        out.write("\n");
        in.close();
        out.close();
    }
    static void DFS(int current, char c) {
        if (visited[current] || types[current] != c) return;
        visited[current] = true;
        colors[current] = currColor;
        for (int i : adj.get(current)) {
            DFS(i, c);
        }
    }
}
