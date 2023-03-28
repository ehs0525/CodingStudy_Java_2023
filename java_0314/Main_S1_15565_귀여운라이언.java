package java_0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_15565_귀여운라이언 {

	static int N, K;
	static int[] dolls;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dolls = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			dolls[i] = Integer.parseInt(st.nextToken());
		}

		int start = K, end = N, result = -1;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (countRyans(mid) >= K) {
				end = mid - 1;
				result = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(result);
	}

	private static int countRyans(int size) {
		int max = 0, cnt = 0;
		for (int i = 0; i < size; i++) {
			if (dolls[i] == 1)
				max++;
		}
		cnt = max;
		for (int j = 1; j <= N - size; j++) {
			if (dolls[j - 1] == 1)
				cnt--;
			if (dolls[j + size - 1] == 1)
				cnt++;
			max = Integer.max(max, cnt);
		}
		return max;
	}

}
