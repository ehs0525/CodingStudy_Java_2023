package java_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_11050_이항계수1 {

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// nCr = n! / (r! * (n - r)!)
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.print(factorial(N) / factorial(K) / factorial(N - K));
	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

}
