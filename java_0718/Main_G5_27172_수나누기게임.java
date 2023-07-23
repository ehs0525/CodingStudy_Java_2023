package java_0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_27172_수나누기게임 {

	static int N;
	static int[] card, score, ownerOf;
	static boolean[] isPrime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		card = new int[N + 1];
		score = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int max = 0;
		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			max = Integer.max(max, card[i]);
		}

		isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		ownerOf = new int[max + 1];
		for (int i = 1; i <= N; i++) {
			ownerOf[card[i]] = i;
		}

		for (int i = 1; i <= N; i++) {
			int num = card[i];
			if (isPrime[num]) {
				int j = 2;
				while (num * j <= max) {
					if (ownerOf[num * j] > 0) {
						score[i]++;
						score[ownerOf[num * j]]--;
					}
					j++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(score[i] + " ");
		}
	}

}
