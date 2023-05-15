package java_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_2011_암호코드 {

	static final int MOD = 1000000;

	static String str;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		str = in.readLine();
		dp = new int[str.length() + 1];

		dp[0] = dp[1] = 1;
		if (str.charAt(0) == '0') {
			System.out.print(0);
			return;
		}
		for (int i = 2; i < dp.length; i++) {
			// 자신만 고려
			if (str.charAt(i - 1) > '0') {
				dp[i] += dp[i - 1] * 1;
				dp[i] %= MOD;
			} else if (str.charAt(i - 2) >= '3') {
				System.out.print(0);
				return;
			}

			// 앞 숫자도 고려
			int temp = Integer.parseInt(str.substring(i - 2, i));
			if (temp >= 10 && temp <= 26) {
				dp[i] += dp[i - 2] * 1 % MOD;
				dp[i] %= MOD;
			}
		}

		System.out.print(dp[str.length()]);
	}

}
