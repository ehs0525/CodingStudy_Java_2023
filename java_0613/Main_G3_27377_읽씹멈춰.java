package java_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_G3_27377_ÀÐ¾Ã¸ØÃç {

	static int T;
	static long n;
	static BigInteger s, t;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			n = Long.parseLong(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			s = new BigInteger(st.nextToken());
			t = new BigInteger(st.nextToken());

			BigInteger time = new BigInteger("0");
			while (n > 0) {
				if (n % 2 == 0) {
					BigInteger wd = s.multiply(BigInteger.valueOf(n / 2)); // s * (n / 2)
					BigInteger cp = t; // t
					time = time.add(wd.min(cp)); // time += Long.min(wd, cp)
					n /= 2;
				} else {
					time = time.add(s); // time += s
					n--;
				}
			}
			sb.append(time).append("\n");
		}

		System.out.print(sb);
	}

}
