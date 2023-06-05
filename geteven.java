import java.io.*;
import java.util.*;

public class geteven {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("geteven.in"));
        int N = Integer.parseInt(in.readLine());

        Integer[] Bs = new Integer[2];
        Integer[] Es = new Integer[2];
        Integer[] Ss = new Integer[2];
        Integer[] Is = new Integer[2];
        Integer[] Gs = new Integer[2];
        Integer[] Os = new Integer[2];
        Integer[] Ms = new Integer[2];

        Arrays.fill(Bs, 0);
        Arrays.fill(Es, 0);
        Arrays.fill(Ss, 0);
        Arrays.fill(Is, 0);
        Arrays.fill(Gs, 0);
        Arrays.fill(Os, 0);
        Arrays.fill(Ms, 0);

        String line = "";
        for (int i = 0; i < N; i++) {
            line = in.readLine();
            String[] parts = line.split(" ");
            int num = Integer.parseInt(parts[1]);
            if (parts[0].equals("B")) {
                if (num % 2 == 0) Bs[0]++;
                else Bs[1]++;
            }
            if (parts[0].equals("E")) {
                if (num % 2 == 0) Es[0]++;
                else Es[1]++;
            }
            if (parts[0].equals("S")) {
                if (num % 2 == 0) Ss[0]++;
                else Ss[1]++;
            }
            if (parts[0].equals("I")) {
                if (num % 2 == 0) Is[0]++;
                else Is[1]++;
            }
            if (parts[0].equals("G")) {
                if (num % 2 == 0) Gs[0]++;
                else Gs[1]++;
            }
            if (parts[0].equals("O")) {
                if (num % 2 == 0) Os[0]++;
                else Os[1]++;
            }
            if (parts[0].equals("M")) {
                if (num % 2 == 0) Ms[0]++;
                else Ms[1]++;
            }
        }
        int answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        for (int m = 0; m < 2; m++) {
                            for (int n = 0; n < 2; n++) {
                                for (int o = 0; o < 2; o++) {
                                    if (((Bs[i] + 2 * Es[j] + 2 * Ss[k] + Is[l]) * (Gs[m] + Os[n]+ Es[j] + Ss[k]) * (Ms[o] + 2*Os[n])) % 2 == 0) {
                                         answer += Bs[i] * Es[j] * Ss[k] * Is[l] * Gs[m] * Os[n] * Ms[o];
                                         //System.out.println(Bs[i] * Es[j] * Ss[k] * Is[l] * Gs[m] * Os[n] * Ms[o]);
                                    }
                                }
                            }
                        }
                    }
                }
            
            }
        }
        System.out.println(answer);
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("geteven.out"));
        out.write(answer + "\n");
        out.close();
    }
}
