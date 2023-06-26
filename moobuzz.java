import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class moobuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("moobuzz.in"));
        long N = Long.parseLong(in.readLine());
        long a = 0;
        long b = (long)Integer.MAX_VALUE;
        long answer = 0;
        while (true) {
            long mid = (a+b) / 2;
            long guess = count(mid);
            if (guess< N) {
                a=mid+1;
            }
            else if (guess > N) {
                b=mid-1;
            }
            else {
                answer = mid;
                while(answer % 3 == 0 || answer % 5 == 0) answer--;   
                break;
            }
        }
        in.close();
        System.out.println(answer);
        BufferedWriter out = new BufferedWriter(new FileWriter("moobuzz.out"));
        out.write(answer + "\n");
        out.close();
    }
    public static long count(long n) {
        return n - n/3 - n/5 + n/15;
    }
}
