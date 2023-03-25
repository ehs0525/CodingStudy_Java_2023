package java_0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_4781_ªÁ≈¡∞°∞‘ {

	static int N, M, C, P;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = (int) (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

			if (N == 0)
				break;

			dp = new int[M + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				C = Integer.parseInt(st.nextToken());
				P = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

				for (int j = P; j <= M; j++) {
					dp[j] = Integer.max(dp[j], dp[j - P] + C);
				}
			}
			sb.append(dp[M]).append("\n");
		}

		System.out.print(sb);
	}

}
