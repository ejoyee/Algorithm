import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 입력 받기 시작
			N = sc.nextInt();
			
			int pre = sc.nextInt();
			int leftCnt = 0;
			int rightCnt = 0;
			
			int result = 0;
			
			boolean flag = false;
			for (int i = 1; i < N; i++) {
				int cur = sc.nextInt();
				
				// 내리막이다가 오르막 만난 경우
				if (!flag && cur > pre) {
					// 이전 봉우리까지의 cnt들 반영
					result += rightCnt * leftCnt;
					
					leftCnt = 1;
					flag = true; // 오르막 시작
				}
				// 오르막일 때 오르막 만난 경우
				else if (flag && cur > pre) {
					leftCnt++;
				}
				// 오르막이다가 내리막 만난 경우
				else if (flag && cur < pre) {
					rightCnt = 1;
					flag = false;
					
					if (i == N-1) {
						result += rightCnt * leftCnt;
					}
				}
				// 내리막이다가 내리막 만난 경우
				else if (!flag && cur < pre) {
					rightCnt++;
					
					if (i == N-1) {
						result += rightCnt * leftCnt;
					}
				}
				pre=cur;
			}
			// 입력 받기 끝
			
			sb.append('#').append(t).append(' ').append(result).append('\n');
			
			
			
		} // testcase end
		System.out.println(sb);
	}
}