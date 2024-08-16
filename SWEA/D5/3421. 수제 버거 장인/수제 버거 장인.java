import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution{

	// 출력용 stringbuilder
	static StringBuilder sb = new StringBuilder();

	// T : 테스트케이스, N : 재료의 종류, M : 안 좋은 조합의 수
	static int T, N, M;

	static boolean[] isSelected;

	static List<Integer>[] bad;

	static int result = 0;

	static void ham(int cnt) {

		if (cnt > N) {

			for (int i = 1; i <= N; i++) {

				if (isSelected[i]) {
					if (bad[i].size() != 0) {
						for (int j = 0; j < bad[i].size(); j++) {
							int index = bad[i].get(j);
							if (isSelected[index])
								return;
						}

					}

				}
			}
			result++;
			return;

		}

		isSelected[cnt] = true;
		ham(cnt + 1);
		isSelected[cnt] = false;
		ham(cnt + 1);

	}


	// 메인
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			result = 0;

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isSelected = new boolean[N + 1];
			bad = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {

				bad[i] = new ArrayList<>();

			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());

				bad[tmp1].add(tmp2);
				bad[tmp2].add(tmp1);

			}

			// 입력 받기 끝

			ham(1);

			System.out.println("#" + t + " " + result);

		} // testcase for end
	}// main end
}// class end
