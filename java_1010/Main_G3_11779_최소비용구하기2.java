package java_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G3_11779_최소비용구하기2 {

	static final int INF = (int) 1e9;

	static int n, m;
	static ArrayList<Bus>[] graph;
	static int[] d;
	static ArrayList<Integer>[] path;

	static class Bus implements Comparable<Bus> {
		int dest, cost;

		public Bus(int dest, int cost) {
			super();
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());

		graph = new ArrayList[n + 1];
		path = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			path[i] = new ArrayList<>();
		}
		d = new int[n + 1];
		Arrays.fill(d, INF);

		while (m-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Bus(b, c));
		}

		st = new StringTokenizer(in.readLine(), " ");
		int dep = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());

		dijkstra(dep);

		System.out.println(d[dest]);
		System.out.println(path[dest].size());
		for (int i = 0; i < path[dest].size(); i++) {
			System.out.print(path[dest].get(i) + " ");
		}
	}

	private static void dijkstra(int dep) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();

		pq.offer(new Bus(dep, 0));
		d[dep] = 0;
		path[dep].add(dep);

		while (!pq.isEmpty()) {
			Bus curr = pq.poll();
			int cd = curr.dest;
			int cc = curr.cost;

			if (d[cd] < cc)
				continue;

			for (int i = 0; i < graph[cd].size(); i++) {
				int nd = graph[cd].get(i).dest;
				int nc = graph[cd].get(i).cost;
				int cost = d[cd] + nc;

				if (cost < d[nd]) {
					pq.offer(new Bus(nd, cost));
					d[nd] = cost;

					path[nd] = (ArrayList<Integer>) path[cd].clone();
					path[nd].add(nd);
				}
			}
		}
	}

}
