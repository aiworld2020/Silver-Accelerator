        import java.util.Scanner;
        import java.io.IOException;

        public class guessnum {
            public static void main(String[] args) throws IOException {
                Scanner in = new Scanner(System.in);
                int low = 1;
                int high = (int) 1e6;
                while (low != high) {
                    int mid = (low + high + 1) / 2;
                    System.out.println(mid);
                    System.out.flush();
                    String s = in.nextLine();
                    if (s == ">=") {
                        low = mid;
                    }
                    else high = mid - 1;
                }
                in.close();
                System.out.println("! " + low);
                System.out.flush();
            }
            
        }
