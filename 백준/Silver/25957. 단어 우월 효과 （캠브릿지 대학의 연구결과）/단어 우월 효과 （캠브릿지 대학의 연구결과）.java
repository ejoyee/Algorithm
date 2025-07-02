import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>(N * 2);

        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            String key = makeKey(w);
            map.put(key, w);
        }

        int M = Integer.parseInt(br.readLine());
        String[] qs = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            sb.append(map.get(makeKey(qs[i])));
            if (i < M - 1) sb.append(' ');
        }
        System.out.print(sb);
    }

    static String makeKey(String w) {
        int len = w.length();
        if (len <= 2) {
            // 길이 1이나 2는 그대로 또는 단순 결합
            return (len == 2 ? w.charAt(0) + "-" + w.charAt(1) : w);
        }
        char[] mid = w.substring(1, len - 1).toCharArray();
        Arrays.sort(mid);
        return w.charAt(0) + "-" + w.charAt(len - 1) + "-" + new String(mid);
    }
}
