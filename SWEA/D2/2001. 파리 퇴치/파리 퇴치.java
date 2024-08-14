import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;

	static int[][] area;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			// 입력 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			area = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {

					int tmp = 0;

					for (int k = i; k < i + M; k++) {
						for (int l = j; l < j + M; l++) {

							tmp += area[k][l];
						}
					}
					result = Math.max(result, tmp);
				}
			}
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			

		} // testcase end
		System.out.println(sb);
	} // main end
} // class end