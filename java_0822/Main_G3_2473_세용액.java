package java_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G3_2473_¼¼¿ë¾× {

	static int N;
	static int[] cv;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		cv = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cv[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cv);

		int first = 0, second = 0, third = 0;
		long minDiff = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {

			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				long sum = (long) cv[i] + (long) cv[left] + (long) cv[right];

				if (Math.abs(sum) < minDiff) {
					minDiff = Math.abs(sum);

					first = cv[i];
					second = cv[left];
					third = cv[right];
				}

				if (sum < 0) {
					left++;
				} else if (sum == 0) {
					break;
				} else {
					right--;
				}
			}
		}

		System.out.print(first + " " + second + " " + third);
	}

}
