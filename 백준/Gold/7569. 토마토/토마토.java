import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H;		// c r h
	static int[][][] box;	// 토마토 박스

	// 상하좌우 z 위 아래
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};

	static int result = 0;			// 결과 
	static int babytomato = 0;		// 덜 익은 토마토의 수
	
	static Queue<Point> q = new ArrayDeque<>();
	static boolean[][][] isVisited;
	
	// 토마토 좌표
	static class Point{
		int h;
		int r;
		int c;
		
		public Point(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

	// main문
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	// C
		N = Integer.parseInt(st.nextToken());	// R
		H = Integer.parseInt(st.nextToken());	// 층

		box = new int[H][N][M];
		isVisited = new boolean[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					// 안 익은 토마토 개수 체크
					if (box[h][r][c] == 0) babytomato++;
					// 익은 토마토 위치 Point를  Queue에 offer
					else if (box[h][r][c] == 1) {
						q.offer(new Point(h, r, c));
						isVisited[h][r][c] = true;
					}
				}
			}
		}
		// 입력 받기 끝 

		// 애초에 덜 익은 토마토가 없는 경우
		if (babytomato == 0) {
			System.out.println(0);
			return;
		}


		// bfs 부분
		bfs();

		// if 덜 익은 토마토가 남았을 경우 -1 출력
		// else 모든 토마토가 잘 익었을 때 기간 출력
		if (babytomato > 0) {
			System.out.println(-1);
			return;
		}
		else {
			System.out.println(result);
			return;
		}



	}	// main end

	

	// 6방 탐색 시, 범위 내에 있는지 체크해 t/f 반환하는 메소드
	static boolean isIn (int nh, int nr, int nc) {
		if (nh >= 0 && nh < H &&
				nr >= 0 && nr < N &&
				nc >= 0 && nc < M) {
			return true;
		}
		else return false;
	}	// inIn end



	// 6방 탐색을 돌며 레벨별 bfs
	static void bfs() {
		
		int cnt = 0;
		while(!q.isEmpty()) {

			int size = q.size();
			while (--size >= 0) {
				Point cur = q.poll();
				int h = cur.h;
				int r = cur.r;
				int c = cur.c;
				
				for (int i = 0; i < 6; i++) {
					int nh = h + dh[i];
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if (!isIn(nh, nr, nc)) continue;
					if (isVisited[nh][nr][nc]) continue;
					if (box[nh][nr][nc] != 0) continue;
					
					box[nh][nr][nc] = 1;
					isVisited[nh][nr][nc] = true;
					q.offer(new Point(nh, nr, nc));
					babytomato--;
					
				}
				
			}
			// 한 번 전체적으로 다 주변을 익혔으면 cnt++
			cnt++;

			if (babytomato == 0) {
				result = cnt;
				return;
			}
			
		}	// !q.isEmpty() end
	}	// bfs end
	


}	// class end