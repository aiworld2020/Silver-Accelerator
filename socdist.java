import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class socdist {
    static int N;
    static int M;
    static Coords[] sections;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("socdist.in"));
        String[] parts = in.readLine().split(" ");
        N = Integer.parseInt(parts[0]);
        M = Integer.parseInt(parts[1]);
        sections = new Coords[M];
        for (int i = 0; i < M; i++) {
            parts = in.readLine().split(" ");
            long a = Long.parseLong(parts[0]);
            long b = Long.parseLong(parts[1]);
            sections[i] = new Coords(a, b);
        }
        in.close();
        Arrays.sort(sections);

        long low = 1;
        long high = (long)1e18;
        while(low < high) {
            long D = (low+high+1)/2;
            if (check(D)) {
                low = D;
            } else {
                high = D - 1;
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("socdist.out"));
        out.write(low + "\n");
        out.close();
    }
    static boolean check(long D) {
        long curr = sections[0].start;
        int idx = 0;
        int cows = 0;
        while (idx < M) {
            if (curr < sections[idx].start) {
                curr = sections[idx].start;
                //continue;
            }
            if (curr > sections[idx].end) {
                idx++;
                //continue;
            }
            else {
                while (curr <= sections[idx].end) {
                    cows++;
                    curr += D;
                }
            }
            if (cows >= N) return true;
        }
        //if (cows >= N) return true;
        return false;

    }
    static class Coords implements Comparable<Coords> {
        long start, end;
        public Coords(long s, long e) {
            start = s;
            end = e;
        }
        public int compareTo(Coords a) {
            return (int)(this.start - a.start);
        }
    }
}
