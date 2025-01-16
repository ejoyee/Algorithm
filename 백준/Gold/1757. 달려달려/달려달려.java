import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input start
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][][] dp = new int[N+1][M+1][2];	// N번의 시간 - N분째 달렸을 때 지침지수,달리기(0)/쉬기(1) => 지금까지 달린 거리
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < i; j++) {
				// 쉬기 (달리던 중일수도 쉬던 중일수도)
				dp[i][j > 0 ? j-1 : j][1] = Math.max(dp[i-1][j][1], dp[i][j > 0 ? j-1 : j][1]);
				dp[i][j > 0 ? j-1 : j][1] = Math.max(dp[i-1][j][0], dp[i][j > 0 ? j-1 : j][1]);
				
				// 달리기
				if (j == M) break;
				dp[i][j < N ? j+1 : j][0] = dp[i-1][j][0] + num;
				if(j == 0) dp[i][j < N ? j+1 : j][0] = Math.max(dp[i-1][j][1] + num, dp[i][j < N ? j+1 : j][0]);
			}
			
			if (dp[i][0][1] > result) result = dp[i][0][1];
			
			
		}
		// input end
//		
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("==============");
		System.out.println(result);

	}

}