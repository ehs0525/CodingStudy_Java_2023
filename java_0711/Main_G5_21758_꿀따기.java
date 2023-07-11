package java_0711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_21758_�ܵ��� {

	static int N;
	static int[] honey, prefixSum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		honey = new int[N + 1];
		prefixSum = new int[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + honey[i];
		}

		// ������, ������, ������
		System.out.print(Integer.max(getMaxHoneyBBH(), Integer.max(getMaxHoneyBHB(), getMaxHoneyHBB())));
	}

	// ������
	private static int getMaxHoneyHBB() {
		int honeycomb = 1, right = N, max = 0;

		for (int left = honeycomb + 1; left < right; left++) {
			int amount = 0;
			amount += prefixSum[left - 1] - prefixSum[honeycomb - 1]; // ���� ��
			amount += prefixSum[right - 1] - prefixSum[honeycomb - 1] - honey[left]; // ������ ��

			max = Integer.max(max, amount);
		}

		return max;
	}

	// ������
	private static int getMaxHoneyBHB() {
		int left = 1, right = N, honeycomb = 2;
		for (int i = left + 2; i < right; i++) {
			if (honey[i] > honey[honeycomb]) {
				honeycomb = i;
			}
		}

		return prefixSum[right - 1] - prefixSum[left] + honey[honeycomb];
	}

	// ������
	private static int getMaxHoneyBBH() {
		int honeycomb = N, left = 1, max = 0;

		for (int right = left + 1; right < honeycomb; right++) {
			int amount = 0;
			amount += prefixSum[honeycomb] - prefixSum[right]; // ������ ��
			amount += prefixSum[honeycomb] - prefixSum[left] - honey[right]; // ���� ��

			max = Integer.max(max, amount);
		}

		return max;
	}

}
