import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, r, c;
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int num = (int) Math.pow(2, N);
		
		ans = 0;
		cut(r, c, num);
		System.out.println(ans);
	}
	
	static void cut (int r, int c, int size) {
		
		if (size == 1) {
			return;
		}
		//2사분
		if (r < size / 2 && c < size / 2) {
			cut(r, c, size/2);
		}
		//1사분면 
		else if (r < size / 2 && c >= size / 2 ) {
			ans += size * size / 4;
			cut(r, c - size/2, size/2);
		}
		else if (r >= size / 2 && c < size / 2) {
			ans += size * size / 4 * 2;
			cut (r-size/2, c, size/2);
		}
		else {
			ans += size * size / 4 * 3;
			cut (r-size/2, c-size/2, size/2);
		}
		
	}

}