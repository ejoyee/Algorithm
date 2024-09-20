import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작 
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	// 길이 최소 이거 이상이어야 
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			if (str.length() >= M) {
				map.put(str, map.getOrDefault(str, 0) + 1);
			}
		}
		
		List<String> words = new ArrayList<>(map.keySet());
		
		words.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// value 
				if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
					return Integer.compare(map.get(o2), map.get(o1));
				}
				
				// 횟수는 같은데 길이가더 길면 
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				
				return o1.compareTo(o2);
			}
			
		});
		
		for (int i = 0; i < words.size(); i++) {
			sb.append(words.get(i)).append('\n');
		}
		
		System.out.println(sb);
		
		
	}

}