package java_0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_2193_ÀÌÄ£¼ö {

	static int N;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		dp = new long[N + 1][2];
		dp[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}

		System.out.print(dp[N][0] + dp[N][1]);
	}

}
