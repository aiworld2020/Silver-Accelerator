import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cownomics.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");

        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        String[] spotted = new String[N];
        String[] plain = new String[N];

        for (int i = 0; i < N; i++) {
            spotted[i] = in.readLine();
        }
        for (int i = 0; i < N; i++) {
            plain[i] = in.readLine();
        }
        in.close();

        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i+1; j < M; j++) {
                for (int k = j+1; k < M; k++) {
                    TreeSet<String> ts = new TreeSet<String>();
                    for (int l = 0; l < N; l++) {
                        ts.add(Character.toString(spotted[l].charAt(i)) + Character.toString(spotted[l].charAt(j)) + Character.toString(spotted[l].charAt(k)));
                    }
                    for (int l = 0; l < N; l++) {
                        if (ts.contains(Character.toString(plain[l].charAt(i)) + Character.toString(plain[l].charAt(j)) + Character.toString(plain[l].charAt(k)))) {
                            break;
                        }
                        if (l == N-1) {
                            answer++;
                            //System.out.println(i + " " + j + " " + k);
                        }
                        
                    }
                }
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("cownomics.out"));
        out.write(answer + "\n");
        out.close();
    }
}
