import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();

	static int N, M; // 맵 사이즈
	static int R, C; // 맨홀 좌표
	static int L; // 탈출 소요 시간

	static int ans;

	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[][] tnlDir = { {}, { 0, 1, 2, 3 }, // 1일 때는 상하좌우
			{ 0, 1 }, // 2일 때
			{ 2, 3 }, // 3
			{ 0, 3 }, // 4
			{ 1, 3 }, // 5
			{ 1, 2 }, // 6
			{ 0, 2 } // 7
	};

	static int[][] connect = { {0, 0, 0, 0},
			{ 1, 1, 1, 1 }, // 1일 때는 상하좌우
			{ 1, 1, 0, 0 }, // 2일 때
			{ 0, 0, 1, 1 }, // 3
			{ 0, 1, 1, 0 }, // 4
			{ 1, 0, 1, 0 }, // 5
			{ 1, 0, 0, 1 }, // 6
			{ 0, 1, 0, 1 } // 7
	};

	static void bfs(int sr, int sc) {

		Queue<Node> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];

		isVisited[sr][sc] = true;
		q.offer(new Node(sr, sc));

		int time = 0;

		while (!q.isEmpty()) {

			int size = q.size();
			
			if (time == L)
				return;

			while (--size >= 0) {

				Node cur = q.poll();
				int type = map[cur.r][cur.c];
				ans++;
				

				for (int i = 0; i < (type == 1 ? 4 : 2); i++) {

					int dir = tnlDir[type][i];

					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];

					if (isIn(nr, nc)) {

						if (isVisited[nr][nc]) continue;
						if (map[nr][nc] == 0) continue;
						if (connect[map[nr][nc]][dir] == 0) continue;

						isVisited[nr][nc] = true;
						q.offer(new Node(nr, nc));
					}
				}
			}
			time++;
		}
	}

	static boolean isIn(int nr, int nc) {

		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		else
			return false;

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
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 받기 끝

			bfs(R, C);

			sb.append('#').append(t).append(' ').append(ans).append('\n');

		}

		System.out.println(sb);

	} // main end
} // class end