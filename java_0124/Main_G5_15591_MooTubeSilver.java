package java_0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_15591_MooTubeSilver {

	static int N, Q;
	static ArrayList<Video>[] graph;
	static StringBuilder sb = new StringBuilder();

	static class Video {
		int idx, usado;

		public Video(int idx, int usado) {
			super();
			this.idx = idx;
			this.usado = usado;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			graph[p].add(new Video(q, r));
			graph[q].add(new Video(p, r));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			bfs(k, v);
		}

		System.out.println(sb);
	}

	private static void bfs(int K, int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int cnt = 0;

		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < graph[curr].size(); i++) {
				int nv = graph[curr].get(i).idx;
				int nu = graph[curr].get(i).usado;

				if (visited[nv])
					continue;

				if (nu >= K) {
					cnt++;

					q.offer(nv);
					visited[nv] = true;
				}

			}
		}

		sb.append(cnt).append("\n");
	}

}
