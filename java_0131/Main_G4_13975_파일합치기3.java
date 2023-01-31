package java_0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_13975_파일합치기3 {

	static int T, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			PriorityQueue<Long> pq = new PriorityQueue<>();

			K = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < K; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}

			sb.append(combineFiles(pq)).append("\n");
		}

		System.out.println(sb);
	}

	private static long combineFiles(PriorityQueue<Long> pq) {
		long cost = 0L;

		while (pq.size() > 1) {
			long c1 = pq.poll();
			long c2 = pq.poll();
			long x = c1 + c2;

			cost += x;
			pq.offer(x);
		}

		return cost;
	}

}
