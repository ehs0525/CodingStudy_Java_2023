package java_0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복조합
public class Main_S3_15652_N과M4 {

	static int N, M;
	static int[] seq;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		seq = new int[M];
		cwr(1, 0);
		System.out.println(sb);
	}

	private static void cwr(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(seq[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			seq[cnt] = i;
			cwr(i, cnt + 1);
		}
	}

}
