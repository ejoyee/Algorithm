import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int n, r;
    static int idx = 0;
    static Map<String, Integer> stationMap;             // <역 이름, 특징비트>
    static Map<String, Integer> featMap;                // <특징 이름, 인덱스>
    static Map<Integer, Integer> countMap;              // <비트, 해당 비트 가진 역의 개수>

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        stationMap = new HashMap<>();
        featMap = new HashMap<>();
        countMap = new HashMap<>();
        countMap.put(0, 0);

        n = Integer.parseInt(br.readLine());

        // 역 이름 입력
        for (int i = 0; i < n; i++){
            stationMap.put(br.readLine(), 0);
        }

        r = Integer.parseInt(br.readLine());
        for (int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            // U : 역 특징 업데이트
            if (cmd.equals("U")){
                String curStation = st.nextToken();
                String feat[] = st.nextToken().split(",");

                int oldMask = stationMap.get(curStation);
                countMap.put(oldMask, countMap.get(oldMask) - 1);

                int bit = 0;
                for (String ft : feat) {
                    if (!featMap.containsKey(ft)){
//                        System.out.println(ft + "없어요");
                        featMap.put(ft, idx++);
                    }
                    
                    int tmp = featMap.get(ft);
                    bit |= (1 << tmp);
//                    System.out.println("idx : " + idx);
                }
                stationMap.put(curStation, bit);
                countMap.put(bit, countMap.getOrDefault(bit, 0) + 1);
//                System.out.println("bit : " + bit);

            }
            else {
                String feat[] = st.nextToken().split(",");

                int checkBit = 0;
                int total = 0;
                boolean flag = false;

                for (String f : feat) {
                    Integer idx = featMap.get(f);

                    if (idx != null){
                        checkBit |= (1 << idx);
                    }
                    else {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    sb.append(0).append('\n');
                    continue;
                }

                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if ((entry.getKey() & checkBit) == checkBit) {
                        total += entry.getValue()  ;
                    }
                }

                sb.append(total).append('\n');
            }
        }
        System.out.println(sb);
    }
}
