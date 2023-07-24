package java_0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_19942_다이어트 {

	static int N, mp, mf, ms, mv, min = Integer.MAX_VALUE;
	static Ingredient[] ingredients;
	static boolean[] isSelected;
	static ArrayList<Integer> result = new ArrayList<>();

	static class Ingredient {
		int p, f, s, v, c;

		public Ingredient(int p, int f, int s, int v, int c) {
			super();
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine(), " ");
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		ingredients = new Ingredient[N + 1];
		isSelected = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ingredients[i] = new Ingredient(p, f, s, v, c);
		}

		generateSubset(1);

		if (min == Integer.MAX_VALUE) {
			System.out.print(-1);
		} else {
			System.out.println(min);
			for (int e : result) {
				System.out.print(e + " ");
			}
		}
	}

	private static void generateSubset(int cnt) {
		if (cnt > N) {
			int sp = 0, sf = 0, ss = 0, sv = 0, sc = 0;
			ArrayList<Integer> seq = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) {
					sp += ingredients[i].p;
					sf += ingredients[i].f;
					ss += ingredients[i].s;
					sv += ingredients[i].v;
					sc += ingredients[i].c;

					seq.add(i);
				}
			}

			if (sp >= mp && sf >= mf && ss >= ms && sv >= mv && sc <= min) {
				if (sc < min || sc == min && compareArrayList(result, seq) > 0) {
					result = (ArrayList<Integer>) seq.clone();
					min = sc;
				}
			}
			return;
		}

		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}

	private static int compareArrayList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		if (list1.size() == 0)
			return 1;
		if (list2.size() == 0)
			return -1;

		String str1 = "";
		String str2 = "";
		for (int e1 : list1)
			str1 += String.valueOf(e1);
		for (int e2 : list2)
			str2 += String.valueOf(e2);

		return str1.compareTo(str2);
	}

}
