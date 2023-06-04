package java_0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_1484_다이어트 {

	static int G;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		G = Integer.parseInt(in.readLine());

		long prev = 1, curr = 2;
		boolean flag = false;
		while (curr <= 50000) {
			long gKG = curr * curr - prev * prev;

			if (gKG == G) {
				System.out.println(curr++);
				flag = true;
			} else if (gKG > G) {
				prev++;
			} else {
				curr++;
			}
		}

		if (!flag) {
			System.out.print(-1);
		}
	}

}
