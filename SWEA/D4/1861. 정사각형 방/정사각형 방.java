import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	// 메모이제이션
	// 더 넓은 분류로는 dfs했떤 값을 재활용 dp
	// dp 제일 중요한 것 -> dp 자료구조 어떻게 정의할 것이냐
	// 메모용 int[][] 거기서부터 시작했을 때 최대거리
	// dp[i][j] = map[i][j]에서 시작했을 때 갈 수 있는 최대거리 라고 주석으로 적어두기
	// 기본값처리 visited가 true라면 최소 1이니까 0이면 아예 방무도 안 한 애니까
	
	static int N;
	static int maxCnt = 0;
	static int roomNum = 0;
	static int[][] map;
	
	// dp[i][j] = map[i][j]에서 시작했을 때 갈 수 있는 최대거리
	static int[][] dp;
	
	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	
	static int dfs(int i, int j) { //i,j에서 시작했을 떄 갈 수 있는 거리
		//메모 확인
		if(dp[i][j] > 0) return dp[i][j];
		
		//메모가 없으니까 계산
		for(int d = 0;d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { 
				if (map[ny][nx] == map[i][j] + 1) {
					dp[i][j] = dfs(ny,nx) + 1;
					return dp[i][j];
				}
				
			}
		}
		//내 근처칸중에 +1인 칸이 없네.
		dp[i][j] = 1;
		return dp[i][j];
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			// 초기화
			maxCnt = 0;
			roomNum = 0;
			
			// 입력 받기 끝
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dp = new int[N][N]; //dp[i][j] : i,j부터 출발해서 갈 수 있는 거리
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 받기 끝
			
			
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(dp[i][j] > 0) continue; //메모 되어있다 = 갔다왔다
					int cur_dist = dfs(i,j);
					if(maxCnt < cur_dist) {
						maxCnt = cur_dist;
						roomNum = map[i][j];
					} else if(maxCnt == cur_dist) {
						roomNum = Math.min(map[i][j], roomNum);
					}
				}
			}
			
			sb.append('#').append(t).append(' ').append(roomNum).append(' ').append(maxCnt).append('\n');
			
		}	// testcase end
		System.out.println(sb);
	}	// main end
}	// class end