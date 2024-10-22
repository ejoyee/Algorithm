import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// 입력 받기 시작 
		char[] code = br.readLine().toCharArray();
		char[] str = new char[code.length];
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		// 입력 받기 끝
		
		for (int i = 0; i <= 26; i++) {
			for (int j = 0; j < code.length; j++) {
				str[j] = (char) ('a' + (code[j] - 'a' + i) % 26);
			}
			String result = String.valueOf(str);
			
			for (int j = 0; j < N; j++) {
				if (result.contains(words[j])) {
					System.out.println(result);
					return;
				}
			}
		}
		
		
	}

}