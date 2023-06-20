import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class berries {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("berries.in"));
        String[] parts = in.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);
        parts = in.readLine().split(" ");
        int[] trees = new int[N];
        int M = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(parts[i]);
            M = Math.max(M, trees[i]);
        }

        int answer = 0;
        for (int b = 1; b <= M; b++) {
            int filled = 0;
            int[] remains = new int[N];
            for (int i = 0; i < N; i++) {
                filled += trees[i]/b;
                remains[i] = trees[i] % b;
            }
            if (filled >= K) answer = Math.max(answer, K/2 * b);
            else if (filled >= K/2) {
                int leftOver = 0;
                leftOver += (filled - K/2) * b;
                Arrays.sort(remains);
                int end = remains.length - 1;
                for (int i = filled - K/2; i < K/2; i++) {
                    if (end < 0) continue;
                    leftOver += remains[end--];
                }
                answer = Math.max(answer, leftOver);
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("berries.out"));
        out.write(answer + "\n");
        out.close();
    }
}
