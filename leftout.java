    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;

    public class leftout {
        static int N;
        static Character[][] directions;
        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new FileReader("leftout.in"));
            N = Integer.parseInt(in.readLine());
            directions = new Character[N][N];

            for (int i = 0; i < N; i++) {
                String line = in.readLine();
                for (int j = 0; j < N; j++) {
                    directions[i][j] = line.charAt(j);
                }
            }

            in.close();

            for (int j = 0; j < N; j++) {
                if (directions[0][j] == 'L') {
                    for (int i = 0; i < N; i++) {
                        if (directions[i][j] == 'L') directions[i][j] = 'R';
                        else directions[i][j] = 'L';
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (directions[i][0] == 'L') {
                    for (int j = 0; j < N; j++) {
                        if (directions[i][j] == 'L') directions[i][j] = 'R';
                        else directions[i][j] = 'L';
                    }
                }
            }

            BufferedWriter out = new BufferedWriter(new FileWriter("leftout.out"));
            int count = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (directions[i][j] == 'L') count++;
                }
            }

            if (count == (N-1)*(N-1)) out.write(1 + " " + 1 + "\n");
            else if (count == N-1) {
                int row_count = 0;
                for (int i = 1; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (directions[i][j] == 'L') row_count++;
                    }
                    if (row_count == N-1) out.write((i + 1) + " " + 1 + "\n");
                    row_count = 0;
                }

                int col_count = 0;
                for (int j = 1; j < N; j++) {
                    for (int i = 1; i < N; i++) {
                        if (directions[i][j] == 'L') col_count++;
                    }
                    if (col_count == N-1) out.write(1 + " " + (j+1) + "\n");
                    col_count = 0;
                }
            }
            else if (count == 1) {
                for (int i = 1; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (directions[i][j] == 'L') out.write((i+1) + " " + (j+1) + "\n");
                    }
                }
            }
            else out.write(-1 + "\n");
            out.close();
        }
    }
