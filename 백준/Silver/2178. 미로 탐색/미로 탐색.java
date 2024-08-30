import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static boolean[][] map;
	
	static int result = 0;
	
	
	// 상하좌우
	static int x, y;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
private static void bfs(int startx, int starty) {
		
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N+1][M+1];
		
		isVisited[starty][startx] = true;
		q.offer(new Point(startx, starty));
		
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			
			int size = q.size();	// 큐 사이즈 체크
			
			while(--size>=0) {
				Point cur = q.poll();
				if (cur.x == M && cur.y == N) {
					System.out.println(cnt);
					return;
				}

				//자신의 인접정점들 다음 탐색 위한 준비
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					
					if (!isIn(nx, ny))continue;	//경계 벗어남
					if (!map[ny][nx]) continue;	//0인 경우
					if(isVisited[ny][nx]) continue;	//재방문
						
					isVisited[ny][nx] = true;
					q.offer(new Point(nx, ny));
				}
			}	//동일너비처리
			cnt++;
		}
	}
	
	
	
	static boolean isIn(int nx, int ny) {
		
		if (ny > 0 && ny <= N && nx > 0 && nx <= M) {
			return true;
		}
		
		return false;
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		x = 1;
		y = 1;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				
				char tmp = str.charAt(j-1);
				if (tmp == '1') map[i][j] = true;
				else map[i][j] = false;
				
			}
		}
		// 입력 받기 끝
		
		// (1, 1) ~ (N, M)
		bfs(1, 1);
		
		
		
	}	// main end
}	// class end