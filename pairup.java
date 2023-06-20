import java.io.*;
import java.util.*;

public class pairup {
    static int N;
    static cow[] cows;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("pairup.in"));
        N = Integer.parseInt(in.readLine());
        cows = new cow[N];

        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            String[] parts = line.split(" ");
            cows[i] = new cow(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
        Arrays.sort(cows);

        int a = 0;
        int b = N-1;
        int answer = 0;
        while (a != b) {
            answer = Math.max(answer, cows[b].output + cows[a].output);
            if (cows[a].number > cows[b].number) {
                cows[a].number -= cows[b].number;
                b--;
            }
            else if (cows[a].number < cows[b].number) {
                cows[b].number -= cows[a].number;
                a++;
            }
            else {
                a++;
                b--;
            }
        }
        if (cows[a].number != 0) {
            answer = Math.max(answer, 2*cows[a].output);
        }

        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("pairup.out"));
        out.write(answer + "\n");
        out.close();    
    }

    static class cow implements Comparable<cow> {
        int number;
        int output;
        public cow(int n, int o) {
            number = n;
            output = o;
        }
        public int compareTo(cow y) {
            return this.output - y.output;
        }
    }

}
