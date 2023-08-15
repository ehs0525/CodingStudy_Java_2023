package java_0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_25682_체스판다시칠하기2 {

	static int N, M, K;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = in.readLine().toCharArray();
		}

		System.out.print(Integer.min(repaint('B'), repaint('W')));
	}

	private static int repaint(char color) {
		int[][] prefixSum = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int xor = 0;
				if ((i + j) % 2 == 0 && board[i][j] != color || (i + j) % 2 != 0 && board[i][j] == color) {
					xor = 1;
				}

				prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + xor;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = 1; j <= M - K + 1; j++) {
				min = Integer.min(min, prefixSum[i + K - 1][j + K - 1] - prefixSum[i + K - 1][j - 1]
						- prefixSum[i - 1][j + K - 1] + prefixSum[i - 1][j - 1]);
			}
		}

		return min;
	}

}
