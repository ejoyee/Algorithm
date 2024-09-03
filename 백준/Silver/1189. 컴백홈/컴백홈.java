import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, K;
	static int ans = 0;
	
	static char[][] map;
	static boolean[][] isVisited;
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static void dfs(int r, int c, int cnt) {
		
		// 도착
		if (r == 0 && c == C-1) {
			if (cnt == K) ans++;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (isIn(nr, nc)) {
				if (isVisited[nr][nc] || map[nr][nc] == 'T') continue;
				
				isVisited[nr][nc] = true;
				dfs(nr, nc, cnt+1);
				isVisited[nr][nc] = false;
				
			}
		}
		
		
		
	}
	
	static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		else return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작 
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		isVisited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 입력 받기 끝
		
		// 도착점 [0][C-1]
		isVisited[R-1][0] = true;
		dfs(R-1, 0, 1);
		
		System.out.println(ans);
		
		
		
	}

}