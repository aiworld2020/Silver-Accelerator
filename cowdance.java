import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class cowdance {
    static int N;
    static int T_Max;
    static int[] cowtimes;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowdance.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");
        N = Integer.parseInt(parts[0]);
        T_Max = Integer.parseInt(parts[1]);

        cowtimes = new int[N];
        for (int i = 0; i < N; i++) {
            cowtimes[i] = Integer.parseInt(in.readLine());
        }

        int a = 1;
        int b = N;
        while(a != b) {
            int K = (a+b)/2;
            //System.out.println(K);
            if (checkK(K)) {
                b = K;
            }
            else {
                a = K +1;
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("cowdance.out"));
        out.write(b + "\n");
        out.close();
    }
    static boolean checkK(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < K; i++) {
            pq.add(cowtimes[i]);
        }
        for (int i = K; i < N; i++) {
            int smallest = pq.poll();
            pq.add(smallest + cowtimes[i]);
        }
        for (int i = 0; i < K-1; i++) {
            pq.poll();
        }
        return (pq.peek() <= T_Max);
    }
}