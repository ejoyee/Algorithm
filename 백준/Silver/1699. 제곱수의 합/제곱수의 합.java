import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = i;
			// 최적의 제곱 구하기?
			for (int j = 1; j*j <= i; j++) {
				
				// 12 = 3^2 + 1^1 * 3
				// 해당 값에서 최대 제곱인 값을 찾기 위함
				// 제곱 더 커질수록 수가 줄어드니까 덮어쓰고 덮어쓰고??? 
				if (dp[i] > dp[i - j*j] + 1) {
					dp[i] = dp[i - j*j] + 1;
				}
			}
		}
		
		System.out.println(dp[N]);
		
		
	}

}