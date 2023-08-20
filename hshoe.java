import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class hshoe {
    static char[][] horeshoes;
    static boolean valid;
    static boolean[][] visited;
    static int answer, N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("hshoe.in"));
        N = Integer.parseInt(in.readLine());
        horeshoes = new char[N+2][N+2];
        visited = new boolean[N+2][N+2];
        for (int i = 1; i <= N; i++) {
            String line = in.readLine();
            for (int j = 1; j <= N; j++) {
                horeshoes[i][j] = line.charAt(j-1);
            }
        }
        in.close();
        
        String current = "";
        DFS(1, 1, current);
        BufferedWriter out = new BufferedWriter(new FileWriter("hshoe.out"));
        out.write(answer + "\n");
        out.close();
    }
    static void DFS(int i, int j, String current) {
        if (i < 1 || i > N || j < 1 || j > N) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        current += horeshoes[i][j];
        valid = true;
        for (int x = 1; x <= 12; x++) {
            if(current.length() % 2 == 1) {
                valid = false;
                break;
            }
            if (current.length() < x * 2) break;
            if (current.length() != x * 2) continue;
            for (int y = 0; y < x; y++) {
                if (current.indexOf(y) != '(') {
                    valid = false;
                    break;
                }
            }
            for (int y = x; y < x * 2; y++) {
                if (current.indexOf(y) != ')') {
                    valid = false;
                    break;
                }
            }
        }
        
        //System.out.println("i " + i + " j " + j);
        //System.out.println(current);
        //System.out.println(valid);
        if (valid) answer = Math.max(answer, current.length());
        DFS(i + 1, j, current);
        DFS(i - 1, j, current);
        DFS(i, j + 1, current);
        DFS(i, j - 1, current);
        visited[i][j] = false;
    }
}
