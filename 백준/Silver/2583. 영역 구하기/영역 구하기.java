import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int M, N, K;
	static int[][] map;
	static boolean[][] isVisited;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int cnt = 0;
	static int[] area;
	
	
	static void bfs(int starty, int startx) {
		
		Queue<Point> q = new ArrayDeque<>();

		isVisited[starty][startx] = true;
		q.offer(new Point(startx, starty));
		
		while(!q.isEmpty()) {
			
			Point cur = q.poll();
			area[cnt]++;
			
			for (int i = 0; i < 4; i++) {
				
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if (isIn(ny, nx)) {
					
					if (isVisited[ny][nx]) continue;
					if (map[ny][nx] == 1) continue;
					
					isVisited[ny][nx] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
		
		cnt++;
	}
	
	
	static boolean isIn(int ny, int nx) {
		
		if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
			return true;
		}
		else return false;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		isVisited = new boolean[M][N];
		
		area = new int[M*N];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int startx = Integer.parseInt(st.nextToken());
			int starty = Integer.parseInt(st.nextToken());
			
			int endx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			
			for (int i = starty; i < endy; i++) {
				for (int j = startx; j < endx; j++) {
					//System.out.println(i + " " + j);
					map[i][j] = 1;
				}
			}
		}
		// 입력 받기 끝
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				
				if (map[i][j] == 1) continue;
				if (isVisited[i][j]) continue;
				
				bfs(i, j);
				
			}
		}
		int[] tmp = Arrays.copyOf(area, cnt);
		Arrays.sort(tmp);
		
		sb.append(cnt).append('\n');
		for (int i = 0; i < cnt; i++) {
			sb.append(tmp[i]).append(' ');
		}
		System.out.print(sb);
		
		
		
	}	//main end
} // class end