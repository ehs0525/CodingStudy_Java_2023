package java_0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Á¶ÇÕ
public class Main_S3_15650_N°úM2 {

	static int N, M;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		seq = new int[M];
		comb(1, 0);
	}

	private static void comb(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(seq[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			seq[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

}
