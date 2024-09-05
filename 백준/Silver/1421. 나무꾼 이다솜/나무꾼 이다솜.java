import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, C, W;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		
		int[] wood = new int[N];
		int maxWood = 0;
		for (int i = 0; i < N; i++) {
			wood[i] = Integer.parseInt(br.readLine());
			maxWood = Math.max(maxWood, wood[i]);
		}
		// 입력 받기 끝 
		
		// 길이를 1로 자를 때부터 ... 제일 큰 길이만큼 자를때까지
		// 젤 큰 길이 << 젤 큰 거 하나만 덩어리로 팔 때 수익
		long maxMoney = 0;
		
		for (int i = 1; i <= maxWood; i++) {
			
			long money = 0;
			// N개의 나무 자르
			for (int j = 0; j < N; j++) {
				
				// i 단위로 잘랐을 때 나무 개수 K
				int k = wood[j] / i;
				
				// 자투리
				int etc = wood[j] % i;
				
				
				// 소요비 cost
				// 자른 횟수 * C
				int cost = 0;
				if (etc == 0) {
					cost = (k-1) * C;
				}
				else {	// 자투리 남을 땐 
					cost = k * C;
				}
				
				// 수익 (토막 개수 * 길이 * 단위당 가격) - 소요비 
				int tmp = (k * i * W) - cost;
				// 손해면 그냥 팔지 마
				if (tmp <= 0) continue;
				
				money += tmp;
			}
			
			maxMoney = Math.max(maxMoney, money);
		}
		
		System.out.println(maxMoney);
		
	}
}