package java_0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_1107_¸®¸ðÄÁ {

	static int N, M;
	static boolean[] isBroken = new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < M; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int min = Math.abs(N - 100);
		for (int i = 0; i <= 999999; i++) {
			String si = String.valueOf(i);

			boolean isMovable = true;
			for (int j = 0; j < si.length(); j++) {
				if (isBroken[si.charAt(j) - '0']) {
					isMovable = false;
					break;
				}
			}

			if (isMovable) {
				min = Integer.min(min, si.length() + Math.abs(N - i));
			}
		}

		System.out.print(min);
	}

}
