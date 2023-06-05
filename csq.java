import java.io.*;
import java.util.*;

public class csq {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        
        String line = in.readLine();
        String[] parts = line.split(" ");
        for (int i = 0; i < N; i++) {
            prefix.add(prefix.get(i) +  Integer.parseInt(parts[i]));
        }

        int Q = Integer.parseInt(in.readLine());

        for (int i = 0; i < Q; i++) {
            line = in.readLine();
            parts = line.split(" ");
            out.println(prefix.get(Integer.parseInt(parts[1]) + 1) - prefix.get(Integer.parseInt(parts[0])));
        }
        in.close();
        out.close();

    }
}
