package java_0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// ¼ø¿­
public class Main_S2_15663_N°úM9 {

	static int N, M;
	static int[] num, seq;
	static boolean[] isSelected;
	static HashSet<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		seq = new int[M];
		isSelected = new boolean[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		permut(0);
		System.out.print(sb);
	}

	private static void permut(int cnt) {
		if (cnt == M) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < M; i++) {
				temp.append(seq[i]).append(" ");
			}
			temp.append("\n");

			String str = temp.toString();
			if (set.contains(str))
				return;
			set.add(str);
			sb.append(str);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				seq[cnt] = num[i];
				isSelected[i] = true;
				permut(cnt+1);
				isSelected[i] = false;
			}
		}

	}

}
