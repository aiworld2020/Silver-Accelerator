import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class baseball {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("baseball.in"));
        int N = Integer.parseInt(in.readLine());
        
        Integer[] locations = new Integer[N];
        for (int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(locations);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int first = 2*locations[j] - locations[i];
                int last = locations[j] + 2 * (locations[j] - locations[i]);
                answer += BinarySort(last+1, N, locations) - BinarySort(first, N, locations);
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("baseball.out"));
        out.write(answer + "\n");
        out.close();
    }
    static int BinarySort(int x, int N, Integer[] locations) {
        int a = 0;
        int b = N;
        while (a < b) {
            int mid = (a+b) / 2;
            if (locations[mid] < x) a = mid + 1;
            else b = mid;
        }
        return a;
    }
}