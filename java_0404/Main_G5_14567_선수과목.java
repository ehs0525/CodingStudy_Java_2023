package java_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14567_선수과목 {

	static int N, M;
	static int[] indegree, result;
	static ArrayList<Integer>[] prerequisite;

	static class Course {
		int num, semester;

		public Course(int num, int semester) {
			super();
			this.num = num;
			this.semester = semester;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		result = new int[N + 1];
		prerequisite = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			prerequisite[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			prerequisite[A].add(B);
			indegree[B]++;
		}

		topologySort();

		for (int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
	}

	private static void topologySort() {
		Queue<Course> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(new Course(i, 1));
			}
		}

		while (!q.isEmpty()) {
			Course curr = q.poll();
			result[curr.num] = curr.semester;

			for (int i = 0; i < prerequisite[curr.num].size(); i++) {
				int next = prerequisite[curr.num].get(i);

				if (--indegree[next] == 0)
					q.offer(new Course(next, curr.semester + 1));
			}
		}
	}

}
