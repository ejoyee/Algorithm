import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Point{
		int num;
		int cost;
		
		public Point(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		

		
		int N = sc.nextInt();
		int[] list = new int[N+1];
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(N, 0));
		
		while(!q.isEmpty()) {
			
			Point cur = q.poll();
	
			// 이미 cost가 입력되어있다면, continue
			if (list[cur.num] != 0) continue;
			
			list[cur.num] = cur.cost;
			
			if (cur.num == 1) break;
			
			if (cur.num % 3 == 0) {
				q.offer(new Point(cur.num / 3, cur.cost + 1));
			}
			
			if (cur.num % 2 == 0) {
				q.offer(new Point(cur.num / 2, cur.cost + 1));
			}
			
			q.offer(new Point(cur.num - 1, cur.cost + 1));
		}
		
		System.out.println(list[1]);
	}
}