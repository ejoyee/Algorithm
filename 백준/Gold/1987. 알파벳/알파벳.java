import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int R, C;
	
	static char[][] map;
	
	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static int maxCnt = 0;
	
	static boolean[] alp = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작 
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 입력 받기 끝
		
		// 최대로 많이 이동할 수 있는 칸수 출력
		
		int tmp = map[0][0] - 'A';
		alp[tmp] = true;
		dfs(0, 0, 1);
		
		sb.append(maxCnt);
		System.out.println(sb);
		
	}	// main end
	
	
	
	static void dfs(int x, int y, int cnt) {
		
		if (maxCnt < cnt) {
			maxCnt = cnt;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (isIn(nx, ny)){
				
				int tmp = map[ny][nx] - 'A';
				if(!alp[tmp]) {
					alp[tmp] = true;
					dfs(nx, ny, cnt+1);
					alp[tmp] = false;
				}
			}
		}
	}
	
	static boolean isIn(int nx, int ny) {
		
		if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
			return true;
		}
		
		return false;
	}
}	// class end