package algo10819;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	// 그냥 모든 순열 만들어서 최대 값일 경우를 찾아보자!

	static int N;
	static int number[];
	static boolean visited[];
	static int max = 0;

	private static void makePermutation(int toSelect, int[] selected, boolean[] visited) {

		if (toSelect == N) {
			int sum = 0;
			for (int i = 0; i < selected.length - 1; i++) {
				sum += Math.abs(selected[i] - selected[i + 1]);
			}
			// max값이랑 비교
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toSelect] = number[i];
				makePermutation(toSelect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.setIn(new FileInputStream("src" + File.separator + "algo10819" + File.separator + "input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine().trim());
		number = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		// 배열 채우기
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		// 순열 생성
		makePermutation(0, new int[N], visited);

		System.out.println(max);

	}

}
