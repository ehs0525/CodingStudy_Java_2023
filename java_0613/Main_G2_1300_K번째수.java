package java_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1 2 3
//2 4 6
//3 6 9
//
//1 2 2 3 3 4 6 6 9 // B[7]=6 B[8]=6
//B[k]=x : x보다 작거나 같은 수가 최소 k개 있다
public class Main_G2_1300_K번째수 {

	static int N, k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		k = Integer.parseInt(in.readLine());

		int s = 1, e = k, result = 0;
		while (s <= e) {
			int mid = (s + e) / 2;

			if (countLessThanOrEqualTo(mid) >= k) {
				e = mid - 1;
				result = mid;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(result);
	}

	private static int countLessThanOrEqualTo(int x) {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += Math.min(x / i, N);
		}

		return cnt;
	}
}
