import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] sour, bitter;
	static int good = Integer.MAX_VALUE;

	static void cook(int cnt, int curSour, int curBit, int sCnt) {

		if (cnt == N) {
			if (sCnt > 0) {
				good = Math.min(good, Math.abs(curSour - curBit));
			}
			return;
		}

		int tmpS = curSour * sour[cnt];
		int tmpB = curBit + bitter[cnt];

		cook(cnt + 1, tmpS, tmpB, sCnt + 1);
		cook(cnt + 1, curSour, curBit, sCnt);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기 시작
		N = Integer.parseInt(br.readLine().trim());

		sour = new int[N];
		bitter = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 받기 끝

		cook(0, 1, 0, 0);

		System.out.println(good);

	} // main end
} // class end