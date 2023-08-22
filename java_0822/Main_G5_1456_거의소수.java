package java_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1456_거의소수 {

	static long A, B;
	static ArrayList<Integer> primes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		setPrimeList();

		int cnt = 0;
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);

			for (int j = 2; Math.pow(prime, j) <= B; j++) {
				if (Math.pow(prime, j) >= A)
					cnt++;
			}
		}

		System.out.print(cnt);
	}

	private static void setPrimeList() {
		boolean[] isPrime = new boolean[(int) Math.sqrt(B) + 1];
		Arrays.fill(isPrime, true);

		int limit = (int) Math.sqrt(B);
		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				int j = 2;
				while (i * j <= limit) {
					isPrime[i * j] = false;
					j++;
				}
			}
		}

		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}

}
