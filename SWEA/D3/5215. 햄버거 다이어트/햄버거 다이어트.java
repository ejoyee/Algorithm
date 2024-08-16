import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 출력용 stringbuilder
	static StringBuilder sb = new StringBuilder();

	// T : 테스트케이스, N : 재료의 종루, L : 제한 칼로리
	static int T, N, L;
	// 각 재료들의 만족도와 칼로리 배열
	static int[] score, calory;
//	// N개만큼 선언될 재료 선택 여부
//	static boolean[] isSelected;
	
	static int result;

	// 부분집합 찾아서 조건에 맞게 걸러줄 함수
	static void subsetSum(int cnt, int curSum, int curScore) {

		if (curSum > L)
			return;
		
		if (cnt == N) {
//			int tmp = 0;
//			for (int i = 0; i < N; i++) {
//				if (isSelected[i]) tmp += score[i];
//			}
			result = Math.max(result, curScore);
			return;
		}

		// 선택
		//isSelected[cnt] = true;
		subsetSum(cnt + 1, curSum + calory[cnt], curScore + score[cnt]);
		// 비선택
		//isSelected[cnt] = false;
		subsetSum(cnt+1, curSum, curScore);
		
	}

	// 메인
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			
			result = 0;

			// 입력 받기 시작
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			score = new int[N];
			calory = new int[N];
			//isSelected = new boolean[N];

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine());

				score[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());

			}
			// 입력 받기 끝
			
			subsetSum(0, 0, 0);
			
			System.out.println("#" + t + " " + result);

		} // testcase for end
	}// main end
}// class end