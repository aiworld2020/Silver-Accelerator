import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class scode {
    static String code;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("scode.in"));
        code = in.readLine();
        in.close();

        int answer = recursion(code) - 1;
        BufferedWriter out = new BufferedWriter(new FileWriter("scode.out"));
        out.write(answer + "\n");
        out.close();
    }

    static int recursion(String s) {
        if (s.length() % 2 == 0 || s.length() == 1) {
            return 1;
        }
        else {
            int index = s.length()/2 + 1;

            int num1 = 0;
            int num2 = 0;
            String s1 = s.substring(0, index);
            if ((s1 + s1.substring(0,index-1)).equals(s)) num1++;
            if ((s1+s1.substring(1,index)).equals(s)) num1++;


            String s2 = s.substring(index-1, s.length());

            if ((s2.substring(0,index-1)+s2).equals(s)) num2++;
            if ((s2.substring(1,index)+s2).equals(s)) num2++;

            return 1 + num1 * recursion(s1) + num2 * recursion(s2);
        }
    }
}
