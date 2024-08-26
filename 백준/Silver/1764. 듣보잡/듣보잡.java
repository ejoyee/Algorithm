import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for (int i = 0; i < (N+M); i++) {
			String str = br.readLine();
			
			map.put(str, map.getOrDefault(str, 0) +1);
			
			if (map.get(str) == 2) {
				ans++;
				list.add(str);
			}
		}
		Collections.sort(list);
		System.out.println(ans);
		for (String str : list) {
			System.out.println(str);
		}
	}
}