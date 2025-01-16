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
		
		int[][][] dp = new int[N+1][M+1][2];	// N번의 시간 - N분째 달렸을 때 지침지수 - 달리기(0)/쉬기(1) => 지금까지 달린 거리
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 지침지수를 늘려가며
			for (int j = 0; j < i; j++) {
				// 쉬기 (달리던 중일수도 쉬던 중일수도)
				dp[i][j > 0 ? j-1 : j][1] = Math.max(dp[i-1][j][1], dp[i][j > 0 ? j-1 : j][1]);	// 마저 쉴 때
				dp[i][j > 0 ? j-1 : j][1] = Math.max(dp[i-1][j][0], dp[i][j > 0 ? j-1 : j][1]);	// 달리다가 쉴 
				
				// 달리기
				if (j == M) break;	// 지침지수 넘으면 안 돼서 
				if (j < N) {
					dp[i][j+1][0] = dp[i-1][j][0] + num;	// 달리는 상태일 때
					// 지침지수가 0이라면 쉬던 상태여도 이젠 달려도 됨
					if(j == 0) dp[i][j+1][0] = Math.max(dp[i-1][j][1] + num, dp[i][j+1][0]);
				}
				
			}
			
			
			// 마지막이 달리는 상태면 지침지수가 0일 수 없으니까 쉬던 상태인 1 확인
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