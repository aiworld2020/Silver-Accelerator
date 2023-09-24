import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class swap{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("swap.in"));
        String[] parts = in.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int K = Integer.parseInt(parts[2]);

        Swap[] swaps = new Swap[M];
        for (int i = 0; i < M; i++) {
            parts = in.readLine().split(" ");
            swaps[i] = new Swap(Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1]) - 1);
        }

        int[] start = new int[N];
        int[] current = new int[N];
        int[] changes = new int[N+1];

        for (int i = 0; i < N; i++) {
            start[i] = i+1;
            current[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int a = swaps[i].a;
            int b = swaps[i].b;
            while (a < b) {
                int temp = current[b];
                current[b] = current[a];
                current[a] = temp;
                a++;
                b--;
            }
        }

        for (int i = 0; i < N; i++) {
            changes[start[i]] = current[i];
        }

        int count = 2;
        int[][] positions = new int[K*M][N];
        boolean full_loop = true;
        positions[0] = start;
        positions[1] = current;

        while(count <= K) {
            current = cycle(current, changes, N);
            positions[count] = current;
            count++;
            if (current.equals(positions[0])) {
                full_loop = false;
                break;
            }
        }

        in.close();

        int[] answer;
        if (full_loop) {
            //System.out.println("ji");
            answer = positions[K];
        } else {
            answer = positions[K&count];
        }
        /*
        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
        */
        BufferedWriter out = new BufferedWriter(new FileWriter("swap.out"));
        for (int i = 0; i < N; i++) {
            out.write(answer[i] + "\n");
        }
        out.close();
        
    }
    static class Swap{
        public int a, b;
        public Swap(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static int[] cycle(int[] list, int[] changes, int N) {
        int[] new_list = new int[N];
        /*
        for (int i = 0; i < N; i++) {
            System.out.println(list[i]);
        }
        */
        for (int i = 0; i < N; i++) {
            new_list[i] = list[changes[i+1] -1];
        }
        /*
        for (int i = 0; i < N; i++) {
            System.out.println(new_list[i]);
        }
        */
        return new_list;
    }
}