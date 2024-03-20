import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class gifts {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] preferences = new int[N+1][N+1];
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for (int i = 1; i <= N; i++) {
            String[] parts = in.readLine().split(" ");
            ts.add(i);
            for (int j = 1; j <= N; j++) {
                preferences[i][j] = Integer.parseInt(parts[j-1]);
            }
        }
        int idx = 0;
        int[] answer = new int[N+1];
        boolean[] change = new boolean[N+1];
        while (!ts.isEmpty()){
            for (int i = 1; i <= N; i++) {
                if (idx == 0) {
                    if (preferences[i][idx+1] == i && ts.contains(i) && !change[i]) {
                        System.out.println("hi");
                        change[i] = true;
                        ts.remove(i);
                        answer[i] = i;
                    }
                }
                else {
                    int curr = preferences[i][idx+1];
                    if (ts.contains(curr) && !change[i]) {
                        ts.remove(curr);
                        answer[i] = curr;
                    }
                }
            }
            idx++;
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
            //System.out.println(answer[i]);
        }
    }
}
