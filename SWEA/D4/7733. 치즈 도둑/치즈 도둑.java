import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();

	static int N, result, cnt;
	static int[][] cheese;

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<Point> q = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			result = 1;
			

			// 입력 받기 시작
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];

			int maxDay = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());

					if (cheese[i][j] > maxDay) {
						maxDay = cheese[i][j];
					}
				}
			}
			// 입력 받기 끝
			

			for (int d = 1; d <= maxDay; d++) {
				cnt = 0;
				boolean[][] isVisited =  new boolean[N][N];
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] > d && !isVisited[i][j]) {
							bfs(i, j, d, isVisited);
						}
					}
				}
				
				result = Math.max(cnt, result);
			}
			
			
			sb.append('#').append(t).append(' ').append(result).append('\n');

		} // testcase end
		
		System.out.println(sb);
	} // main end

	
	
	static boolean isIn(int nx, int ny) {

		if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
			return true;
		}
		return false;
	}

	
	static void bfs(int starty, int startx, int day, boolean[][] isVisited) {

		isVisited[starty][startx] = true;
		q.offer(new Point(startx, starty));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {

				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (isIn(nx, ny)) {
					if (cheese[ny][nx] <= day || isVisited[ny][nx])
						continue;

					isVisited[ny][nx] = true;
					q.offer(new Point(nx, ny));

				}
			}
		}
		
		cnt++;

	} // bfs end

}