package java_0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2230_수고르기 {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(A);

		int l = 0, r = 0, min = 2000000000;
		while (l <= r && r < N) {
			int diff = A[r] - A[l];
			if (diff < M) {
				r++;
			} else {
				l++;
				min = Integer.min(min, diff);
			}
		}

		System.out.print(min);
	}

}
