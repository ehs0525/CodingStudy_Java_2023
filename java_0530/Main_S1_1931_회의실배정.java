package java_0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S1_1931_회의실배정 {

	static int N;
	static Meeting[] meetings;

	static class Meeting {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			meetings[i] = new Meeting(s, e);
		}

		Arrays.sort(meetings, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end == o2.end)
					return Integer.compare(o1.start, o2.start);
				return Integer.compare(o1.end, o2.end);
			}
		});

		int cnt = 0, curr_end = 0;
		for (int i = 0; i < N; i++) {
			if (curr_end <= meetings[i].start) {
				curr_end = meetings[i].end;
				cnt++;
			}
		}

		System.out.print(cnt);
	}

}
