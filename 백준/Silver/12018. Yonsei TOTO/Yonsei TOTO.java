import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.sound.sampled.ReverbType;

public class Main {
	
	static int N, M;	// N : 과목 수 , M : 가지고 있는 마일리지 
	static int[] canJoin;	// 과목별 들으려면 내야 하는 마일리지
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작 
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		canJoin = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 신청자수 
			int l = Integer.parseInt(st.nextToken());	//가능신청수
			
			Integer[] tmp = new Integer[p];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < p; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			
			if (p < l) {
				canJoin[i] = 1;
			}
			else {
				Arrays.sort(tmp, Collections.reverseOrder());
				canJoin[i] = tmp[l-1];
			}
			
		}
		// 입력 받기 끝
		
		Arrays.sort(canJoin);
		int result = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += canJoin[i];
			if (sum > M) {
				break;
			}
			result++;
		}
		
		System.out.println(result);

	}
}