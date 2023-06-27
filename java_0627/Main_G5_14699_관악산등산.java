package java_0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14699_°ü¾Ç»êµî»ê {

	static int N, M;
	static int[] height, indegree, dp;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		height = new int[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());

			if (height[s1] > height[s2]) {
				graph[s1].add(s2);
				indegree[s2]++;
			} else {
				graph[s2].add(s1);
				indegree[s1]++;
			}
		}

		dp = new int[N + 1];
		topologySort();

		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i]);
		}
	}

	private static void topologySort() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				dp[i] = 1;
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < graph[curr].size(); i++) {
				int next = graph[curr].get(i);

				dp[next] = Integer.max(dp[next], dp[curr] + 1);
				if (--indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
