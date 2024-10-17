import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 남은 기간 W
		int M = Integer.parseInt(st.nextToken());	// 챕터 개수 
		
		int [][]ch = new int[M+1][2];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			ch[i][0] = Integer.parseInt(st.nextToken());	// 소요일 무게 
			ch[i][1] = Integer.parseInt(st.nextToken());	// 페이지 수 가치 
		}
		// 입력 받기 끝
		
		int [][]dp = new int[M+1][N+1];
		for (int i = 1; i <= M; i++) {	// 읽을 수 있는 챕터 수 고려 
			for (int j = 1; j <= N; j++) {	// 남은 기간 고려 
				if (ch[i][0] > j) {	//소요일이 남은 시간보다 더 많이 들 때
					// 더 더하지 못 하고 이전 값을 가져옴
					dp[i][j] = dp[i-1][j];
				}
				else {	// 소요일이 딱 맞거나 더 적게 걸려서 읽을 수 있을 때 
					dp[i][j] = Math.max(dp[i-1][j],	// i-1번째 챕터까지 고려했을 때 페이지 수 최대 가치
							dp[i-1][j-ch[i][0]] + ch[i][1]);	// i-1번째 챕터까지 고려하고,[j-ch[i][0] 남은 기간이었던 값에 현재 자기가 읽을 수 있는 페이지 값 더해준 것 
				}
			}
		}
		
		System.out.println(dp[M][N]);
	}
}