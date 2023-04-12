package java_0411;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1743_음식물피하기 {

	static int N, M, K;
	static int[][] passage;
	static Point[] foodWastes;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		passage = new int[N + 1][M + 1];
		foodWastes = new Point[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			passage[r][c] = 1;
			foodWastes[i] = new Point(r, c);
		}

		int max = 0;
		for (int i = 0; i < K; i++) {
			if (passage[foodWastes[i].x][foodWastes[i].y] == 1) {
				max = Integer.max(max, bfs(foodWastes[i]));
			}
		}

		System.out.print(max);
	}

	private static int bfs(Point start) {
		Queue<Point> q = new LinkedList<Point>();
		int cnt = 0;

		q.offer(start);
		passage[start.x][start.y] = 0;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;
				if (passage[nx][ny] == 0)
					continue;

				q.offer(new Point(nx, ny));
				passage[nx][ny] = 0;
			}
		}

		return cnt;
	}

}
