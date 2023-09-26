package java_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G4_14267_회사문화1 {

	static int n, m;
	static ArrayList<Integer>[] graph;
	static int[] compliment;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			int supervisor = Integer.parseInt(st.nextToken());
			if (supervisor != -1) {
				graph[supervisor].add(i);
			}
		}

		compliment = new int[n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			compliment[i] = w;
		}

		dfs(1);

		for (int i = 1; i <= n; i++) {
			System.out.print(compliment[i] + " ");
		}
	}

	private static void dfs(int supervisor) {
		for (int emp : graph[supervisor]) {
			compliment[emp] += compliment[supervisor];
			dfs(emp);
		}
	}

}
