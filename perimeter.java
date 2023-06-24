import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class perimeter {
    static int N, perimeter, area;
    static char[][] icecream;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("perimeter.in"));
        N = Integer.parseInt(in.readLine());
        icecream = new char[N + 2][N + 2];
        visited = new boolean[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            String line = in.readLine();
            for (int j = 1; j <= N; j++) {
                icecream[i][j] = line.charAt(j-1);
            }
        }
        int answerA = 0;
        int answerP = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j<=N; j++) {
                if (!visited[i][j] && icecream[i][j] == '#') DFS(i, j);
                //System.out.println(area + " " + perimeter);
                if (area > answerA) {
                    answerA = area;
                    answerP = perimeter;
                }
                if (area == answerA) answerP = Math.min(perimeter, answerP);
                area = 0;
                perimeter=0;
            }
        }
        in.close();
        //System.out.println(answerA + " " + answerP);
        BufferedWriter out = new BufferedWriter(new FileWriter("perimeter.out"));
        out.write(answerA + " " + answerP + "\n");
        out.close();
    }
    static void DFS(int i, int j) {
        if (visited[i][j] || icecream[i][j] == '.') return;
        visited[i][j] = true;
        area++;
        perimeter += 4;
        if (icecream[i+1][j] == '#') {
            perimeter--;
            DFS(i+1, j);
        }
        if (icecream[i-1][j] == '#') {
            perimeter--;
            DFS(i-1, j);
        }
        if (icecream[i][j+1] == '#') {
            perimeter--;
            DFS(i, j+1);
        }
        if (icecream[i][j-1] == '#') {
            perimeter--;
            DFS(i, j-1);
        }
    }
}
