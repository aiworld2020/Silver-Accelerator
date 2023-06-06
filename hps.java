import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("hps.in"));
        int N = Integer.parseInt(in.readLine());
        Integer[][] prefixes = new Integer[3][N+1];
        prefixes[0][0]=0;
        prefixes[1][0]=0;
        prefixes[2][0]=0;

        for (int i = 1; i <= N; i++) {
            String john = in.readLine();
            if (john.equals("H")) {
                prefixes[0][i] = prefixes[0][i-1] + 1;
                prefixes[1][i] = prefixes[1][i-1];
                prefixes[2][i] = prefixes[2][i-1];
            }
            if (john.equals("P")) {
                prefixes[0][i] = prefixes[0][i-1];
                prefixes[1][i] = prefixes[1][i-1] + 1;
                prefixes[2][i] = prefixes[2][i-1];
            }
            if (john.equals("S")) {
                prefixes[0][i] = prefixes[0][i-1];
                prefixes[1][i] = prefixes[1][i-1];
                prefixes[2][i] = prefixes[2][i-1] + 1;
            }
        }

        long answer = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    answer = Math.max(answer, prefixes[a][i] + prefixes[b][N] - prefixes[b][i]);
                }
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("hps.out"));
        out.write(answer + "\n");
        out.close();
    }
}
