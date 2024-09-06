import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();

	static int N, adjMartix[][], cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // 졸려

		int T = Integer.parseInt(br.readLine().trim()); // 매우 졸려

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine()); // 너무 졸려
			int M = Integer.parseInt(br.readLine());

			adjMartix = new int[N + 1][N + 1]; // 학생 번호가 1번부터 시작
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()); // 진짜 졸려
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMartix[a][b] = 1;
			}

			int ans = 0; // 자신의 키를 알 수 있는 학생 수

			// 각 학생마다 자신보다 큰, 자신보다 작은 학생 각각 탐색
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if (cnt == N-1) ans++;
			}

			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	} // main end

	// 자신보다 큰 쪽으로 따라 탐색
	private static void gtDFS(int cur, boolean[] visited) {

		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			// 나보다 큰 애
			if (!visited[i] && adjMartix[cur][i] != 0) {
				gtDFS(i, visited);
				cnt++; // 나보다 큰 대상 카운팅
			}
		}
 
	} // gtDFS end

	// 자신보다 작은 쪽으로 따라 탐색
	// 열로 접근
	private static void ltDFS(int cur, boolean[] visited) {

		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) {
			// 나보다 큰 애
			if (!visited[i] && adjMartix[i][cur] != 0) {
				ltDFS(i, visited);
				cnt++; // 나보다 큰 대상 카운팅
			}
		}

	} // ltDFS end

} // class end