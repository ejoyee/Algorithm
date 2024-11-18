import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] arr;
	static int knowNum;
	static int[] know;

	static int[] p;

	static void makeSet() {
		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
	}

	static int findSet(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	static void union(int x, int y) {

		int xp = findSet(x);
		int yp = findSet(y);

        if(xp > yp){
            int temp = xp;
            xp = yp;
            yp= temp;
        }
        
        if (xp != yp) p[yp] = xp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		knowNum = Integer.parseInt(st.nextToken());
		if (knowNum > 0) {
			know = new int[N + 1];
			for (int i = 0; i < knowNum; i++) {
				know[i] = Integer.parseInt(st.nextToken());
			}

			arr = new ArrayList[M];
			for (int i = 0; i < M; i++) {
				arr[i] = new ArrayList<Integer>();

				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < num; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					arr[i].add(tmp);
				}
			}

			makeSet();

			for (int i = 0; i < M; i++) {
				
				int first = arr[i].get(0);
				
				int size = arr[i].size();
				for (int j = 1; j < size; j++) {
					union(first, arr[i].get(j));
				}
			}

//			for (int i = 1; i <= N; i++) {
//				if (know[i]) {
//					int parent = findSet(i);
//					know[parent] = true;
//				}
//			}

			int result = 0;
			for (int i = 0; i < M; i++) {
				
				int num = arr[i].get(0);
	            boolean flag = true;

				for (int j = 0; j < knowNum; j++) {
					if (findSet(num) == findSet(know[j])){
						flag = false;
						break;
					}
				}
				if(flag) {
					result++;
				}
			}

			System.out.println(result);

		} else {
			System.out.println(M);
			return;
		}

	}

}