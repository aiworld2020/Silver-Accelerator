import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class div7 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("div7.in"));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> mod7 = new ArrayList<>();
        prefix.add(Integer.parseInt(in.readLine()));
        mod7.add(prefix.get(0)%7);

        for (int i = 1; i < N; i++) {
            prefix.add(Integer.parseInt(in.readLine()) + prefix.get(i-1));
            mod7.add(prefix.get(i)%7);
        }


        int answer = 0;
        for (int i = 0; i < N; i++) {
            int index = mod7.lastIndexOf(mod7.get(i));
            if (index != -1) {
                answer = Math.max(answer, index - i);
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("div7.out"));
        out.write(answer + "\n");
        out.close();
    }
}
