import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	static int N;
	
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input start
		N = Integer.parseInt(br.readLine());
		// input end
		
		cutNum(N, 0);
		
		System.out.println(min + " " + max);

	}// main end
	
	static void cutNum (int num, int cnt) {
		
		String strNum = String.valueOf(num);
		
		// 홀수 세기 
		int curOdd = 0;
		while (num > 0) {
			int tmp = num % 10;
			if (tmp % 2 == 1) {
				curOdd++;
			}
			num /= 10;
		}
		cnt += curOdd;
		
		
		// 한 자리 
		if (strNum.length() == 1) {
			min = Math.min(min, cnt);
			max = Math.max(max, cnt);
			return;
		}
		
		// 두 자리
		else if (strNum.length() == 2) {
			int next = Integer.parseInt(strNum.substring(0, 1));
			next += Integer.parseInt(strNum.substring(1));
			cutNum(next, cnt);
		}
		
		// 세 자리 이상 
		else {
			for (int i = 0; i < strNum.length()-2; i++) {
				for (int j = i+1; j < strNum.length() - 1; j++) {
					int next = 0;
					next += Integer.parseInt(strNum.substring(0, i+1));
					next += Integer.parseInt(strNum.substring(i+1, j+1));
					next += Integer.parseInt(strNum.substring(j+1));
					
					cutNum(next, cnt);
				}
			}
		}
	}
}// class end