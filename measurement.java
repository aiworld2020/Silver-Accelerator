import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class measurement {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("measurement.in"));
        String[] parts = in.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);

        int[] cownum = new int[1000001];
		int[] delta = new int[1000001];
		HashMap<Integer, Integer> cows = new HashMap<Integer,Integer>();
		int num = 1;

		for (int i=0; i<N; i++) {
            parts = in.readLine().split(" ");
			int day = Integer.parseInt(parts[0]);
			cownum[day] = Integer.parseInt(parts[1]);

			if (!cows.containsKey(cownum[day])) cows.put(cownum[day], num++);

			String tmp = parts[2];
			if (tmp.charAt(0) == '+') tmp = tmp.substring(1);
			delta[day] = Integer.parseInt(tmp);
		}

		for (int i=0; i<cownum.length; i++)
			if (cownum[i] != 0)
				cownum[i] = cows.get(cownum[i]);

		int[] milk = new int[num];
		TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();

		tm.put(0, num);
		int answer = 0, max = 0;
		for (int i=0; i<cownum.length; i++) {

			if (cownum[i] == 0) continue;
			int prev = milk[cownum[i]];
			int cur = prev + delta[i];
			milk[cownum[i]] = cur;
			int numOld = tm.get(prev);
			boolean flag = false;
			if (numOld == 1) {
				flag = true;
				tm.remove(prev);
			}
			else
				tm.put(prev, numOld-1);
			if (tm.containsKey(cur))
				tm.put(cur, tm.get(cur)+1);
			else
				tm.put(cur, 1);

            if (prev < max && cur >= max) answer++;
            if (prev == max && numOld > 1 && cur > max) answer++;

			int newtop = tm.lastKey();
			if (prev == max && cur < newtop) answer++;
			if (prev == max && cur == newtop && tm.get(newtop) > 1) answer++;

			max = newtop;
		}
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("measurement.out"));
        out.write(answer + "\n");
        out.close();
    }
}
    