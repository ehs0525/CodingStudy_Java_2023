package java_0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_11509_풍선맞추기 {

	static int N;
	static int[] arrowsInHeight = new int[1000001]; // arrowsInHeight[i] : 높이 i로 날아오는 화살의 개수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;

		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());

			// 높이 h로 날아오는 화살이 없는 경우
			if (arrowsInHeight[h] == 0) {
				arrowsInHeight[h - 1]++;
				cnt++;
			} else {
				arrowsInHeight[h]--;
				arrowsInHeight[h - 1]++;
			}
		}

		System.out.print(cnt);
	}

}
