import java.io.*;
import java.util.*;


public class slowdown {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("slowdown.in"));
        double n = Integer.parseInt(in.readLine());
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Double> distances = new ArrayList<>();
        String slowsdown = "";
        for (double i = 0; i < n; i++) {
            slowsdown = in.readLine();
            String[] parts = slowsdown.split(" ");
            if (parts[0].equals("T")){ 
                times.add(Double.parseDouble(parts[1]));
            }
            else if (parts[0].equals("D")) {
                distances.add(Double.parseDouble(parts[1]));
            }
        }
        

        Collections.sort(times);
        Collections.sort(distances);

        times.add(1e9);
        distances.add(1000.00);

        int dist_index = 0;
        int time_index = 0;
        int speed = 1;
        double dist_traveled = 0;
        double time_taken = 0;
        while (dist_index < distances.size()) {
            double t1 = times.get(time_index) - time_taken;
            double t2 = (distances.get(dist_index) - dist_traveled) * speed;
            if (t1 < t2) {
                dist_traveled += t1/speed;
                time_taken = times.get(time_index);
                time_index++;
            }
            else {
                dist_traveled = distances.get(dist_index);
                time_taken += t2;
                dist_index++;
            }
            speed++;
        }
        long answer = Math.round(time_taken);
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("slowdown.out"));
        out.write(answer + "\n");
        out.close();
    }
}
