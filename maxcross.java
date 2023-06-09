import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class maxcross {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");
        int N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);
        int B = Integer.parseInt(parts[2]);

        Boolean[] broken = new Boolean[N+1];
        Arrays.fill(broken, false);
        for (int i = 0; i < B; i++) {
            broken[Integer.parseInt(in.readLine())] = true;

        }   
        int a = 0;
        int b = B;
        while(a != b) {
            int mid = (a+b)/2;
            System.out.println(mid);
            if (check(mid, N, K, broken)) {
                b=mid;
            } else {
                a = mid +1;
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("maxcross.out"));
        out.write(b + "\n");
        out.close();

    }
    static boolean check(int mid, int N, int K, Boolean[] broken) {
        int current = 1;
        int brokenPassed = 0;
        int a = 1;
        int b = K;
        while (b <= N) {
            if (broken[current]) brokenPassed++;
            if (brokenPassed > mid) {
                a++;
                b++;
                current = a;
                brokenPassed=0;
            }
            if (current == b) {
                return true;
            }
            current++;
        }
        return false;
    }
}
