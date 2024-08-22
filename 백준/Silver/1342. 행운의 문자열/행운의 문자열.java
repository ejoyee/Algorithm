import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] alp = new int[26];
	static int N;
	
	static int result;
	
	static void lucky(int cnt, char preChar) {
		
		// 다 골랐을 때 결과 ++ 후 return
		if (cnt == N) {
			result++;
			return;
		}
		
		// 알파벳 배열 돌며, 같지 않으면 해당 알파벳 넣어봄
		// 다른 루트 선택할 때를 위해서 다시 ++ 원
		for (int i = 0; i < 26; i++) {
			if (alp[i] == 0) continue;
			
			if (preChar != ' ' && (int) preChar == (i+'a')) continue;
			
			alp[i]--;
			lucky(cnt+1, (char)(i+'a'));
			alp[i]++;
			
		}
		
		
		
	}

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력 받기
		String str = br.readLine();
		N = str.length();	
		
		for (int i = 0; i < N; i++) {
			alp[str.charAt(i)-'a']++;
		}
		// 입력 끝
		
		
		// 처음에는 비교할 pre 없기에 
		lucky(0, ' ');
		
		sb.append(result);
		System.out.println(sb);
		
		
	}//main end
}//class end