import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	static int cnt;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !isVisited[i][j]) {
					bfs(new Point(i, j));
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static void bfs (Point start) {
		
		Queue<Point> q = new ArrayDeque<>();
		
		isVisited[start.r][start.c] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr == -1) nr = N-1;
				if (nr == N) nr = 0;
				if (nc == -1) nc = M-1;
				if (nc == M) nc = 0;
				
				if (isVisited[nr][nc]) continue;
				if (map[nr][nc] == 1) continue;
				
				isVisited[nr][nc] = true;
				q.offer(new Point(nr, nc));
				
			}
		}
	}

}