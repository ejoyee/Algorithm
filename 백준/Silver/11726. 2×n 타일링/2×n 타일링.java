import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		// 2 x n 크기의 직사각형을
		// 1 x 2  타일
		// 2 x 1  타일
		// 로 채우는 경우의 수
		
		// n 1 ~ 1000
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// f(1) = 1 (2 x 1 1개)
		// f(2) = 2	(2 x 1 2개) (1 x 2 2개)
		// f(3) = 3
		// f(4) = 5 ...
		
		// f(n) = f(n-1) + f(n-2)

		if (N == 1) {
			System.out.println(1);
			return;
		}
			
		int[] dp = new int[N+1];

		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		

		System.out.println(dp[N]);
	}

}