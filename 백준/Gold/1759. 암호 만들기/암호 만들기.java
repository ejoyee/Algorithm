import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	// L : 뽑아야 하는 수, C : 총 문자 수
	static int L, C;

	static char[] arr;
	static char[] pwd;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		pwd = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 입력 받기 끝

		// L개의 알파벳 - 모음 최소 1개 이상, 자음 최소 2개 이상
		Arrays.sort(arr);
		setPwd(0, 0, 0);
		
		System.out.println(sb);

	} // main end

	static void setPwd(int cnt, int start, int aeiou) {

		if (cnt == L) {
			
			if (aeiou < 1) return;
			if (cnt-aeiou < 2) return;
			
			for (int i = 0; i < L; i++) {
				sb.append(pwd[i]);
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i < C; i++) {

			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {

				pwd[cnt] = arr[i];
				setPwd(cnt + 1, i + 1, aeiou + 1);

			} else {

				pwd[cnt] = arr[i];
				setPwd(cnt + 1, i + 1, aeiou);

			}
		}
	}

} // class end