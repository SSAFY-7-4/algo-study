import java.io.*;
import java.util.*;
/*
 * 백준 2667 단지번호붙이기
 */
public class BOJ_2667 {

	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static void func(int x, int y) {
		visited[x][y] = true;
		count++;
		
		for(int i = 0 ; i < 4 ; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(!visited[mx][my] && map[mx][my] == 1)
				func(mx,my);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int[N+2][N+2];
		visited = new boolean[N+2][N+2];
		for(int i = 1 ; i <= N; i++) {
			String str = in.readLine();
			for(int j = 1 ; j <= N; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		int danzi = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i =1 ; i <= N; i++) {
			for(int j = 1 ; j <= N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					danzi++;
					count = 0;
					func(i, j);
					list.add(count);
				}
			}
		}
		
		System.out.println(danzi);
		Collections.sort(list);
		for(int i = 0 ; i < danzi; i++) {
			System.out.println(list.get(i));
		}
		
	}
}
