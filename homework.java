import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;

public abstract class homework {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("homework.in"));
        int N = Integer.parseInt(in.readLine());
        int[] scores = new int[N];
        String[] parts = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(parts[i]);
        }
        in.close();
        BufferedWriter out = new BufferedWriter(new FileWriter("homework.out"));
        long min = Integer.MAX_VALUE;
		long sum = 0;
		long bestSum = 0;
		long bestLeft = 1;
		LinkedList<Integer> allValid = new LinkedList<Integer>();
		for(int i = N-1; i > 0; i--) {
			sum += scores[i];
			min = Math.min(min, scores[i]);
			if(i <= N-2 && (sum-min) * bestLeft > bestSum * (N-i-1)) {
				allValid.clear();
				bestSum = sum-min;
				bestLeft = N-i-1;
			}
			if(i <= N-2 && (sum-min) * bestLeft == bestSum * (N-i-1)) {
				allValid.addFirst(i);
			}
		}
		for(int i: allValid) {
			out.write(i + "\n");
		}
		out.close();
    }
}
