import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		boolean start = false;
		int ans = 1;
		map.put("ChongChong", 1);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String user1 = st.nextToken();
			String user2 = st.nextToken();
			
			if (!start) {
				if (user1.equals("ChongChong")) {
					start = true;
					map.put(user2, 1);
					ans++;
				}else if (user2.equals("ChongChong")) {
					start = true;
					map.put(user1, 1);
					ans++;
				}
			}
			else {
				if (map.containsKey(user2) && !map.containsKey(user1)) {
					map.put(user1, 1);
					ans++;
				}
				if(map.containsKey(user1) && !map.containsKey(user2)) {
					map.put(user2, 1);
					ans++;
				}
			}
			
		}
		
		System.out.println(ans);
		
	}// main end
}// class end