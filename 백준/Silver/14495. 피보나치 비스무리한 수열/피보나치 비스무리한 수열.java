
import java.util.Scanner;



public class Main {
	
	static long [] f;
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		f = new long[117];		
		f[1] = f[2] = f[3] = 1;
		
		for (int i = 4; i <= n; i++) {
			f[i] = f[i-1] + f[i-3];
		}
		
		
		System.out.println(f[n]);
	}
	
}
