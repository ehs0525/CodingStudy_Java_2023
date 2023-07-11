package java_0711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_G2_4195_模备匙飘况农 {

	static int T, F;
	static int[] parent, network;
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			F = Integer.parseInt(in.readLine());

			parent = new int[2 * F];
			network = new int[2 * F];
			map = new HashMap<>();

			for (int i = 0; i < 2 * F; i++) {
				parent[i] = i;
				network[i] = 1;
			}

			int idx = 0;
			while (F-- > 0) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				String f1 = st.nextToken();
				String f2 = st.nextToken();

				if (!map.containsKey(f1)) {
					map.put(f1, idx++);
				}
				if (!map.containsKey(f2)) {
					map.put(f2, idx++);
				}

				int idx1 = map.get(f1);
				int idx2 = map.get(f2);
				if (findParent(idx1) != findParent(idx2)) {
					unionParent(idx1, idx2);
				}
				sb.append(network[findParent(idx1)]).append("\n");
			}
		}

		System.out.print(sb);
	}

	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);

		if (a < b) {
			parent[b] = a;
			network[a] += network[b];
		} else {
			parent[a] = b;
			network[b] += network[a];
		}
	}

	private static int findParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findParent(parent[x]);
	}

}
