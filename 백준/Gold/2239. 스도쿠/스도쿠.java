import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map = new int[10][10];

	static boolean[][] rows = new boolean[10][10];
	static boolean[][] cols = new boolean[10][10];
	static boolean[][][] secs = new boolean[3][3][10];

	static List<Point> blank = new ArrayList<>();

	static void sdk(int idx, int check) {
		
		if (check == 81) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}

		Point cur = blank.get(idx);

		for (int i = 1; i <= 9; i++) {
			if (rows[cur.r][i] || cols[cur.c][i] || secs[(cur.r - 1) / 3][(cur.c - 1) / 3][i]) {
				// 셋 중 하나라도 만족하면 (하나라도 안 되면)
				continue;
			} else {
				rows[cur.r][i] = true;
				cols[cur.c][i] = true;
				secs[(cur.r - 1) / 3][(cur.c - 1) / 3][i] = true;

				map[cur.r][cur.c] = i;

				sdk(idx + 1, check + 1);

				rows[cur.r][i] = false;
				cols[cur.c][i] = false;
				secs[(cur.r - 1) / 3][(cur.c - 1) / 3][i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int check = 0;

		// 입력 받기 시작
		for (int i = 1; i <= 9; i++) {
			String str = br.readLine();
			for (int j = 1; j <= 9; j++) {
				map[i][j] = str.charAt(j - 1) - '0';

				if (map[i][j] != 0) {
					rows[i][map[i][j]] = true;
					cols[j][map[i][j]] = true;
					secs[(i - 1) / 3][(j - 1) / 3][map[i][j]] = true;

					check++;
				} else {
					blank.add(new Point(i, j));
				}
			}
		}
		// 입력 받기 끝

		sdk(0, check);

	}
}