package java_0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2468_안전영역 {

	static int N;
	static int[][] arr;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		int highest = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				highest = Integer.max(highest, arr[i][j]);
			}
		}

		int safeArea = 1;
		for (int i = 1; i < highest; i++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (dfs(j, k, i)) {
						cnt++;
					}
				}
			}
			
			safeArea = Integer.max(safeArea, cnt);
		}
		
		System.out.println(safeArea);
	}

	private static boolean dfs(int x, int y, int height) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;
		if (visited[x][y] || arr[x][y] <= height)
			return false;

		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			dfs(nx, ny, height);
		}
		return true;
	}

}
