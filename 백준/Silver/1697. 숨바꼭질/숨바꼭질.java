import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input start
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// input end

		Queue<Integer> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[100001];
		q.add(N);
		isVisited[N] = true;

		int cnt = 0;
		while (!q.isEmpty()) {

			int size = q.size();
			while (--size >= 0) {

				int cur = q.poll();

				if (cur == K) {
					sb.append(cnt);
					break;
				}

				if (cur - 1 >= 0 && !isVisited[cur - 1]) {
					q.add(cur - 1);
					isVisited[cur - 1] = true;
				}

				if (cur + 1 <= 100000 && !isVisited[cur + 1]) {
					q.add(cur + 1);
					isVisited[cur + 1] = true;
				}

				if (cur * 2 <= 100000 && !isVisited[cur * 2]) {
					q.add(cur * 2);
					isVisited[cur * 2] = true;
				}

			}
			cnt++;
		}

		System.out.println(sb);
	}

}