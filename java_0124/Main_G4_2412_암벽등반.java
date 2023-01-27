package java_0124;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2412_암벽등반 {

	static int n, T, maxX = 0, maxY = 0;
	static ArrayList<Integer>[] graph;

	static class Groove {
		Point p;
		int moved;

		public Groove(Point p, int moved) {
			super();
			this.p = p;
			this.moved = moved;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		graph = new ArrayList[200001];
		for (int i = 0; i <= 200000; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			maxX = Integer.max(maxX, x);
			maxY = Integer.max(maxY, y);

			graph[y].add(x);
		}

		System.out.println(bfs(new Groove(new Point(0, 0), 0)));
	}

	private static int bfs(Groove start) {
		Queue<Groove> q = new LinkedList<>();
		boolean[][] visited = new boolean[maxX + 1][maxY + 1];

		q.offer(start);
		visited[start.p.x][start.p.y] = true;

		while (!q.isEmpty()) {
			Groove curr = q.poll();
			int x = curr.p.x;
			int y = curr.p.y;
			int m = curr.moved;

			if (y == T)
				return m;

			for (int i = y - 2; i <= y + 2; i++) {
				if (i < 0 || i >= graph.length)
					continue;
				for (int j = 0; j < graph[i].size(); j++) {
					int a = graph[i].get(j);
					int b = i;

					if (visited[a][b])
						continue;
					if (Math.abs(a - x) <= 2) {
						q.offer(new Groove(new Point(a, b), m + 1));
						visited[a][b] = true;
					}
				}
			}
		}

		return -1;
	}

}
