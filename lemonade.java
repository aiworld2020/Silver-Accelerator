import java.io.*;
import java.util.*;

public class lemonade {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("lemonade.in"));
        int n = Integer.parseInt(in.readLine());
        ArrayList<Integer> cows = new ArrayList<>();
        String[] parts = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cows.add(Integer.parseInt(parts[i]));
        }
        Collections.sort(cows, Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (cows.get(i) >= answer) answer++;
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("lemonade.out"));
        out.write(answer + "\n");
        out.close();
    }
}
