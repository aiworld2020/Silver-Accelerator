import java.io.*;
import java.util.*;

public class pairup {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("pairup.in"));
        long N = Long.parseLong(in.readLine());
        long answer = 0;
        ArrayList<Integer> oddcows = new ArrayList<>();
        
        String line = "";
        for (int i = 0; i < N; i++) {
            line = in.readLine();
            String[] parts = line.split(" ");
            oddcows.add(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
        }

        Collections.sort(oddcows);
        long current_time = 0;
        long left_index = 0;
        long right_index = oddcows.size()-1;
        while(left_index < oddcows.size()/2) {
            current_time = oddcows.get((int)left_index) + oddcows.get((int)right_index);
            answer = Math.max(answer, current_time);
            left_index++;
            right_index--;
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("pairup.out"));
        out.write(answer + "\n");
        out.close();    
    }
}
