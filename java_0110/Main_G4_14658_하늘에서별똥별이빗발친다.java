package java_0110;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G4_14658_ÇÏ´Ã¿¡¼­º°¶Ëº°ÀÌºø¹ßÄ£´Ù {

	static int N, M, L, K;
	static ArrayList<Point> shootingStars = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			shootingStars.add(new Point(x, y));
		}

		int max = 0;
		for (Point ss1 : shootingStars) {
			for (Point ss2 : shootingStars) {
				max = Integer.max(max, bounce(ss1, ss2));
			}
		}

		System.out.println(K - max);
	}

	private static int bounce(Point p1, Point p2) {
		int cnt = 0;
		for (Point ss : shootingStars) {
			if (p1.x <= ss.x && ss.x <= p1.x + L && p2.y - L <= ss.y && ss.y <= p2.y)
				cnt++;
		}

		return cnt;
	}

}
