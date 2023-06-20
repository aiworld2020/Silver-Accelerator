import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class trapped {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("trapped.in"));
        int N = Integer.parseInt(in.readLine());
        Haybale[] bales = new Haybale[N];


        String line = "";
        for (int i = 0; i < N; i++) {
            line = in.readLine();
            String[] parts = line.split(" ");
            bales[i] = new Haybale(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        Arrays.sort(bales);

        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            int left = i;
            int right = i+1;
            int area = bales[right].position-bales[left].position;
            boolean broke = false;
            while (left >= 0 && right <= N-1) {
                broke = false;
                int current = bales[right].position-bales[left].position;
                if (current > bales[left].size) {
                    left--;
                    broke = true;
                }
                if (current > bales[right].size) {
                    right++;
                    broke = true;
                }
                if (!broke) {
                    break;
                }
            }
            if (left >= 0 && right <= N-1) {
                answer += area;
            }
        }

        
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("trapped.out"));
        out.write(answer + "\n");
        out.close();
    }


    static class Haybale implements Comparable<Haybale> {
        public int position, size;
        public Haybale(int size, int position) {
          this.size = size;
          this.position = position;
        }
        public int compareTo(Haybale h) {
          return this.position - h.position;
        }
      }
}
