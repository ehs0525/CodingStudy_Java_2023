package java_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_G4_27923_햄버거최대몇개드실수있나요 {

	static int N, K, L;
	static Integer[] m, t;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		m = new Integer[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		t = new Integer[N];
		Arrays.fill(t, 0);
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int cola = Integer.parseInt(st.nextToken());
			if (cola <= N) {
				t[cola - 1]++;
			}
			if (cola + L <= N) {
				t[cola + L - 1]--;
			}
		}
		for (int i = 1; i < N; i++) {
			t[i] += t[i - 1];
		}

		Arrays.sort(m, Collections.reverseOrder());
		Arrays.sort(t, Collections.reverseOrder());

		long hcm = 0;
		for (int i = 0; i < N; i++) {
			hcm += m[i] / (int) Math.pow(2, t[i]);
		}

		System.out.print(hcm);
	}
}
