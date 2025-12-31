import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            list = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            // input end

            int max = list[N-1];
            long result = 0;
            for (int i = N-2; i >= 0; i--){
                if (max > list[i]) {
                    result += max - list[i];
                }
                else {
                    max = list[i];
                }
            }

            System.out.println(result);

        }

    }
}
