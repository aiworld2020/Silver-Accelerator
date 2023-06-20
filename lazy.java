import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class lazy {
    static int N;
    static grass[] patches;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lazy.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");
        N = Integer.parseInt(parts[0]);
        int K = Integer.parseInt(parts[1]);
        patches = new grass[N];


        for (int i = 0; i < N; i++) {
            line = in.readLine();
            parts = line.split(" ");
            patches[i] = new grass(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        Arrays.sort(patches);

        int answer = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            sum += patches[i].units;
            while(patches[i].location - patches[index].location > 2 * K){
                sum -= patches[index].units;
                index++;
            }
            answer = Math.max(answer, sum);
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("lazy.out"));
        out.write(answer + "\n");
        out.close();
    }

    static class grass implements Comparable<grass> {
        int units, location;
        public grass (int u, int l) {
            units = u;
            location = l;
        }
        public int compareTo(grass g) {
            return this.location - g.location;
        }
    }
}
