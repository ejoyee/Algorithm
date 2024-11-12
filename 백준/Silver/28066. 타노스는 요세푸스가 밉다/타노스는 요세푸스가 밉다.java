import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	 //원조 값 
		K = Integer.parseInt(st.nextToken());
				
		Deque<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.addLast(i);
		}
		
		
		while(q.size() >= K) {
			q.addLast(q.pollFirst());
			
			for (int i = 1; i < K; i++) {
				q.pollFirst();
			}
		}
		
		System.out.println(q.pollFirst());
		
	}
}