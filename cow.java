import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class cow {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cow.in"));
        int N = Integer.parseInt(in.readLine());
        String cow = in.readLine();

        ArrayList<Long> prefixCOW = new ArrayList<>();
        ArrayList<Long> prefixOW = new ArrayList<>();
        ArrayList<Long> prefixW = new ArrayList<>();
        prefixW.add((long)0);
        prefixOW.add((long)0);
        prefixCOW.add((long)0);


        for (int i = N; i>0; i--) {
            if (cow.charAt(i-1) == 'W') {
                prefixW.add(1 + prefixW.get(N-i));
            }
            else {
                prefixW.add(prefixW.get(N-i));
            }
        }
        for (int i = N; i> 0; i--) {
            if (cow.charAt(i-1) == 'O') {
                prefixOW.add(prefixW.get(N-i) + prefixOW.get(N-i));
            }
            else {
                prefixOW.add(prefixOW.get(N-i));
            }
        }
        for (int i = N; i> 0; i--) {
            if (cow.charAt(i-1) == 'C') {
                prefixCOW.add(prefixOW.get(N-i) + prefixCOW.get(N-i));
            }
            else {
                prefixCOW.add(prefixCOW.get(N-i));
            }
        }

        long answer = prefixCOW.get(N);

        in.close();

        BufferedWriter out = new BufferedWriter(new FileWriter("cow.out"));
        out.write(answer + "\n");
        out.close();

    }
}
