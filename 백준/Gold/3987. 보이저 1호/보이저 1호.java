import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static char[][] space;

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 만난 행성 형태 - 자신이 날아온 방향
	static int[][] reflection = {
			// /일 때
			{ 1, 0, 3, 2 },
			// \ 일 때
			{ 3, 2, 1, 0 } };

	static int PR, PC;

	static int maxTime = 0;
	static int maxdir = 0;
	
	static HashMap<Integer, Character> iToc = new HashMap<Integer, Character>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		iToc.put(0, 'U');
		iToc.put(1, 'R');
		iToc.put(2, 'D');
		iToc.put(3, 'L');

		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int hole = 0;

		space = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				space[i][j] = str.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		PR = Integer.parseInt(st.nextToken()) - 1;
		PC = Integer.parseInt(st.nextToken()) - 1;
		// 입력 받기 끝

		for (int i = 0; i < 4; i++) {
			start(PR, PC, i);
		}
		
		sb.append(iToc.get(maxdir)).append('\n');
		sb.append(maxTime);
		
		System.out.println(sb);
	}

	static void start(int startr, int startc, int startDir) {

		int cnt = 0;
		int dir = startDir;
		int r = startr;
		int c = startc;

		while (true) {
			
			r += dr[dir];
			c += dc[dir];
			cnt++;

			if (r == PR && c == PC && dir == startDir) {
				sb.append(iToc.get(startDir)).append('\n');
				sb.append("Voyager");
				System.out.println(sb);
				System.exit(0);
			}
			else if (!isIn(r, c) || space[r][c] == 'C') {
				if (cnt > maxTime) {
					maxTime = cnt;
					maxdir = startDir;
				}
				return;
			} else if (space[r][c] == '/') {
				dir = reflection[0][dir];
			} else if (space[r][c] == '\\') {
				dir = reflection[1][dir];
			}
		}

	}

	static boolean isIn(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		else
			return false;
	}
}