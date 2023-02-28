package java_0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_S3_20291_파일정리 {

	static int N;
	static HashMap<String, Integer> extMap = new HashMap<>();
	static ArrayList<String> extList = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String filename = in.readLine();
			String ext = filename.substring(filename.indexOf('.') + 1);

			if (extMap.containsKey(ext)) {
				extMap.put(ext, extMap.get(ext) + 1);
			} else {
				extList.add(ext);
				extMap.put(ext, 1);
			}
		}

		Collections.sort(extList);
		for (int i = 0; i < extList.size(); i++) {
			String ext = extList.get(i);
			sb.append(ext).append(" ").append(extMap.get(ext)).append("\n");
		}

		System.out.print(sb);
	}

}
