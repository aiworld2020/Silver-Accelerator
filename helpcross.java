import java.util.*;
import java.io.*;

public class helpcross {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("helpcross.in"));
        String[] parts = in.readLine().split(" ");
		int C = Integer.parseInt(parts[0]);
		int N = Integer.parseInt(parts[1]);

		animal[] all = new animal[C+N];

		for (int i=0; i<C; i++) {
			int t = Integer.parseInt(in.readLine());
			all[i] = new animal(t, t, false);
		}

		for (int i=C; i<C+N; i++) {
            parts = in.readLine().split(" ");
			int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
			all[i] = new animal(s, e, true);
		}
		Arrays.sort(all);

		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i=0; i<all.length; i++) {
			if (all[i].isCow)
				pq.offer(all[i].end);
			else {
				while (pq.size() > 0 && pq.peek() < all[i].start) pq.poll();
				if (pq.size() > 0) {
					answer++;
					pq.poll();
				}
			}
		}
		BufferedWriter out = new BufferedWriter(new FileWriter("helpcross.out"));
		out.write(answer + "\n");
        in.close();
		out.close();
	}
}

class animal implements Comparable<animal> {
	public int start;
	public int end;
	public boolean isCow;

	public animal(int s, int e, boolean b) {
		start = s;
		end = e;
		isCow = b;
	}

	public int compareTo(animal other) {
		if (this.start != other.start)
			return this.start - other.start;
		if (this.isCow && !other.isCow) return -1;
		if (!this.isCow && other.isCow) return 1;
		return 0;
	}
}