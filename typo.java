import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class typo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("typo.in"));
        String parenthesis = in.readLine();
        int N = parenthesis.length();
        in.close();

        ArrayList<Integer> prefix = new ArrayList<>();
        Integer[] suffix = new Integer[N];
        if (parenthesis.charAt(0) == '(') prefix.add(1);
        else prefix.add(-1);
        for (int i = 1; i < N; i++) {
            if (parenthesis.charAt(i) == '(') prefix.add(prefix.get(i-1) + 1);
            else prefix.add(prefix.get(i-1) - 1);
        }
        suffix[N-1] = prefix.get(N-1);
        for (int i = N-2; i >= 0; i--) {
            suffix[i] = Math.min(prefix.get(i), suffix[i+1]);
        }

        int answer = 0;
        if (prefix.get(N-1) == -2) {
            for (int i = 0; i < N; i++) {
                if (parenthesis.charAt(i) == ')' && suffix[i] >= -2) {
                    answer++;
                }
                if (prefix.get(i) < 0) break;
            }

        }
        else if (prefix.get(N-1) == 2) {
            for (int i = 0; i < N; i++) {
                if (parenthesis.charAt(i) == '(' && suffix[i] >= 2) {
                    answer++;
                }
                if (prefix.get(i) < 0) break;
            }
        }
        else {
            answer = 0;
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("typo.out"));
        out.write(answer + "\n");
        out.close();

    }
}
