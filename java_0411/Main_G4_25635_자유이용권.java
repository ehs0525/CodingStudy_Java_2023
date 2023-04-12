package java_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_25635_자유이용권 {

	static int N;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		a = new int[N];
		long total = 0;
		int max = 0;
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			total += a[i];
			max = Integer.max(max, a[i]);
		}

		if (max > (total + 1) / 2) {
			System.out.print((total - max) * 2 + 1);
		} else {
			System.out.print(total);
		}
	}

}
