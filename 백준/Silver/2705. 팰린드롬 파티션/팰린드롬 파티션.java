import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] nums = new int[T];
		int maxnum = 0;
		for (int t = 0; t < T; t++) {
			nums[t] = Integer.parseInt(br.readLine());
			if (maxnum < nums[t]) maxnum = nums[t];
		}
		
		int[] dp = new int[maxnum+1];
		
		dp[1] = 1;
		if (maxnum > 1) dp[2] = 2;
		
		int comp = 3;
		
		for (int t = 0; t < T; t++) {
			
			for (int i = comp; i <= nums[t]; i++) {
				if (i % 2 == 0) {
					dp[i] = dp[i - 1] + dp[i / 2];
				} else {
					dp[i] = dp[i - 1];
				}
			}
			comp = Math.max(comp, nums[t]);
			sb.append(dp[nums[t]]).append('\n');
		}
		System.out.println(sb);
	}
}