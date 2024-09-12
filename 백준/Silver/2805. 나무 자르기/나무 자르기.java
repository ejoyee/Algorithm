import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static long[] trees;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 입력 받기 시작 
		// N : 나무 개수, M : 얻고 싶은 나무 길이
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		long maxNum = 0;
		
		trees = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
			maxNum = maxNum < trees[i] ? trees[i] : maxNum;
		}
		// 입력 받기 끝 
		
		long left = 0;
		long right = maxNum+1;
		
		long ans = left;
		while (left <= right) {
			
			long mid = (right+left) / 2;
			
			if (cut(mid) < M) {
				right = mid -1;
			}
			else{
				left = mid + 1;
				ans = Math.max (ans, mid);
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	
	
	static long cut(long mid) {
		
		long tmp = 0;
		for (int i = 0; i < N; i++) {
			if (trees[i] - mid > 0) {
				tmp += trees[i] - mid;
			}
		}
		
		return tmp;
		
	}

}