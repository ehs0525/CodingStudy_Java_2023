package java_0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_9489_ªÁ√Ã {

	static int n, k;
	static int[] arr, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			if (n == 0 & k == 0)
				break;

			arr = new int[n];
			parent = new int[n];
			parent[0] = -1;
			int p = -1, idx = 0;

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] == k)
					idx = i;
				if (i > 0 && arr[i] != arr[i - 1] + 1)
					p++;
				parent[i] = p;
			}

			int cnt = 0;
			for (int i = 1; i < n; i++) {
				if (parent[i] != parent[idx] && parent[parent[i]] == parent[parent[idx]])
					cnt++;
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb);
	}

}
