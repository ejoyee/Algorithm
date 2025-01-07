import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static long[] lego;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String t = null;
		
		while((t = br.readLine()) != null) {
			
			sb.setLength(0);
			
			// input start
			long x = Long.parseLong(t) * 10000000;
			int n = Integer.parseInt(br.readLine());
			
			lego = new long[n];
			for (int i = 0; i < n; i++) {
				lego[i] = Long.parseLong(br.readLine());
			}
			// input end
			
			Arrays.sort(lego);
			
			int left = 0; 
			int right = n-1;
			
			
			while (left < right) {
				
				long sum = lego[left] + lego[right];
				
				if (sum == x) {
					sb.append("yes").append(' ').append(lego[left]).append(' ').append(lego[right]);
					break;
				}
				else if (sum > x) {
					right--;
				}
				else {
					left++;
				}
			}
			
			if (sb.length() == 0) {
				sb.append("danger");
			}

			System.out.println(sb);
			
		}
	}
}