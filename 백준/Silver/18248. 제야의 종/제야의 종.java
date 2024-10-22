import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] people = new int[N][M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());

				if (people[i][j] == 1) {
					cnt++;
				}
			}

			people[i][M] = cnt;
		}
		// 입력 받기 끝

		Arrays.sort(people, (o1, o2) -> {
			return o2[M] - o1[M];
		});

		for (int j = 0; j < M; j++) {
			int num = people[0][j];
			for (int k = 0; k < N; k++) {
				if (num < people[k][j]) {
					System.out.println("NO");
					System.exit(0);
				}

				num = people[k][j];
			}
		}

		System.out.println("YES");

	}

}