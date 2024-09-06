import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 중복된 탐색을 하지 않도록 최적화
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

			// 초기화
			for (int i = 1; i <= N; i++) {
				adjMartix[i][0] = -1; // 탐색되지 않은 학생을 나타냄 (후에 탐색이 완료되면 자신보다 큰 학생 수 저장)
				//adjMartix[0][i] = -1; // 탐색되지 않은 학생을 나타냄 (후에 탐색이 완료되면 자신보다 작은 학생 수 저장)
			}


			for (int i = 1; i <= N; i++) {
				// 자기 기준으로 탐색을 시킬 건데
				// 아직 탐색되지 않은 학생일 때 진입할 예정이기에
				if (adjMartix[i][0] != -1) continue;
				gtDFS(i);
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjMartix[0][j] += adjMartix[i][j];
				}
			}
			
			int ans = 0; // 자신의 키를 알 수 있는 학생 수
			for (int k = 1; k <= N; k++) {
				// 인접 행렬의 k행 0열과 0행의 k열
				if (adjMartix[k][0] + adjMartix[0][k] == N-1) ans++;
			}

			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	} // main end

	// 자신보다 큰 쪽으로 따라 탐색
	private static void gtDFS(int cur) {

		for (int i = 1; i <= N; i++) {
			if (adjMartix[cur][i] == 0)
				continue; // 나랑 관련 없는 애들 continue

			if (adjMartix[i][0] == -1) { // 탐색되지 않은 학생이므로 탐색
				gtDFS(i);
			}

			// 나보다 키가 큰 학생이 탐색을 완료한 상태
			// i보다 키가 큰 학생이 있다면 그 학생들의 정보를 cur에세 반영 (간접 관계를 직접 관계로 경로 압축)
			if (adjMartix[i][0] > 0) { // 나보다 큰 학생이 있을 때만 비교
				for (int j = 1; j <= N; j++) {
					// i가 나보다 큰 애
					if (adjMartix[i][j] != 0)
						adjMartix[cur][j] = 1;
				}
			}
		}

		adjMartix[cur][0] = 0;	// 초기값이 -1이므로 누적 위해 0으로 초기화
		for (int k = 1; k <= N; k++) {
			adjMartix[cur][0] += adjMartix[cur][k];
		}

	} // gtDFS end

} // class end
