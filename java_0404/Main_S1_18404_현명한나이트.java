package java_0404;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_18404_현명한나이트 {

	static int N, M;
	static int[][] board;

	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static class Knight {
		Point p;
		int moved;

		public Knight(Point p, int moved) {
			super();
			this.p = p;
			this.moved = moved;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		bfs(new Point(X, Y));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			sb.append(board[A][B] - 1).append(" ");
		}

		System.out.print(sb);
	}

	private static void bfs(Point start) {
		Queue<Knight> q = new LinkedList<>();

		q.offer(new Knight(start, 1));
		board[start.x][start.y] = 1;

		while (!q.isEmpty()) {
			Knight curr = q.poll();

			for (int i = 0; i < 8; i++) {
				int nx = curr.p.x + dx[i];
				int ny = curr.p.y + dy[i];
				int nm = curr.moved + 1;

				if (nx < 1 || nx > N || ny < 1 || ny > N)
					continue;
				if (board[nx][ny] > 0)
					continue;

				q.offer(new Knight(new Point(nx, ny), nm));
				board[nx][ny] = nm;
			}
		}
	}

}
