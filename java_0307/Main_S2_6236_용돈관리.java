package java_0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_6236_¿ëµ·°ü¸® {

	static int N, M;
	static int[] use;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int s = 1, e = (int) 1e9, K = 0;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		use = new int[N];
		for (int i = 0; i < N; i++) {
			use[i] = Integer.parseInt(in.readLine());
			s = Integer.max(s, use[i]);
		}

		while (s <= e) {
			int mid = (s + e) / 2;

			if (countWithdrawalNum(mid) > M) {
				s = mid + 1;
			} else {
				e = mid - 1;
				K = mid;
			}
		}

		System.out.println(K);
	}

	private static int countWithdrawalNum(int k) {
		int r = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			if (r < use[i]) {
				r = k;
				cnt++;
			}

			r -= use[i];
		}

		return cnt;
	}

}
