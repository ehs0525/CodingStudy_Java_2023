package java_0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_P5_1219_오민식의고민 {

	static final int NEG_INF = -(int) 1e9;
	static final int POS_INF = (int) 1e9;

	static int N, src, dest, M;
	static ArrayList<Transport> edges = new ArrayList<>();
	static long[] d;
	static int[] earn;

	static class Transport {
		int start, end, price;

		public Transport(int start, int end, int price) {
			super();
			this.start = start;
			this.end = end;
			this.price = price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		src = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		d = new long[N];
		earn = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			edges.add(new Transport(start, end, price));
		}

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			earn[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(d, NEG_INF);

		bf(src);

		if (d[dest] == NEG_INF) {
			System.out.println("gg");
		} else if (d[dest] == POS_INF) {
			System.out.println("Gee");
		} else {
			System.out.println(d[dest]);
		}
	}

	private static void bf(int src) {
		d[src] = earn[src];

		for (int i = 0; i < 2 * N; i++) {
			for (int j = 0; j < M; j++) {
				int curr = edges.get(j).start;
				int next = edges.get(j).end;
				int cost = edges.get(j).price;

				if (d[curr] == NEG_INF)
					continue;
				if (d[curr] == POS_INF)
					d[next] = POS_INF;
				// 현재 간선을 거쳐서 다른 도시로 이동할 때 돈을 더 벌 수 있을 경우
				else if (d[next] < d[curr] - cost + earn[next]) {
					d[next] = d[curr] - cost + earn[next];

					if (i == N - 1) {
						d[next] = POS_INF;
					}
				}
			}
		}

	}

}
