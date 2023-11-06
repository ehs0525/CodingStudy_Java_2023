package java_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_1309_동물원 {

	static final int MOD = 9901;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		// d[i][0] : 사자를 배치하지 않음, d[i][1] : 왼쪽에 사자를 배치함, d[i][2] : 오른쪽에 사자를 배치함
		int[][] dp = new int[N + 1][3];

		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}

		System.out.print((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
	}

}
