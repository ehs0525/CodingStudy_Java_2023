package java_0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Á¶ÇÕ
public class Main_S3_15655_N°úM6 {

	static int N, M;
	static int[] num, seq;
	static StringBuilder sb = new StringBuilder();

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

		comb(0, 0);
		System.out.println(sb);
	}

	private static void comb(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(seq[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			seq[cnt] = num[i];
			comb(i + 1, cnt + 1);
		}
	}

}
