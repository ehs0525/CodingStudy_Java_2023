package java_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G3_2655_가장높은탑쌓기 {

	static int N;
	static Brick[] bricks;
	static int[] dp;

	static class Brick {
		int idx, area, height, weight;

		public Brick(int idx, int area, int height, int weight) {
			super();
			this.idx = idx;
			this.area = area;
			this.height = height;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		bricks = new Brick[N + 1];
		bricks[0] = new Brick(0, 0, 0, 0);
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int area = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			bricks[i] = new Brick(i, area, height, weight);
		}

		Arrays.sort(bricks, new Comparator<Brick>() {
			@Override
			public int compare(Brick o1, Brick o2) {
				return Integer.compare(o1.area, o2.area);
			}
		});

		dp = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (bricks[j].weight < bricks[i].weight) {
					dp[i] = Integer.max(dp[i], dp[j] + bricks[i].height);
				}
			}
			max = Integer.max(max, dp[i]);
		}

		Stack<Integer> tower = new Stack<>();
		for (int i = N; i > 0; i--) {
			if (dp[i] == max) {
				tower.push(bricks[i].idx);
				max -= bricks[i].height;
			}
		}

		System.out.println(tower.size());
		while (!tower.isEmpty()) {
			System.out.println(tower.pop());
		}
	}

}
