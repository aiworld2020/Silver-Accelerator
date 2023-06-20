import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class cowart {
    static int N;
    static char[][] painting;
    static boolean[][] visited;
    static char prevColor;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowart.in"));
        N = Integer.parseInt(in.readLine());
        painting = new char[N+2][N+2];
        visited = new boolean[N+2][N+2];

        for (int i = 1; i <= N; i++) {
            String line = in.readLine();
            for (int j = 1; j <= N; j++) {
                painting[i][j] = line.charAt(j-1);
            }
        }
        int numHuman = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    floodfill(i, j, painting[i][j]);
                    numHuman++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (painting[i][j] == 'G') painting[i][j] = 'R';
            }
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], false);
        }

        int numCow = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    floodfill(i, j, painting[i][j]);
                    numCow++;
                }
            }
        }
        in.close();
        //System.out.println(numHuman);
        //System.out.println(numCow);
        BufferedWriter out = new BufferedWriter(new FileWriter("cowart.out"));
        out.write(numHuman + " " + numCow + "\n");
        out.close();

    }
   static void floodfill(int i, int j, char current) {
       visited[i][j] = true;
       prevColor = current;
       if (!visited[i+1][j] && painting[i+1][j] == prevColor) floodfill(i+1, j, painting[i+1][j]);
       if (!visited[i-1][j] && painting[i-1][j] == prevColor) floodfill(i-1, j, painting[i-1][j]);
       if (!visited[i][j+1] && painting[i][j+1] == prevColor) floodfill(i, j+1, painting[i][j+1]);
       if (!visited[i][j-1] && painting[i][j-1] == prevColor) floodfill(i, j-1, painting[i][j-1]);
   }
}
