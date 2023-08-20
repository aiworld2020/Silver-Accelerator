import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class bgm {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("bgm.in"));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> B = new ArrayList<Integer>();
        ArrayList<Integer> E = new ArrayList<Integer>();
        ArrayList<Integer> S = new ArrayList<Integer>();
        ArrayList<Integer> I = new ArrayList<Integer>();
        ArrayList<Integer> G = new ArrayList<Integer>();
        ArrayList<Integer> O = new ArrayList<Integer>();
        ArrayList<Integer> M = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            String[] parts = in.readLine().split(" ");
            if (parts[0].equals("B")) B.add(Integer.parseInt(parts[1]));
            if (parts[0].equals("E")) E.add(Integer.parseInt(parts[1]));
            if (parts[0].equals("S")) S.add(Integer.parseInt(parts[1]));
            if (parts[0].equals("I")) I.add(Integer.parseInt(parts[1]));
            if (parts[0].equals("G")) G.add(Integer.parseInt(parts[1]));
            if (parts[0].equals("O")) O.add(Integer.parseInt(parts[1]));
            if (parts[0].equals("M")) M.add(Integer.parseInt(parts[1]));
        }
        int answer = 0;
        for (int b : B) {
            for (int e : E) {
                for (int s : S) {
                    for (int i : I) {
                        //System.out.println(b + 2*e + 2*s + i);
                        if ((b + 2*e + 2*s + i) % 7 == 0) answer += G.size() * O.size() * M.size();
                    }
                }
            }
        }
        for (int g : G) {
            for (int o : O) {
                for (int e : E) {
                    for (int s : S) {
                        if ((g + o+ e + s) % 7 == 0) answer += B.size() * I.size() * M.size();
                    }
                }
            }
        }
        for (int m : M) {
            for (int o : O)  {
                if ((m + 2*o) % 7 == 0) answer += B.size() * E.size() * S.size() * I.size() * G.size();
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("bgm.out"));
        out.write(answer + "\n");
        out.close();
    }
}
