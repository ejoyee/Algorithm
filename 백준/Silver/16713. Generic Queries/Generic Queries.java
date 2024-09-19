import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// xor start ~ end 누적 누적 
	// 3~5면 1~5에서 1~2를 제외 가능?xor되는듯?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N+1];
		int[] xor = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			xor[i] = xor[i-1] ^ nums[i];
		}
		
		int result = 0;
		for (int i = 0; i < Q; i++) {
			
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			result ^= xor[end] ^ xor[start-1];
		}
		
		System.out.println(result);
	}

}