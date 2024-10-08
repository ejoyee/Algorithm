import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 받기 시작
		int half = Integer.parseInt(br.readLine());
		
		int[][] students = new int[3][2];
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		// 입력 받기 끝
		
		
		sb.append(0);
		
		for (int i = 0; i < students[0][0]; i++) {
			
			if (i > students[1][1]) break;
			
			int AB = i;
			int AC = students[0][0] - AB;
			
			// 위에서 AC를 하며 남은 C 여학생 수를 구할 수 있음 
			int BC = students[2][1] - AC;
			int BA = students[1][0] - BC;
			
			// 위에서 구한 값으로 남은 여학생 구할 수 있음
			int CA = students[0][1] - BA;
			int CB = students[1][1] - i;
			
			if (AC >= 0 && BC >= 0 && BA >=0 && CA >= 0 && CB >= 0) {
				sb.setLength(0);
				sb.append(1).append('\n');
				sb.append(AB).append(' ').append(AC).append('\n');
				sb.append(BA).append(' ').append(BC).append('\n');
				sb.append(CA).append(' ').append(CB).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}

}