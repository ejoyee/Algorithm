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
		int k;

		public Point(int r, int c,  int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	// K : 움직일 수 있는 횟수
	// W : 가로 길이, H : 세로 높이
	static int K, W, H;
	static int[][] map;

	//   0   1
	// 2       3
	// 4       5 
	//   6   7
	static int[] hdr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hdc = {-1, 1, -2, 2, -2, 2, -1, 1};

	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static final int INF = Integer.MAX_VALUE;
	static int ans = INF;

	static void bfs() {

		Queue<Point> q = new ArrayDeque<>();
		boolean[][][] isVisited = new boolean[H][W][K+1];

		isVisited[0][0][0] = true;
		q.offer(new Point(0, 0, 0));


		int cnt = 0; 
		while(!q.isEmpty()) {

			int size = q.size();

			while(--size >= 0) {

				Point cur = q.poll();
				int r = cur.r;
				int c = cur.c;
				int k = cur.k;

				// 나중에 여기서 도착했는지 판별
				if (r == H-1 && c == W -1) {
					ans = cnt;
					return;
				}

				// 상하좌우
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (!isIn(nr, nc)) continue;
					if (isVisited[nr][nc][k]) continue;
					if (map[nr][nc] == 1) continue;

					isVisited[nr][nc][k] = true;
					q.offer(new Point(nr, nc, k));
				}

				// 말처럼
				if (k < K) {
					for (int i = 0; i < 8; i++) {
						int nr = r + hdr[i];
						int nc = c + hdc[i];

						if (!isIn(nr, nc)) continue;
						if (isVisited[nr][nc][k+1]) continue;
						if (map[nr][nc] == 1) continue;

						isVisited[nr][nc][k+1] = true;
						q.offer(new Point(nr, nc, k+1));


					}
				}
			}
			cnt++;
		}
	}


	static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < H && nc >= 0 && nc < W) return true;
		else return false;
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기 시작
		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 받기 끝

		if (W == 1 && H == 1) {
			System.out.println(0);
			return;
		}

		// 시작 지점 (0, 0)
		// 끝 지점 (H-1, W-1)
		bfs();
		if (ans == INF) ans = -1;

		System.out.println(ans);

	}
}