import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Collections;

public class records {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("records.in"));
        int N = Integer.parseInt(in.readLine());

        TreeSet<String> ts = new TreeSet<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for (int i = 0; i < N; i++) {
            String cowGroup = in.readLine();
            String[] cows = cowGroup.split(" ");
            Arrays.sort(cows);
            String sortedCowGroup = "";
            for (int j = 0; j < 2; j++) {
                sortedCowGroup += cows[j] + " ";
            }
            sortedCowGroup += cows[2];
            if (!ts.contains(sortedCowGroup)) {
                ts.add(sortedCowGroup);
                hm.put(sortedCowGroup, 1);
            }
            else {
                hm.replace(sortedCowGroup, hm.get(sortedCowGroup) + 1);
            }   
        }
        int answer = Collections.max(hm.values());
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("records.out"));
        out.write(answer + "\n");
        out.close();
    }
}
