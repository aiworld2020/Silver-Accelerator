import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class trapped {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("trapped.in"));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Long> sizes = new ArrayList<>();
        ArrayList<Long> location = new ArrayList<>();
        Haybale[] bales = new Haybale[N];


        String line = "";
        for (int i = 0; i < N; i++) {
            line = in.readLine();
            String[] parts = line.split(" ");
            sizes.add(Long.parseLong(parts[0]));
            location.add(Long.parseLong(parts[1]));
            bales[i] = new Haybale(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        Arrays.sort(bales);

        for (int i = 0; i < N; i++) {
            System.out.println("Posiion,Size == " + bales[i].position + "," + bales[i].size);
        }


        long area = 0;
        if (location.get(1) - location.get(0) > sizes.get(0)) {
            location.add(sizes.get(1));
        }
        for (int i = 1; i < N-1; i++) {
            if (location.get(i+1) - location.get(i) > sizes.get(i)) {
                area -= location.get(i+1) - location.get(i);
            } else {
                area += location.get(i+1) - location.get(i);
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("trapped.out"));
        out.write(area + "\n");
        out.close();
    }


    static class Haybale implements Comparable<Haybale> {
        public int position, size;
        public Haybale(int sizeIn, int positionIn) {
          size = sizeIn;
          position = positionIn;
        }
        public int compareTo(Haybale h) {
          // this will sort haybales from left to right
          return position - h.position;
        }
      }
}
