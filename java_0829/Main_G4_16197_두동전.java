package java_0829;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_16197_µÎµ¿Àü {

	static int N, M, min = Integer.MAX_VALUE;
	static char[][] board;
	static Point[] coins = new Point[2];

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class State {
		Point coin1, coin2;
		int dropped, pressed;

		public State(Point coin1, Point coin2, int dropped, int pressed) {
			super();
			this.coin1 = coin1;
			this.coin2 = coin2;
			this.dropped = dropped;
			this.pressed = pressed;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0, k = 0; i < N; i++) {
			board[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'o') {
					coins[k++] = new Point(i, j);
				}
			}
		}

		bfs(new State(coins[0], coins[1], 0, 0));
		System.out.print(min > 10 ? -1 : min);
	}

	private static void bfs(State start) {
		Queue<State> q = new LinkedList<State>();
		boolean[][][][] visited = new boolean[N][M][N][M];

		q.offer(start);
		visited[start.coin1.x][start.coin1.y][start.coin2.x][start.coin2.y] = true;

		while (!q.isEmpty()) {
			State curr = q.poll();
			if (curr.dropped == 1) {
				min = Integer.min(min, curr.pressed);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nc1x = curr.coin1.x + dx[i];
				int nc1y = curr.coin1.y + dy[i];
				int nc2x = curr.coin2.x + dx[i];
				int nc2y = curr.coin2.y + dy[i];

				Point nc1 = nc1x >= 0 && nc1x < N && nc1y >= 0 && nc1y < M && board[nc1x][nc1y] == '#' ? curr.coin1
						: new Point(nc1x, nc1y);
				Point nc2 = nc2x >= 0 && nc2x < N && nc2y >= 0 && nc2y < M && board[nc2x][nc2y] == '#' ? curr.coin2
						: new Point(nc2x, nc2y);
				int nd = countCoinsDropped(nc1, nc2);
				int np = curr.pressed + 1;

				if (nd == 0 && visited[nc1.x][nc1.y][nc2.x][nc2.y])
					continue;
				if (nd == 2)
					continue;

				q.offer(new State(nc1, nc2, nd, np));
				if (nd == 0) {
					visited[nc1.x][nc1.y][nc2.x][nc2.y] = true;
				}
			}
		}
	}

	private static int countCoinsDropped(Point coin1, Point coin2) {
		int cnt = 0;
		if (coin1.x < 0 || coin1.x >= N || coin1.y < 0 || coin1.y >= M)
			cnt++;
		if (coin2.x < 0 || coin2.x >= N || coin2.y < 0 || coin2.y >= M)
			cnt++;

		return cnt;
	}

}
