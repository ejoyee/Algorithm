import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static Queue<Node> q = new ArrayDeque<>();
	
	static int maxCnt = 0;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node{
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	
	// 조합
	static void dfs(int cnt, int start) {
		
		if (cnt == 3) {
			// bfs 호출
			bfs();
			return;
		}
		
		for (int i = start; i < N*M; i++) {
			int r = i / M;
			int c = i % M;
			
			if (map[r][c] == 0) {
				
				map[r][c] = 1;
				dfs(cnt+1, i+1);
				map[r][c] = 0;
			}
			
		}
	}
	
	
	static void bfs() {
		
		boolean[][] isVisited = new boolean[N][M];
		
		int[][] tmpArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tmpArr[i] = map[i].clone();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmpArr[i][j] == 2) {
					q.offer(new Node(i, j));
					isVisited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (isIn(nr, nc)) {
					if (isVisited[nr][nc]) continue;
					
					if (tmpArr[nr][nc] == 0) {
						isVisited[nr][nc] = true;
						q.offer(new Node(nr, nc));
						tmpArr[nr][nc] = 2;
					}
				}
			}
		}
		
		int cnt = safeCnt(tmpArr);
		maxCnt = Math.max(cnt, maxCnt);
		
	}	// bfs end
	
	
	static int safeCnt(int[][] tmpArr) {
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmpArr[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	
	static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		}
		else return false;
	}
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) {
					q.offer(new Node(i, j));
				}
			}
		}
		// 입력 받기 끝
		
		// 0 : 빈 칸
		// 1 : 벽
		// 2 : 바이러스
		
		// 벽은 총 세 개 무조건 세워야 함 
		// 안전영역의 최대 크기
		
		
		// 조합으로 돌아야 한다 이거지
		// bfs를
		dfs(0, 0);
		
		System.out.println(maxCnt);
	}
}