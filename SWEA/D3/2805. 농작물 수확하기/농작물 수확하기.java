import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();

	// main
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		
		int T = Integer.parseInt(br.readLine());
		
		// testcase start
		for (int t = 1; t <= T; t++) {
			
			int result = 0;
			
			N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					if ((Math.abs(i-N/2) + Math.abs(j-N/2)) <= N/2) {
						result += str.charAt(j) - '0';
					}
				}
			}
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
			
		}	// testcase end
		System.out.println(sb);
	}	// main end
}	// class end