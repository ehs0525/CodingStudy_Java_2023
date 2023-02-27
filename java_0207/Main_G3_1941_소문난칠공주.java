package java_0207;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G3_1941_소문난칠공주 {

	static int ans = 0;
	static char[][] grid = new char[5][5];
	static boolean[][] isSelected = new boolean[5][5];
	static Point[] seq = new Point[7];

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			grid[i] = in.readLine().toCharArray();
		}

		comb(0, 0, 0);
		System.out.println(ans);
	}

	private static void comb(int start, int cnt, int s) {
		if (cnt == 7) {
			if (s >= 4 && isAdjacent())
				ans++;
			return;
		}

		for (int i = start; i < 25; i++) {
			int x = i / 5;
			int y = i % 5;

			seq[cnt] = new Point(x, y);
			isSelected[x][y] = true;
			if (grid[x][y] == 'S')
				comb(i + 1, cnt + 1, s + 1);
			else
				comb(i + 1, cnt + 1, s);
			isSelected[x][y] = false;
		}
	}

	private static boolean isAdjacent() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		int cnt = 0;

		q.offer(seq[0]);
		visited[seq[0].x][seq[0].y] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			if (++cnt == 7)
				return true;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
					continue;
				if (visited[nx][ny])
					continue;

				if (isSelected[nx][ny]) {
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}

		return false;
	}

}
