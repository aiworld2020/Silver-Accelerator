import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class comfortable {
    static final boolean[][] cows = new boolean[3000][3000];
    static final int[][] adjacent = new int[3000][3000];
    static int answer = 0;
 
    static void add(int x, int y) {
        if (!cows[x][y]) {
            cows[x][y] = true;
            answer++;
            if (cows[x][y] && adjacent[x][y] == 3) {
                for (int[] another : new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}}) {
                    int w = another[0];
                    int z = another[1];
                    add(w, z);
                }
            }
            for (int[] other : new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}}) {
                int u = other[0];
                int v = other[1];
                adjacent[u][v]++;
                if (cows[u][v] && adjacent[u][v] == 3) {
                    for (int[] another : new int[][]{{u - 1, v}, {u + 1, v}, {u, v - 1}, {u, v + 1}}) {
                        int w = another[0];
                        int z = another[1];
                        add(w, z);
                    }
                }
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            String[] parts = line.split(" ");
            int x = Integer.parseInt(parts[0]) + 1000;
            int y = Integer.parseInt(parts[1]) + 1000;
            answer--;
            add(x, y);
            out.append(answer).append('\n');
        }
        in.close();
        System.out.print(out);
    }
}
   

