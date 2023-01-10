package java_0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_11052_ī�屸���ϱ� {

	static int N;
	static int[] P, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		P = new int[N + 1];
		dp = new int[N + 1]; // dp[i] : i���� ī�带 �����ϱ� ���� �ִ� ���
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Integer.max(dp[i], dp[i - j] + P[j]);
			}
		}

		System.out.println(dp[N]);
	}

}
