package java_0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_2228_구간나누기 {

	static final int NEG_INF = -(int) 1e9;

	static int N, M;
	static int[] arr, prefixSum;
	static int[][] dp; // dp[i][j] : i개의 수를 j개의 구간으로 나누었을 때 최대 합

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = NEG_INF;
			}
		}

		dp[1][1] = arr[1];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int notIncluded = dp[i - 1][j];

				int included = NEG_INF;
				for (int k = i - 2; k >= (j > 1 ? 1 : -1); k--) {
					if (k > -1) {
						included = Integer.max(included, dp[k][j - 1] + prefixSum[i] - prefixSum[k + 1]);
					} else {
						included = Integer.max(included, prefixSum[i]);
					}
				}

				dp[i][j] = Integer.max(notIncluded, included);
			}
		}

		System.out.println(dp[N][M]);
	}

}
