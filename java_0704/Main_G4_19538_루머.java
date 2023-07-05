package java_0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_19538_루머 {

	static int N, M;
	static ArrayList<Integer>[] around;
	static int[] distributor, t;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		around = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			around[i] = new ArrayList<>();
			st = new StringTokenizer(in.readLine(), " ");
			while (true) {
				int p = Integer.parseInt(st.nextToken());
				if (p == 0)
					break;

				around[i].add(p);
			}
		}

		M = Integer.parseInt(in.readLine());
		distributor = new int[M];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			distributor[i] = Integer.parseInt(st.nextToken());
		}

		bfs();

		for (int i = 1; i <= N; i++) {
			System.out.print(t[i] + " ");
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] believe = new int[N + 1]; // 루머를 믿는 주변인의 수
		t = new int[N + 1];

		Arrays.fill(t, -1);
		for (int d : distributor) {
			q.offer(d);
			t[d] = 0;
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < around[curr].size(); i++) {
				int next = around[curr].get(i);

				if (++believe[next] < (around[next].size() + 1) / 2)
					continue;
				if (t[next] != -1)
					continue;

				q.offer(next);
				t[next] = t[curr] + 1;
			}
		}
	}

}
