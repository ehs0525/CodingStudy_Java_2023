package java_0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_17305_ªÁ≈¡πË¥ﬁ {

	static int N, w;
	static ArrayList<Integer> small = new ArrayList<>();
	static ArrayList<Integer> large = new ArrayList<>();
	static long[] sSum, lSum;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			if ("3".equals(st.nextToken())) {
				small.add(Integer.parseInt(st.nextToken()));
			} else {
				large.add(Integer.parseInt(st.nextToken()));
			}
		}

		Collections.sort(small, Collections.reverseOrder());
		Collections.sort(large, Collections.reverseOrder());

		sSum = new long[small.size() + 1];
		lSum = new long[large.size() + 1];
		for (int i = 1; i <= small.size(); i++) {
			sSum[i] = sSum[i - 1] + small.get(i - 1);
		}
		for (int i = 1; i <= large.size(); i++) {
			lSum[i] = lSum[i - 1] + large.get(i - 1);
		}

		long max = 0;
		for (int i = 0; i <= Integer.min(small.size(), w / 3); i++) { // ¿€¿∫ ªÁ≈¡ i∞≥
			int j = Integer.min(large.size(), (w - i * 3) / 5); // ≈´ ªÁ≈¡ j∞≥
			max = Long.max(max, sSum[i] + lSum[j]);
		}

		System.out.println(max);
	}
}
