import java.io.*;
import java.util.*;

public class skidesign {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("skidesign.in"));
        int n = Integer.parseInt(in.readLine());
        ArrayList<Integer> skiheights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            skiheights.add(Integer.parseInt(in.readLine()));
        }

        Collections.sort(skiheights);


        int total = 2147483647;
		for(int i = 0; i <= 83; i++) {
            int units = 0;
            int diff = 0;
            for (int j = 0; j < n; j++) {
                if (i>skiheights.get(j)) {
                    diff=i-skiheights.get(j);
                } else if (i<skiheights.get(j)-17) {
                    diff=skiheights.get(j)-i-17;
                } else {
                    diff = 0;
                }
                units+=diff*diff;
            }
            total=Math.min(units, total);
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("skidesign.out"));
        out.write(total + "\n");
        out.close();
    }
}
