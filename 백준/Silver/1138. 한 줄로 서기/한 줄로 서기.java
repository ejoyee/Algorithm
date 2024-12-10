import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input start
		N = Integer.parseInt(br.readLine());
		line = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int leftNum = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= N; j++) {
				if (leftNum == 0) {
					if (line[j] == 0) {
						line[j] = i;
						break;
					} else {
						continue;
					}
				} else if (line[j] == 0) {
					leftNum--;
				}
			}
		}

		// input end

		for (int i = 1; i <= N; i++) {
			sb.append(line[i]).append(' ');
		}

		System.out.println(sb);

	}// main end
}// class end