import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class angry {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("angry.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);

        Integer[] haybales = new Integer[N];

        for (int i = 0; i < N; i++) {
            haybales[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(haybales);

        int a = 0;
        int b = 50000000;
        while (a != b) {
            int mid = (a+b)/2;
            if (check(N, K, mid, haybales)) {
                b=mid;
            } else {
                a = mid +1;
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("angry.out"));
        out.write(a + "\n");
        out.close();
        
    }
    static boolean check(int N, int K, int mid, Integer[] haybales) {
        int test = 1;
        int start = haybales[0];
        for (int i = 0; i < N; i++) {
            if (start + (2*mid) < haybales[i]) {
                test++;
                start = haybales[i];
            }
        }
        return (test <= K);
    }
}
