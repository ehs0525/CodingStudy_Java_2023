package java_0815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_P4_1637_��ī�ο {

	static int N;
	static int[] A, C, B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long left = Integer.MAX_VALUE, right = 1;

		N = Integer.parseInt(in.readLine());
		A = new int[N];
		C = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());

			left = Long.min(left, A[i]);
			right = Long.max(right, C[i]);
		}

		long result = 0;
		while (left <= right) {
			long mid = (left + right) / 2;

			// Ȧ�� ���� ������ �� �ϳ�(�Ǵ� ����)�̹Ƿ� ¦+¦+..+Ȧ �̸� ã�� ��!
			if (getPrefixSum(mid) % 2 == 0) {
				left = mid + 1;
			} else {
				result = mid;
				right = mid - 1;
			}
		}

		if (result == 0) {
			System.out.print("NOTHING");
		} else {
			System.out.print(result + " " + (getPrefixSum(result) - getPrefixSum(result - 1)));
		}
	}

	// num ������ ���� ������ ��
	private static long getPrefixSum(long num) {
		long sum = 0;

		for (int i = 0; i < N; i++) {
			if (num >= A[i]) {
				sum += (Long.min(C[i], num) - A[i]) / B[i] + 1;
			}
		}

		return sum;
	}

}
