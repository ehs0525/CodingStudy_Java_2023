package java_0627;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2583_영역구하기 {

	static int M, N, K;
	static boolean[][] visited;
	static ArrayList<Integer> areas = new ArrayList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		while (K-- > 0) {
			st = new StringTokenizer(in.readLine(), " ");
			int llx = Integer.parseInt(st.nextToken());
			int lly = Integer.parseInt(st.nextToken());
			int urx = Integer.parseInt(st.nextToken());
			int ury = Integer.parseInt(st.nextToken());

			for (int i = llx; i < urx; i++) {
				for (int j = lly; j < ury; j++) {
					visited[i][j] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					bfs(new Point(i, j));
					cnt++;
				}
			}
		}
	
		Collections.sort(areas);
		
		System.out.println(cnt);
		for(int area : areas) {
			System.out.print(area + " ");
		}
	}

	private static void bfs(Point start) {
		Queue<Point> q = new LinkedList<Point>();
		int area = 0;

		q.offer(start);
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			area++;

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;

				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}

		areas.add(area);
	}

}
