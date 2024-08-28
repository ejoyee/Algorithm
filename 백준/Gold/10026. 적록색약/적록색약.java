import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int N, cnt;
	static int[][] map;
	// R : 0, G : 1, B : 2

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<Point> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		cnt = 0;

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char tmp = str.charAt(j);

				if (tmp == 'R') {
					map[i][j] = 0;
				} else if (tmp == 'G') {
					map[i][j] = 1;
				} else if (tmp == 'B') {
					map[i][j] = 2;
				}
			}
		}
		// 입력 받기 끝

		cnt = 0;
		for (int c = 0; c < 3; c++) {
			boolean[][] isVisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (map[i][j] == c && !isVisited[i][j]) {
						bfs(j, i, c, isVisited);
					}

				}
			}
		}

		sb.append(cnt).append(' ');

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
				}
			}
		}

		cnt = 0;
		for (int c = 1; c < 3; c++) {
			boolean[][] isVisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {


					if (map[i][j] == c && !isVisited[i][j]) {
						bfs(j, i, c, isVisited);
					}
				}
			}
		}
		sb.append(cnt);

		System.out.println(sb);

	} // main end

	static boolean isIn(int nx, int ny) {

		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

	static void bfs(int startx, int starty, int color, boolean[][] isVisited) {

		isVisited[starty][startx] = true;
		q.offer(new Point(startx, starty));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {

				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (isIn(nx, ny)) {

					if (map[ny][nx] != color || isVisited[ny][nx])
						continue;

					isVisited[ny][nx] = true;
					q.offer(new Point(nx, ny));

				}
			}

		}

		cnt++;
	}

} // class end