package java_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합
public class Main_S5_1010_다리놓기 {

	static int T, N, M, cnt;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cnt = 0;

			dp = new int[M + 1][N + 1];

			sb.append(comb(M, Integer.min(N, M - N))).append("\n");

//			comb(0, 0);
//			sb.append(cnt).append("\n");
		}

		System.out.print(sb);
	}

	private static int comb(int m, int n) {
		if (dp[m][n] > 0)
			return dp[m][n];
		if (n == 0 || n == m)
			return 1;

		return dp[m][n] = comb(m - 1, n - 1) + comb(m - 1, n);
	}

//	private static void comb(int start, int idx) {
//		if (idx == N) {
//			cnt++;
//			return;
//		}
//
//		for (int i = start; i < M; i++) {
//			comb(i + 1, idx + 1);
//		}
//	}

}
