import java.util.Scanner;

// 같은 행에 퀸을 두지 않는 방식

// 8방탐색 하려면 퀸 둔 위치를 2차원 배열로 관리해야 해
// 말고 다른 방식 두 가지

// 첫번째 방법,
// 행 배열에 열 번호를 기록할 예정 (이러면 같은 선상인지 알 수 있음)
// 대각선인지 체크는 행+열+ 행+열-등 해가며 체크 ,,~~ 
public class Main {

	static int N, col[], ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1]; // 인덱스 1행부터 사용할 거라
		
		setQueens(1);
		System.out.println(ans);
		
		
		
	}
	
	
	static void setQueens(int rowNo) {
		// 퀸을 하나씩 놓기

		// 가지치기
		if (!isAvailable(rowNo-1)) return;
		
		// 기본 기저 파트
		if (rowNo > N) {
			// 무조건 답
			ans++;
			return;
		}
		
		// 유도파트
		for (int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueens(rowNo+1);
		}
		
		
	}


	static boolean isAvailable(int rowNo) {
		
		// 새로 놓은 퀸이 안 위협적인지 기존 퀸에게
		for (int k = 1; k < rowNo; k++) {
			if (col[rowNo] == col[k] || rowNo-k == Math.abs(col[rowNo] - col[k])) return false;
		}
		return true;
	}

}