package java_0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_12869_¹ÂÅ»¸®½ºÅ© {

	static int N;
	static int[] scv = new int[3];
	static int[] dhp1 = new int[] { -9, -9, -3, -3, -1, -1 };
	static int[] dhp2 = new int[] { -3, -1, -9, -1, -9, -3 };
	static int[] dhp3 = new int[] { -1, -3, -1, -9, -3, -9 };

	static class State {
		int[] hp;
		int cnt;

		public State(int[] hp, int cnt) {
			super();
			this.hp = hp;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		bfs(new State(scv, 0));
	}

	private static void bfs(State state) {
		Queue<State> q = new LinkedList<>();
		boolean[][][] visited = new boolean[state.hp[0] + 1][state.hp[1] + 1][state.hp[2] + 1];

		q.offer(state);
		visited[state.hp[0]][state.hp[1]][state.hp[2]] = true;

		while (!q.isEmpty()) {
			State curr = q.poll();
			if (curr.hp[0] == 0 && curr.hp[1] == 0 && curr.hp[2] == 0) {
				System.out.println(curr.cnt);
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nhp1 = Integer.max(curr.hp[0] + dhp1[i], 0);
				int nhp2 = Integer.max(curr.hp[1] + dhp2[i], 0);
				int nhp3 = Integer.max(curr.hp[2] + dhp3[i], 0);
				int ncnt = curr.cnt + 1;

				if (visited[nhp1][nhp2][nhp3])
					continue;

				q.offer(new State(new int[] { nhp1, nhp2, nhp3 }, ncnt));
				visited[nhp1][nhp2][nhp3] = true;
			}
		}
	}

}
