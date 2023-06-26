import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class cardgame {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cardgame.in"));
        int N = Integer.parseInt(in.readLine());
        boolean[] cards = new boolean[2*N + 1];
        ArrayList<Integer> bessie = new ArrayList<Integer>();
        Integer[] part1 = new Integer[N/2];
        Integer[] part2 = new Integer[N/2];
        for (int i = 0; i < N/2; i++) {
            int t = Integer.parseInt(in.readLine());
            part1[i] = t;
            cards[t] = true;
        }
        for (int i = 0; i < N/2; i++) {
            int t = Integer.parseInt(in.readLine());
            part2[i] = t;
            cards[t] = true;
        }
        for (int i = 1; i <= 2 * N; i++) {
            if(!cards[i]) bessie.add(i);
        }
        Arrays.sort(part1);
        Arrays.sort(part2, Collections.reverseOrder());
        Collections.sort(bessie);
        
        int answer = 0;
        for (int i = 0; i < N/2; i++) {
            if (part1[i] < bessie.get(N/2+i)) answer++;
        }
        for (int i = 0; i < N/2; i++) {
            if (part2[i] > bessie.get(N/2-i-1)) answer++;
        }
        
        System.out.println(answer);
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("cardgame.out"));
        out.write(answer + "\n");
        out.close();
        
    }
}
