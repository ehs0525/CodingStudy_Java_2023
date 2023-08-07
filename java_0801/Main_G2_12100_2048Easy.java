package java_0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_12100_2048Easy {

	static int N, max = 0;
	static int[][] board;
	static boolean[][] areCombined;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class State {
		int[][] block;
		int cnt;

		public State(int[][] block, int cnt) {
			super();
			this.block = block;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(new State(board, 0));
		System.out.print(max);
	}

	private static void bfs(State start) {
		Queue<State> q = new LinkedList<>();

		q.offer(start);

		while (!q.isEmpty()) {
			State curr = q.poll();
			if (curr.cnt >= 5) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						max = Integer.max(max, curr.block[i][j]);
					}
				}
				continue;
			}

			for (int i = 0; i < 4; i++) {
				areCombined = new boolean[N][N]; 

				int[][] nb = copy(curr.block);
				int nc = curr.cnt + 1;

				if (i == 0 || i == 2) {
					for (int j = 0; j < N; j++) {
						for (int k = 0; k < N; k++) {
							move(nb, areCombined, i, j, k);
						}
					}
				} else {
					for (int j = N - 1; j >= 0; j--) {
						for (int k = N - 1; k >= 0; k--) {
							move(nb, areCombined, i, j, k);
						}
					}
				}

				q.offer(new State(nb, nc));
			}
		}
	}

	private static void move(int[][] b, boolean[][] c, int d, int x, int y) {

		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				return;

			// 이동할 위치의 값이 0이면
			if (b[nx][ny] == 0) {
				b[nx][ny] = b[x][y];
				b[x][y] = 0;

				x = nx;
				y = ny;
			} else if (b[nx][ny] == b[x][y] && !c[nx][ny]) {
				// 이동할 위치의 값과 같다면
				b[nx][ny] += b[x][y];
				b[x][y] = 0;
				c[nx][ny] = true;
				break;
			} else {
				// 이동할 위치의 값과 다르다면
				break;
			}

		}
	}

	private static int[][] copy(int[][] arr) {
		if (arr == null)
			return null;

		int[][] temp = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i].clone();
		}

		return temp;
	}

}
