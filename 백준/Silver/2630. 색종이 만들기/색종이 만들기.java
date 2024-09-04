import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	
	static int blue = 0;
	static int white = 0;
	
	static void cut (int r, int c, int size) {
		
		// 색 체크 
		int cnt = 0;
		for (int i = r; i < (r+size); i++) {
			for(int j = c; j < (c+size); j++) {
				cnt += map[i][j];
			}
		}
		if (cnt == size*size) blue++;
		else if (cnt == 0) white++;
		else {
			
			int half = size / 2;
			
			cut (r, c, half);
			cut (r, c+half, half);
			cut (r+half, c, half);
			cut (r+half, c+half, half);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 받기 끝
		
		cut(0, 0, N);
		sb.append(white).append('\n').append(blue);
		System.out.println(sb);
		
		
	}	// main end
}	// class end