import java.io.*;
import java.util.*;

public class cowjog {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowjog.in"));
        String initials = in.readLine();
        String[] parts1 = initials.split(" ");
        int n = Integer.parseInt(parts1[0]);
        long t = Long.parseLong(parts1[1]);
        ArrayList<Long> positions = new ArrayList<>();
        ArrayList<Long> speeds = new ArrayList<>();
        String cow = "";
        for (int i = 0; i < n; i++) {
            cow = in.readLine();
            String[] parts2 = cow.split(" ");
            positions.add(Long.parseLong(parts2[0]));
            speeds.add(Long.parseLong(parts2[1]));
        }
        int answer = 0;
        long group_end = Long.MAX_VALUE;
        long current = 0;
        for (int i = n - 1; i >= 0; i--) {
            current = positions.get(i) + speeds.get(i) * t;
            if (current < group_end) {
                answer++;
                group_end = current;
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("cowjog.out"));
        out.write(answer + "\n");
        out.close();

    }
}