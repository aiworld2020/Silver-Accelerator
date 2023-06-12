import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class bteams {
    static int[] cow_levels = new int[12];
    static int[] cow_team = new int[12];
    static int[] team_count = new int[4];
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("bteams.in"));
        for (int i = 0; i < 12; i++) {
            cow_levels[i] = Integer.parseInt(in.readLine());
        }
        
        recursion(0);
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("bteams.out"));
        out.write(answer + "\n");
        out.close();
    }
    static void recursion(int x) {
        if (x == 12) {
            int[] teams = new int[4];
            for (int i = 0; i < 12; i++) {
                teams[cow_team[i]] += cow_levels[i];
            }
            int S = Math.max(Math.max(teams[0], teams[1]), Math.max(teams[2], teams[3]));
            int s = Math.min(Math.min(teams[0], teams[1]), Math.min(teams[2], teams[3]));
            if (answer == -1 || S-s < answer) {
                answer = S-s;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (team_count[i] < 3) {
                cow_team[x] = i;
                team_count[i]++;
                recursion(x+1);
                team_count[i]--;
            }
        }
    }
}
