import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	
	static int N;
	static int[][] arr;
	
	static int cut(int r, int c, int size) {
		
		if (size == 1) {
			return arr[r][c];
		}
		
		int half = size/2;
		int[] tmp = new int[4];
		
		tmp[0] = cut(r, c, half);
		tmp[1] = cut(r, c+half, half);
		tmp[2] = cut(r+half, c, half);
		tmp[3] = cut(r+half, c+half, half);
		
		Arrays.sort(tmp);
		
		return tmp[1];
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 받기 끝
		
		int result = cut(0, 0, N);
		System.out.println(result);
		
	}
}