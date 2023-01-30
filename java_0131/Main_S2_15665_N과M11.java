package java_0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S2_15665_N과M11 {

	static int N, M;
	static int[] num, seq;
	static HashSet<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	// 중복순열
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		seq = new int[M];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		pwr(0);
		System.out.println(sb);
	}

	private static void pwr(int cnt) {
		if (cnt == M) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < M; i++) {
				temp.append(seq[i]).append(" ");
			}
			temp.append("\n");

			String str = temp.toString();
			if (set.contains(str))
				return;
			set.add(str);
			sb.append(str);
			return;
		}

		for (int i = 0; i < N; i++) {
			seq[cnt] = num[i];
			pwr(cnt + 1);
		}
	}

}
