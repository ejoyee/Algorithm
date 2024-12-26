import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c;
	static int[] line;
	static int[] isSelected;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 초밥종류수
		k = Integer.parseInt(st.nextToken()); // 연속
		c = Integer.parseInt(st.nextToken()); // 공짜 초밥

		line = new int[N];
		isSelected = new int[d + 1];

		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		Deque<Integer> dq = new ArrayDeque<Integer>();

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			dq.addLast(line[i]);
			if (line[i] == c && isSelected[c] > 0) {
			} else if (isSelected[line[i]] == 0)
				cnt++;
			isSelected[line[i]]++;
		}
		result = Math.max(result, cnt);

		for (int i = k; i < N + k; i++) {

			int rm = dq.pollFirst();
			isSelected[rm]--;
			if (isSelected[rm] == 0)
				cnt--;

			dq.addLast(line[i % N]);
			if (line[i % N] == c && isSelected[c] > 0) {
			} else if (isSelected[line[i % N]] == 0)
				cnt++;
			isSelected[line[i % N]]++;
			
			if (isSelected[c] == 0) cnt++;
			result = Math.max(result, cnt);
			
//			for (int t = 0; t < k; t++) {
//				int test = dq.pollFirst();
//				System.out.print(test + " ");
//				dq.addLast(test);
//			}
//			System.out.println();
//			
//			System.out.println(cnt);
			
			if (isSelected[c] == 0) cnt--;
			
		}
		
		System.out.println(result);

	}

}