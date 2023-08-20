import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class reorder {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("reorder.in"));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(in.readLine()));
        }
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(in.readLine()));
        }

        boolean[] visited = new boolean[N+1];
        int groups = 0;
        int c_largest = 0;
        int a_largest = -1;

        int curr = 0;
        for (int i = 0; i < N; i++) {
            if(A.get(i) != B.get(i) && !visited[A.get(i)]) {
                curr = A.get(i);
                while(!visited[curr]){
                    visited[curr] = true;
                    curr = A.get(B.indexOf(curr));
                    c_largest++;
                }
                groups++;
                if (c_largest > a_largest) a_largest = c_largest;
                c_largest = 0;
            }
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("reorder.out"));
        out.write(groups + " " + a_largest + "\n");
        out.close();
    }
}