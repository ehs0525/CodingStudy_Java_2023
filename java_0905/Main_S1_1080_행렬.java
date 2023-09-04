package java_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1080_За·Д {

	static int N, M;
	static char[][] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new char[N][M];
		B = new char[N][M];
		for (int i = 0; i < N; i++) {
			A[i] = in.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			B[i] = in.readLine().toCharArray();
		}

		int cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					transform(i, j);
					cnt++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					System.out.print(-1);
					return;
				}
			}
		}

		System.out.print(cnt);
	}

	private static void transform(int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				A[i][j] = A[i][j] == '0' ? '1' : '0';
			}
		}
	}

}
