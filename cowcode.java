import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class cowcode {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowcode.in"));
        String line = in.readLine();
        String[] parts = line.split(" ");

        String code = parts[0];
        long N = Long.parseLong(parts[1]);

        char answer = parse(N, code);
        in.close();

        BufferedWriter out = new BufferedWriter(new FileWriter("cowcode.out"));
        out.write(answer + "\n");
        out.close();

    }

    static char parse(long N, String code) {
        long length = code.length();
        if (N <= length) {
            return (code.charAt((int)N -1));
        }

        while(2 * length < N) {
            length *=2;
        }

        if (length + 1 != N) {
            return parse(N-length-1, code);
        } else {
            return parse(N-1, code);
        }

    }
}
