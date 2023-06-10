import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class convention {
    public static void main(String[] args) throws IOException {
         BufferedReader in = new BufferedReader(new FileReader("convention.in"));
         String line = in.readLine();
         String[] parts = line.split(" ");
         int N = Integer.parseInt(parts[0]);
         int M = Integer.parseInt(parts[1]);
         int C = Integer.parseInt(parts[2]);

         Integer[] times = new Integer[N];
         line = in.readLine();
         parts = line.split(" ");
         for (int i = 0; i<N; i++) {
            times[i] = Integer.parseInt(parts[i]);
         }
         Arrays.sort(times);

         int a = 0;
         int b = (int)1e9;
         while(a != b) {
             int mid = (a+b)/2;
             if (checkTime(mid, N, M, C, times)) {
                 b = mid;
             } else {
                 a = mid+1;
             }
         }
         in.close();
         BufferedWriter out = new BufferedWriter(new FileWriter("convention.out"));
         out.write(b + "\n");
         out.close();

    }
    static boolean checkTime(int mid, int N, int M, int C, Integer[] times) {
        int cowCount = 0;
        int busCount = 0;
        int starttime = 0;
        for (int i = 0; i < N; i++) {
            cowCount++;
            if (cowCount == 1){
                if (times[i] > mid) {
                    cowCount = 0;
                    busCount++;
                    starttime=0;
                } 
                else starttime = times[i];
            } else {
                if (times[i] - starttime > mid) {
                    cowCount = 0;
                    busCount++;
                    starttime=0;
                }
            }
            if (cowCount == C) {
                busCount++;
                cowCount = 0;
                starttime = 0;
            }
            if (busCount > M) {
                return false;
            }
        }
        return true;
    }
}
