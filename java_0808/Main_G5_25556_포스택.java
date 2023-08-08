package java_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_25556_Æ÷½ºÅÃ {

	static int N;
	static int[] A;
	static Stack<Integer>[] s = new Stack[4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		A = new int[N];
		for (int i = 0; i < 4; i++) {
			s[i] = new Stack<>();
		}

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			boolean clean = false;
			for (int j = 0; j < s.length; j++) {

				if (s[j].isEmpty() || s[j].peek() < A[i]) {
					s[j].push(A[i]);
					clean = true;
					break;
				}
			}

			if (!clean) {
				System.out.print("NO");
				return;
			}
		}
		System.out.print("YES");
	}

}
