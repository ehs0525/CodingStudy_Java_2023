package java_0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_5567_°áÈ¥½Ä {

	static int n, m;
	static ArrayList<Integer>[] friends;

	static class Cohort {
		int idx, dist;

		public Cohort(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());

		friends = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			friends[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friends[a].add(b);
			friends[b].add(a);
		}

		System.out.print(bfs(new Cohort(1, 0)) - 1);
	}

	private static int bfs(Cohort sanggeun) {
		Queue<Cohort> q = new LinkedList<Cohort>();
		boolean[] visited = new boolean[n + 1];
		int cnt = 0;

		q.offer(sanggeun);
		visited[sanggeun.idx] = true;

		while (!q.isEmpty()) {
			Cohort curr = q.poll();
			cnt++;

			for (int i = 0; i < friends[curr.idx].size(); i++) {
				int ni = friends[curr.idx].get(i);
				int nd = curr.dist + 1;

				if (visited[ni])
					continue;
				if (nd > 2)
					continue;

				q.offer(new Cohort(ni, nd));
				visited[ni] = true;
			}
		}

		return cnt;
	}
}