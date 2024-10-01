import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int comp = 3;
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			for (int i = comp; i <= N; i++) {
				if (i % 2 == 0) {
					dp[i] = dp[i-1] + dp[i/2];
				}
				else {
					dp[i] = dp[i-1];
				}
			}
			comp = Math.max(comp, N);
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb);
	}
}