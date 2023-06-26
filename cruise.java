import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class cruise {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cruise.in"));
        String[] parts = in.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        int K = Integer.parseInt(parts[2]);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= N; i++) {
            parts = in.readLine().split(" ");
            int left = Integer.parseInt(parts[0]);
            int right = Integer.parseInt(parts[1]);
            adj.get(i).add(left);
            adj.get(i).add(right);
        }
        
        int port = 1;
        boolean repeat = false;
        ArrayList<Integer> visited = new ArrayList<Integer>();
        visited.add(1);
        parts = in.readLine().split(" ");
        in.close();
        for (int j = 0; j < (K); j++){
            for (int i = 0; i < M; i++) {
                if (parts[i].equals("L")) port = adj.get(port).get(0);
                else port = adj.get(port).get(1);     
            }
            if (visited.contains(port)) {
                repeat = true;
                break;
            }
            else visited.add(port);
        }
        if (repeat) {
            port = visited.get(K%visited.size());
        }
        for (int i = 0; i < visited.size(); i++) {
            System.out.println(visited.get(i));
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("cruise.out"));
        out.write((port) + "\n");
        out.close();
    }
}
