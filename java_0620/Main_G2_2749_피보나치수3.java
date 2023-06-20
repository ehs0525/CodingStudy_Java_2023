package java_0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// chb2005.tistory.com/141
public class Main_G2_2749_피보나치수3 {

	static final int MOD = 1000000;
	static long n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Long.parseLong(in.readLine());
		int pp = getPisanoPeriod();

		if (n == 0) {
			System.out.print(0);
		} else if (n == 1) {
			System.out.print(1);
		} else {
			int f0 = 0, f1 = 1, f2 = 0;
			for (int i = 2; i <= n % pp; i++) {
				f2 = (f0 + f1) % MOD;

				f0 = f1;
				f1 = f2;
			}

			System.out.print(f2);
		}
	}

	private static int getPisanoPeriod() {
		int f0 = 0, f1 = 1, idx = 1;
		while (true) {
			int f2 = (f0 + f1) % MOD;
			if (f1 == 0 && f2 == 1)
				return idx;

			f0 = f1;
			f1 = f2;
			idx++;
		}
	}

}
