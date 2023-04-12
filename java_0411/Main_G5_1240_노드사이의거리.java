package java_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_1240_노드사이의거리 {

	static final int INF = (int) 1e9;

	static int N, M;
	static int[][] tree;

	static class Node {
		int num, dist;

		public Node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(tree[i], INF);
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree[a][b] = tree[b][a] = c;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(bfs(a, b)).append("\n");
		}

		System.out.print(sb);
	}

	private static int bfs(int src, int dest) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		q.offer(new Node(src, 0));
		visited[src] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.num == dest) {
				return curr.dist;
			}

			for (int i = 1; i <= N; i++) {
				if (i == curr.num || visited[i])
					continue;

				if (tree[curr.num][i] != INF) {
					q.offer(new Node(i, curr.dist + tree[curr.num][i]));
					visited[i] = true;
				}
			}
		}

		return -1;
	}

}
