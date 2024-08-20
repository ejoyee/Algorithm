import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int maxTop;
	static int result;
	
	static int[] arr;
	
	static int N, B;
	
	static void generateSubset(int cnt, int top) {
		
		if (cnt == N) {
			if (top >= B) {
				result = Math.min(top - B, result);
			}
			return;
		}
		else {
			generateSubset(cnt+1, top + arr[cnt]);
			generateSubset(cnt+1, top);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];

			maxTop = 0;
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxTop += arr[i];
			}

			// 입력 받기 끝
			
			if (maxTop == B) {
				result = 0;
			}
			else {
				result = maxTop - B;
				generateSubset(0, 0);
			}
			
			
			System.out.println("#" + t + " " +result);
			
			
		} // testcase end
	} //main end
} //class end