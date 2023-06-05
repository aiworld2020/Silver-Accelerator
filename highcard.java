import java.io.*;
import java.util.*;

public class highcard {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("highcard.in"));
        int n = Integer.parseInt(in.readLine());
        ArrayList<Integer> elsie = new ArrayList<>();
        boolean[] cards = new boolean[2*n + 1];
        ArrayList<Integer> bessie = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            elsie.add(Integer.parseInt(in.readLine()));
            cards[elsie.get(i)] = true;
        }
        Collections.sort(elsie);
        for (int i = 1; i <= 2*n; i++) {
            if (!cards[i]) {
                bessie.add(i);
            }
        }
        int answer = 0;
        int bessie_index = n-1;
        int elsie_index = n-1;
        while (elsie_index >= 0) {
            if (bessie.get(bessie_index) > elsie.get(elsie_index)) {
                answer++;
                bessie_index--;
            }
            elsie_index--;
        }
        
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("highcard.out"));
        out.write(answer + "\n");
        out.close();
    }
}
