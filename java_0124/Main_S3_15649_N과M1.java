package java_0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ¼ø¿­
public class Main_S3_15649_N°úM1 {

	static int N, M;
	static boolean[] isSelected;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N + 1];
		seq = new int[M];
		permut(0);
	}

	private static void permut(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(seq[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!isSelected[i]) {
				seq[cnt] = i;
				isSelected[i] = true;
				permut(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

}
