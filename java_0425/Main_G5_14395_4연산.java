package java_0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14395_4¿¬»ê {

	static long s, t;
	static HashSet<Long> visited = new HashSet<>();

	static class Node {
		long val;
		String ops;

		public Node(long val, String ops) {
			super();
			this.val = val;
			this.ops = ops;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		s = Long.parseLong(st.nextToken());
		t = Long.parseLong(st.nextToken());

		bfs(new Node(s, ""));
	}

	private static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();

		q.offer(start);
		visited.add(start.val);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			long v = curr.val;
			String o = curr.ops;

			if (v == t) {
				System.out.print(o.length() == 0 ? 0 : o);
				return;
			}

			long nv;

			nv = v * v;
			if (nv <= (int) 1e9 && !visited.contains(nv)) {
				q.offer(new Node(nv, o + "*"));
				visited.add(nv);
			}
			nv = v + v;
			if (!visited.contains(nv)) {
				q.offer(new Node(nv, o + "+"));
				visited.add(nv);
			}
			nv = v - v;
			if (!visited.contains(nv)) {
				q.offer(new Node(nv, o + "-"));
				visited.add(nv);
			}
			if (v != 0 && !visited.contains(v / v)) {
				q.offer(new Node(v / v, o + "/"));
				visited.add(v / v);
			}
		}
		
		System.out.print(-1);
	}

}
