import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class herding {
    static int N;
    static Long[] locations;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("herding.in"));
        N = Integer.parseInt(in.readLine());
        locations = new Long[N];
        for (int i = 0; i < N; i++) {
            locations[i] = Long.parseLong(in.readLine());
        }
        Arrays.sort(locations);
        long min = findMin();
        //System.out.println(min);
        long max = findMax();
        //System.out.println(max);
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("herding.out"));
        out.write(min + "\n" + max + "\n");
        out.close();
    }
    static long findMin() {
        long answer = 0;
        if (locations[N-2] - locations[0] == N - 2 && locations[N-1] - locations[N-2] > 2) {
            return 2;
        }
        if (locations[N-1] - locations[1] == N - 2 && locations[1] - locations[0] > 2) {
            return 2;
        }
        long j = 0;
        for (int i = 0; i < N-1; i++) {
            while (j < N-1 && locations[(int)j+1] - locations[i] <= N-1) j++;
            answer = Math.max(answer, j-i+1);
        }
        return N-answer;
    }
    static long findMax() {
        if (locations[N-2] - locations[0] > locations[N-1] - locations[1]) {
            return 1 + locations[N-2] - locations[0] - (N-1);
        }
        else {
            return 1 + locations[N-1] - locations[1] - (N-1);
        }
    }
}
