package java_0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * degurii.tistory.com/171 Âü°í 
 */
public class Main_P5_16287_Parcel {

	static int w, n;
	static int[] A, p1, p2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		A = new int[n + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		p1 = new int[400000];
		p2 = new int[400000];
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int sum = A[i] + A[j];

				p1[sum] = i;
				p2[sum] = j;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				int target = w - (A[i] + A[j]);

				if (target < 0 || target >= 400000 || p1[target] == 0)
					continue;
				if (p1[target] == i || p1[target] == j || p2[target] == i || p2[target] == j)
					continue;

				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

}
