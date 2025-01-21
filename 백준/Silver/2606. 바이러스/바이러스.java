import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, E;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input start
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // input end
        boolean[] isVisited = new boolean[N+1];

        Queue<Integer> q = new ArrayDeque<>();

        int result = 0;
        q.add(1);
        isVisited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for (int i = 0; i < graph[cur].size(); i++){
                if (isVisited[graph[cur].get(i)]) continue;;

                q.add(graph[cur].get(i));
                isVisited[graph[cur].get(i)] = true;
                result++;

            }
        }

        System.out.println(result);

    }
}