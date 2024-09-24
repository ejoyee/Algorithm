import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		int N = Integer.parseInt(br.readLine());
		
		int[][] cows = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}
		// 0 도착 시간
		// 1 검문 시간
		
		// 도착시간순 정렬 
		Arrays.sort(cows, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});		
		
		// 선택하는 게 아니라 모든 소의 입장 시간 구하기
		// 도착 시간과 다른 소의 검문 시간이 겹치느냐 아니냐
			// 내가 도착한 시간이 이전 소의 끝나는 시간보다 빠르거나 같다면 
			// 무조건 그 소가 끝나야 할 수 있기 때문에 그 친구 끝나는 시간 + 내 검문 시간
		
			// 내가 도착한 시간이 다른 소 검문 끝나는 모든 시간보다 더 늦다면
			// 얘 도착 시간 + 검문 시간이 무조건 답
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (result >= cows[i][0]) {
				result += cows[i][1];
			}
			else if (result < cows[i][0]) {	// 이전 소까지 마치는 시간보다 내가 더 늦게 도착하
				result = cows[i][0] + cows[i][1];
			}
		}
		
		System.out.println(result);
		
		
		
		
		
	}	// main end
}	// class end