import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, K;
	static int[][] map;
	
	static int high;
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] isVisited;
	
	static int ans;
	
	static void dfs(int r, int c, int cnt, boolean flag) {
		
		isVisited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (!isIn(nr, nc)) continue;	// 범위를 벗어난 경우
			if (isVisited[nr][nc]) continue;	// 이미 방문했던 경우
			
			int cur = map[r][c];
			int next = map[nr][nc];
			
			if (next >= cur && flag) continue;	// 큰데 이미 한 번 산을 깎은 경우
			if (next >= cur && next - cur >= K) continue;	// 다음 칸이 더 큰데, 깎을 수 있는 깊이보다도 더 많이 높을 때
			
			isVisited[nr][nc] = true;
			if(next >= cur && next - cur < K) {
				map[nr][nc] = cur - 1 ;
				
				dfs(nr, nc, cnt + 1, true);
				map[nr][nc] = next;
			}
			else {
				dfs(nr, nc, cnt+1, flag);
			}
			isVisited[nr][nc] = false;
		}
		
		//System.out.println(r + " " + c + " " + cnt);
		ans = Math.max(ans, cnt);
	}
	
	
	static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
		else return false;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			// 초기화
			ans = 0;
			
			// 입력 받기 시작
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			high = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (map[i][j] > high) high = map[i][j];
				}
			}
			// 입력 받기 끝
			
			// 높은 봉우리 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == high) {
						isVisited = new boolean[N][N];
						dfs(i, j, 1, false);
					}
				}
			}
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}	// testcase end
		
		System.out.println(sb);
		
	}	// main end
}	// class end
