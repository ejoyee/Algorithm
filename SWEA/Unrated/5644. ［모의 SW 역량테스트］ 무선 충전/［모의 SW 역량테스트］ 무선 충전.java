import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BC {
	
	int x;
	int y;
	int C;	//충전범위 
	int P;	//처리량 
	
	
	public BC(int x, int y, int c, int p) {
		super();
		this.x = x;
		this.y = y;
		C = c;
		P = p;
	}
	
}

public class Solution {
		
	static StringBuilder sb = new StringBuilder();
	
	// M : 총 이동 시간, A : BC 개
	static int M, A;
	
	static BC[] BCList;
	
	static int ax, ay, bx, by;
	
	static int[] aArr;
	static int[] bArr;
	
	// X 상 우 하 좌  
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			BCList = new BC[A];
			
			ax = ay = 1;
			bx = by = 10;
			
			// A와 B의 이동 정보 입력
			aArr = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				aArr[i] = Integer.parseInt(st.nextToken());
			}
			
			bArr = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				bArr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			// BC 입력
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BCList[i] =
						new BC(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()));
			}	// bc input end
			
			
			// X 상 우 하 좌  
			int total = 0; 
			for (int i = 0; i < M+1; i++) {
				
				ax += dx[aArr[i]];
				ay += dy[aArr[i]];
				
				bx += dx[bArr[i]];
				by += dy[bArr[i]];
				
				total += charge();
				
			}
			
			sb.append('#').append(t).append(' ').append(total).append('\n');
		}	// testcase end
		
		System.out.println(sb);
	}	// main end
	
	static int charge() {
		
		int maxResult = 0;
		
		// a와 b 사용자 위치에 모든 bc 범위 검사해서 
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = 0;
				
				int Asum = Math.abs(BCList[i].x-ax)+Math.abs(BCList[i].y-ay) <= BCList[i].C ? BCList[i].P : 0;
				int Bsum = Math.abs(BCList[j].x-bx)+Math.abs(BCList[j].y-by) <= BCList[j].C ? BCList[j].P : 0;
				
				if (i != j) {
					sum = Asum + Bsum;
				}else {	// 충전 같으면 둘 중 하나여도 차피 나눌 거니까 상관 없고, 둘 중 하나라도 다른 선택지 있으면 max 값은 다른 거 선정될 
					sum = Math.max(Asum, Bsum);
					// 충전 하나일 때 대비해서 ,,~~ 무조건 i j 0 0 이라
				}
				
				
				if (maxResult < sum) {
					maxResult = sum;
				}
			}
		}
		
		return maxResult;
	} // charge end
	
}	// class end