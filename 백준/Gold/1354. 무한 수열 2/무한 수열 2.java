import java.io.*;
import java.util.*;

public class Main {

    static long n;
    static long p, q;
    static long x, y;

    static Map<Long, Long> memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());


        memo = new HashMap<>();

        System.out.println(calculate(n));
    }

    public static long calculate(long n){
        if(n <= 0) return 1;

        if(memo.containsKey(n)) return memo.get(n);

        long a = calculate(n / p - x);
        long b = calculate(n / q - y);

        long result = a + b;

        memo.put(n, result);

        return result;
    }
}