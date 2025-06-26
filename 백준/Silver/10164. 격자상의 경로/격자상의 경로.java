
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input start
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// input end

		int dp[][] = new int[N][M];

		// dp[r][c] = dp[r-1][c] + dp[r][c-1]
		
		for (int i = 1; i < N; i++) dp[i][0] = 1;
		for (int i = 1; i < M; i++) dp[0][i] = 1;

		// K 0 아닌 경우
		// (0, 0) -> (kR, kC) -> (N-1, M-1)
		if (K != 0) {
			int kR = K / M;
			int kC = K % M - 1;

			// 줄바꿈 이슈 위한 조건
			if (kC == -1) {
				kR -= 1;
				kC = M - 1;
			}

			// 1 -> K
			for (int i = 1; i <= kR; i++) {
				for (int j = 1; j <= kC; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

			// K -> N*M
			for (int i = kR; i < N; i++) dp[i][kC] = dp[kR][kC];
			for (int i = kC; i < M; i++) dp[kR][i] = dp[kR][kC];

			for (int i = kR + 1; i < N; i++) {
				for (int j = kC + 1; j < M; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		// K 0인 경우
		// (0, 0) -> (N-1, M-1)
		else {
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < M; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		System.out.println(dp[N - 1][M - 1]);

	} // main end
}
