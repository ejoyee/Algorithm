import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static char[][] map;
	static boolean[][] isVisited;
	
	static Queue<Point> water = new ArrayDeque<>();
	static Queue<Point> go = new ArrayDeque<>();
	
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		isVisited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				map[i][j] = c;
				
				if (c == 'S') {
					isVisited[i][j] = true;
					go.add(new Point(i, j));
				}else if (c == '*') {
					water.add(new Point(i, j));
				}
			}
		}
		// 입력 받기 끝
		
		bfs();
		
		if (result == -1) System.out.println("KAKTUS");
		else System.out.println(result);
		
	}// main end
	
	static void bfs() {
		
		int cnt = 0;
		while(!water.isEmpty() || !go.isEmpty()) {
			
			int waterSize = water.size();
			while(--waterSize >= 0) {
				Point cur = water.poll();
				int r = cur.r;
				int c = cur.c;
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if (!isIn(nr, nc)) continue;
					if (map[nr][nc] == '.') {
						map[nr][nc] = '*';
						water.add(new Point(nr, nc));
					}
				}
			}// water while
			
			int goSize = go.size();
			while(--goSize >= 0) {
				Point cur = go.poll();
				int r = cur.r;
				int c = cur.c;
				
				//System.out.println("r : " + r + " c : " + c);
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if (!isIn(nr, nc)) continue;
					if (isVisited[nr][nc]) continue;
					
					if (map[nr][nc] == 'D') {
						 result = cnt+1;
						 return;
					}
					
					if (map[nr][nc] == '.') {
						isVisited[nr][nc] = true;
						go.add(new Point(nr, nc));
					}
				}
			}// go while
			
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("===================================");
			
			cnt++;
			
		}	// empty while
		
	}
	
	static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >=0 && nc < C) return true;
		else return false;
	}
	
	
	
}// class end
