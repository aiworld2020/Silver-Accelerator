import java.io.*;
import java.util.*;

public class convention2 {
    static int N;
    static cow[] cows;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("convention2.in"));
        int N = Integer.parseInt(in.readLine());
        cows = new cow[N];

        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            String[] parts = line.split(" ");
            int start = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[1]);
            cows[i] = new cow(start, time, i);
        }
        Arrays.sort(cows);

        PriorityQueue<cow> pq = new PriorityQueue<cow>(new Comparator<cow>() {
            public int compare(cow a, cow b) {
                return a.priority - b.priority;
            }
        });
        in.close();
        int currentC = 0;
        int currentT = 0;
        int answer = 0;
        while(currentC < N || pq.size() > 0) {
            if (currentC < N && cows[currentC].start <= currentT) {
                pq.add(cows[currentC++]);
            }
            else if (pq.size() == 0) {
                cow current = cows[currentC++];
                currentT = current.start + current.time;
            }
            else {
                cow current = pq.poll();
                answer = Math.max(answer, currentT- current.start);
                currentT += current.time;
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("convention2.out"));
        out.write(answer + "\n");
        out.close();

    }
    static class cow implements Comparable<cow> {
        public int start;
        public int time;
        public int priority;
        
        public cow(int start, int time, int priority) {
            this.start = start;
            this.time = time;
            this.priority = priority;
        }

        public int compareTo(cow a) {
            return this.start - a.start;
        }
    }
}
