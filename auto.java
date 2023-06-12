import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class auto {
    final public static int MAXLENGTH = 1000;

	public static HashMap<String,Integer> dict;
	public static String[] words;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("auto.in"));
		String line = in.readLine();
        String[] parts = line.split(" ");
		int W = Integer.parseInt(parts[0]);
		int N = Integer.parseInt(parts[1]);

        words = new String[W];
		dict = new HashMap<String,Integer>();
		for (int i=0; i<W; i++) {
			words[i] = in.readLine();
			dict.put(words[i], i+1);
		}
		Arrays.sort(words);

		BufferedWriter out = new BufferedWriter(new FileWriter("auto.out"));

		for (int i=0; i<N; i++) {
			line =in.readLine();
            parts = line.split(" ");
			int index = Integer.parseInt(parts[0]);
			String prefix = parts[1];
			out.write(solve(prefix, index) + "\n");
		}

		in.close();
		out.close();
	}

	public static int solve(String prefix, int index) {
		char[] last = new char[MAXLENGTH+1];
		Arrays.fill(last, 'z');
		for (int i=0; i<prefix.length(); i++)
			last[i] = prefix.charAt(i);

		int start = binarySearch(prefix, 0, words.length);
		int end = binarySearch(new String(last), 0, words.length);

		if (index > end-start) return -1;

		return dict.get(words[start+index-1]);
	}

	public static int binarySearch(String prefix, int a, int b) {

		while (a < b-1) {
			int mid = (a+b)/2;
			if (prefix.compareTo(words[mid]) < 0)
				b = mid;
			else
				a = mid;
		}
		while (a < words.length && words[a].compareTo(prefix) < 0) a++;
		return a;
	}
}
