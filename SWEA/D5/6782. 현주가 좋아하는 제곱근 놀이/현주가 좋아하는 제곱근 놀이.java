import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	
	// main start
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			long N = Long.parseLong(br.readLine());
			
			int result = 0;
			
			while (N != 2) {
				
				double sqrt = Math.sqrt(N);
				if (sqrt == (long)sqrt) {
					N = (long)sqrt;
					result++;
				}
				else {
					// 더해줘야 할 때
					double nextSqrt = Math.ceil(sqrt); // 4
					long next = (long) Math.pow((long) nextSqrt, 2);	// 16
					
					// +1 해준만큼 count
					result += next - N;
					
					N = next;
				}
				
			}
			
			//sb.append('#').append(t).append(' ').append(result).append('\n');
			System.out.println("#" + t + " " + result);
		}	// testcase end
		
		//System.out.println(sb);
	}	// main end
}	// class end