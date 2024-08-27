import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.Skeleton;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
 */

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		HashMap<Integer, Integer> hmap = new HashMap<>();

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();
			int num = 0;

			// all: S를 {1, 2, ..., 20} 으로 바꾼다.
			if (cmd.equals("all")) {
				for(int j = 1; j <= 20; j++) {
					hmap.put(j, 1);
				}
				continue;
			}
			// empty: S를 공집합으로 바꾼다.
			else if (cmd.equals("empty")) {
				hmap.clear();
				continue;
			}
			else {
				
				
				if (st.hasMoreElements()) {
					num = Integer.parseInt(st.nextToken());
				}
				
				switch (cmd) {
				// add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
				case "add":
					hmap.put(num, 1);
					break;

				// remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
				case "remove":
					hmap.remove(num);
					break;
					
					
				//check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
				case "check":
					int result = hmap.getOrDefault(num, 0);
					sb.append(result).append('\n');
					break;

				// toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
				case "toggle":
					
					if (hmap.containsKey(num)) {
						hmap.remove(num);
					}else {
						hmap.put(num, 1);
					}

					break;

				default:
					break;
				}
			}

			

		} // cmd for end
		
		System.out.println(sb);
	} // main end
} // class end