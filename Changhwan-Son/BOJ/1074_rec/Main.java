import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int func(int N, int r, int c) {
		if(N == 0)
			return 0;
		
		int half = (int) Math.pow(2, N - 1);
		
		if(r < half && c < half) {
			return func(N-1, r, c);
		}
		
		if(r < half && c >= half) {
			return (int)Math.pow(half,2) + func(N-1, r, c - half);
		}
		
		if(r >= half && c < half) {
			return (int)Math.pow(half,2) * 2 + func(N-1, r - half, c);
		}
		
		
		return (int)Math.pow(half,2) * 3 + func(N-1, r - half, c - half);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		System.out.println(func(N, r, c));
	}
}
