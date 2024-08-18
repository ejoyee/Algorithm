import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	// S : 총 문자열 길이, P : 뽑을 문자열의 수
	static int S, P;

	static ArrayDeque<Character> window;

	static int result = 0;

	// main start
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		char[] arr = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		window = new ArrayDeque<>();

		// addLast(value) (first) offer
		// removeFirst() (last) poll

		// A C G T
		int[] check = new int[4];

		for (int j = 0; j < P; j++) {
			window.addLast(arr[j]);
			
			if (arr[j] == 'A')
				check[0]++;
			else if (arr[j] == 'C')
				check[1]++;
			else if (arr[j] == 'G')
				check[2]++;
			else if (arr[j] == 'T')
				check[3]++;
		}
		

		if (check[0] >= a && check[1] >= c && check[2] >= g && check[3] >= t) {
					result++;
				}
				
		for (int i = P; i < S; i++) {



				char tmp = window.removeFirst();
				if (tmp == 'A')
					check[0]--;
				else if (tmp == 'C')
					check[1]--;
				else if (tmp == 'G')
					check[2]--;
				else if (tmp == 'T')
					check[3]--;
				
				window.addLast(arr[i]);
				if (arr[i] == 'A')
					check[0]++;
				else if (arr[i] == 'C')
					check[1]++;
				else if (arr[i] == 'G')
					check[2]++;
				else if (arr[i] == 'T')
					check[3]++;


				if (check[0] >= a && check[1] >= c && check[2] >= g && check[3] >= t) {
					result++;
				}
			

		}
		
		System.out.println(result);

	} // main end
} // class end