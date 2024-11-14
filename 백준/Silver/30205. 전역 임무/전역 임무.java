import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long P;

	static int[][] stage;
	static int[] itemNum;

	static List<Integer>[] stageList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 시작
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		stage = new int[N][M];
		itemNum = new int[N];
		stageList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			stageList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				stage[i][j] = Integer.parseInt(st.nextToken());
				
				if (stage[i][j] == -1) {
					itemNum[i]++;
				} else {
					stageList[i].add(stage[i][j]);
				}
			}
		}
		// 입력 끝

		// 정렬
		for (int i = 0; i < N; i++) {
//			Arrays.sort(stage[i]);
			Collections.sort(stageList[i]);
			
//			System.out.println(stageList[i]);
		}
		
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			
//			System.out.println("=====stage " + (i+1) + "=====");
			if (!flag) {
				break;
			}
			for (int j = 0; j < stageList[i].size(); j++) {
				int enemy = stageList[i].get(j);
//				System.out.println((j+1)+"층 - 적 전투력 : "+enemy);
//				System.out.println("현재 내 전투력 : " + P);
				if (enemy <= P) {
//					System.out.println("승리! 다음 층으로 ");
					P += enemy;
				}else {
//					System.out.println("질 거 같은데?");
					if (itemNum[i] > 0) {
//						System.out.println("아이템이 있다!");
						itemNum[i]--;
						P *= 2;
//						System.out.println("전투력 up! : " + P);
						j--;
					}
					else {
//						System.out.println("패배 ...");
						flag = false;
						break;
					}
				}
//				System.out.println("------");
			}
			
			if (itemNum[i] > 0) {
//				System.out.println("아이템이 " + itemNum[i] + "개 남았네?");
				P = P * (int) Math.pow(2, itemNum[i]);
//				System.out.println("남은만큼 up! " + P );
				itemNum[i] = 0;
			}
		}
		
		if (flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(stage[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		

	}

}