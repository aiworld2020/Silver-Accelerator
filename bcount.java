import java.io.*;
import java.util.*;

public class bcount {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("bcount.out"));
        String line = in.readLine();
        String[] parts = line.split(" ");

        int N = Integer.parseInt(parts[0]);
        int Q = Integer.parseInt(parts[1]);

        ArrayList<Integer> prefix1 = new ArrayList<>();
        ArrayList<Integer> prefix2 = new ArrayList<>();
        ArrayList<Integer> prefix3 = new ArrayList<>();
        prefix1.add(0);
        prefix2.add(0);
        prefix3.add(0);

        for (int i = 0; i < N; i++) {
            int cow = Integer.parseInt(in.readLine());
            if (cow == 1) {
                prefix1.add(1 + prefix1.get(i));
                prefix2.add(prefix2.get(i));
                prefix3.add(prefix3.get(i));
            }
            if (cow == 2) {
                prefix1.add(prefix1.get(i));
                prefix2.add(1 + prefix2.get(i));
                prefix3.add(prefix3.get(i));
            }
            if (cow == 3) {
                prefix1.add(prefix1.get(i));
                prefix2.add(prefix2.get(i));
                prefix3.add(1 + prefix3.get(i));
            }
        }

        for (int i = 0; i < Q; i++) {
            line = in.readLine();
            parts = line.split(" ");
            int a = Integer.parseInt(parts[0]) -1;
            int b = Integer.parseInt(parts[1]);
            out.write((prefix1.get(b) - prefix1.get(a)) + " " + (prefix2.get(b) - prefix2.get(a)) + " " + (prefix3.get(b) - prefix3.get(a)) + "\n");
        }
        in.close();
        out.close();
    }
}
