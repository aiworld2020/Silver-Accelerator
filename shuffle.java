import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class shuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
        int N = Integer.parseInt(in.readLine());
        String[] parts = in.readLine().split(" ");
        int[] connections = new int[N+1];
        int[] adj = new int[N+1];
        for (int i = 0; i < N; i++) {
            connections[Integer.parseInt(parts[i])]++;
            adj[i+1] = Integer.parseInt(parts[i]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int answer = N;
        for (int i = 1; i <= N; i++) {
            if (connections[i] == 0) {
                q.add(i);
                answer--;
            }
        }
        while(!q.isEmpty()) {
            int removed = q.poll();
            connections[adj[removed]]--;
            if (connections[adj[removed]] == 0) {
                q.add(adj[removed]);
                answer--;
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("shuffle.out"));
        out.write(answer + "\n");
        out.close();
    }
}
