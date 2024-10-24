import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		
		Queue<Integer> q = new ArrayDeque<>();
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == -1) {
				break;
			}
			else if(num == 0) {
				q.poll();
			}
			else if (N > q.size()) {
				q.offer(num);
			}
			
		}

		if (q.isEmpty()) {
			sb.append("empty");
		}else {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				sb.append(q.poll()).append(' ');
				if (i == N-1) {
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

}