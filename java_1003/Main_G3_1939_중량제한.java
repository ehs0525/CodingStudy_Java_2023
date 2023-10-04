package java_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G3_1939_중량제한 {

	static int N, M, S, D;
	static boolean canMove;
	static List<Bridge>[] graph;
	static boolean[] visited;

	static class Bridge {
		int island, limit;

		public Bridge(int island, int limit) {
			super();
			this.island = island;
			this.limit = limit;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int left = 1, right = 1, result = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new Bridge(B, C));
			graph[B].add(new Bridge(A, C));
			right = Integer.max(right, C);
		}

		st = new StringTokenizer(in.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		while (left <= right) {
			int mid = (left + right) / 2;
			canMove = false;
			visited = new boolean[N + 1];

			dfs(S, mid);
			if (canMove) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.print(result);
	}

	private static void dfs(int island, int weight) {
		if (island == D) {
			canMove = true;
			return;
		}

		visited[island] = true;
		for (Bridge bridge : graph[island]) {
			if (!visited[bridge.island] && weight <= bridge.limit) {
				dfs(bridge.island, weight);
			}
		}
	}

}
