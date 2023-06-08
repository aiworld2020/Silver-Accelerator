import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class clumsy {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("clumsy.in"));
        String parenthesis = in.readLine();
        int N = parenthesis.length();
        in.close();
        
        int answer = 0;
        int depth = 0;
        
        for (int i = 0; i < N; i++) {
            if (parenthesis.charAt(i) == '(') {
                depth++;
            }
            else depth--;
            if (depth < 0) {
                System.out.println("hi");
                answer++;
                depth += 2;
            }
            System.out.println(depth);
        }
        
        answer += depth/2;
        BufferedWriter out = new BufferedWriter(new FileWriter("clumsy.out"));
        out.write(answer + "\n");
        out.close();
    }
}
