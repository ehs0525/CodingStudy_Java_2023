package java_0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로 {

	static final int INF = (int) 1e8;

	static int N, E;
	static int[] d;
	static ArrayList<Node>[] graph;

	static class Node implements Comparable<Node> {
		int idx, dist;

		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(in.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int len1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		int len2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

		System.out.print(len1 >= INF && len2 > INF ? -1 : Integer.min(len1, len2));
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		d = new int[N + 1];
		Arrays.fill(d, INF);

		pq.offer(new Node(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int idx = curr.idx;
			int dist = curr.dist;

			if (d[idx] < dist)
				continue;
			for (int i = 0; i < graph[idx].size(); i++) {
				int ni = graph[idx].get(i).idx;
				int nd = graph[idx].get(i).dist;

				if (d[ni] < d[idx] + nd)
					continue;
				pq.offer(new Node(ni, d[idx] + nd));
				d[ni] = d[idx] + nd;
			}
		}

		return d[end];
	}

}
