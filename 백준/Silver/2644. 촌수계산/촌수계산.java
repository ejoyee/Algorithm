import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    
    static class Step {
    	int num;
    	int cnt;
    	
		public Step(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input start
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int e = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[c].add(d);
            graph[d].add(c);
        }
        // input end

        Queue<Step> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n+1];

        q.add(new Step(a, 0));
        isVisited[a] = true;
        
        while (!q.isEmpty()) {
            Step cur = q.poll();
            
            if (cur.num == b) {
            	sb.append(cur.cnt);
            	break;
            }

            for(int i = 0; i < graph[cur.num].size(); i++) {
            	if (isVisited[graph[cur.num].get(i)]) continue;
            	
            	q.add(new Step(graph[cur.num].get(i), cur.cnt +1));
            	isVisited[graph[cur.num].get(i)] = true;
            }

        }
        
        if (sb.length() == 0) {
        	System.out.println(-1);
        }else {
        	
        	System.out.println(sb);
        }
        
    }
}