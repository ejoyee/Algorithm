import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static Station[] stations; // 각 역의 정보 저장하는 배열 (인덱스 : 고유번호)

    public static class Station{
        int pre; // 이전 역
        int next; // 다음 역

        public Station(int pre, int next){
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 배열 초기화 (초기의 최대 크기 50만, 공사 최대 150만번
        stations = new Station[2000001];



        // 원형 역 만들기
        st = new StringTokenizer(br.readLine());
        int pre = -1;
        int next = -1;
        int cur = Integer.parseInt(st.nextToken());
        int first = cur;

        // 마지막 역 이전까지 처리
        for(int i = 0; i < n-1; i++){
            next = Integer.parseInt(st.nextToken());

            stations[cur] = new Station(pre, next);

            pre = cur;
            cur = next;
        }

        // 마지막 역 처리 (원형이므로 첫번째 역과 이어지도록)
        stations[cur] = new Station(pre, first);
        stations[first].pre = cur;



        // 공사 하기
        for(int i = 0; i < m; i++){

            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            // 다음 역 출력, 다음 역 사이에 새로운 역 삽입
            if(command.equals("BN")){
                int pivot = Integer.parseInt(st.nextToken());
                int newStation = Integer.parseInt(st.nextToken());

                int pivotNext = stations[pivot].next;

                sb.append(pivotNext).append('\n');

                // 새로운 역 추가하고 연결
                stations[newStation] = new Station(pivot, pivotNext);
                stations[pivot].next = newStation;
                stations[pivotNext].pre = newStation;

            }
            // 이전 역 출력, 이전 역 사이에 새로운 역 삽입
            else if(command.equals("BP")){
                int pivot = Integer.parseInt(st.nextToken());
                int newStation = Integer.parseInt(st.nextToken());

                int pivotPre = stations[pivot].pre;

                sb.append(pivotPre).append('\n');

                // 새로운 역 추가하고 연결
                stations[newStation] = new Station(pivotPre, pivot);
                stations[pivot].pre = newStation;
                stations[pivotPre].next = newStation;

            }
            // 다음 역 출력, 다음 역 제거
            else if(command.equals("CN")){
                int pivot = Integer.parseInt(st.nextToken());

                int pivotNext = stations[pivot].next;
                int pivotNextNext = stations[pivotNext].next;

                sb.append(pivotNext).append('\n');

                // 기존 역을 제외하고 원형으로 이어지도록 처리
                stations[pivot].next = pivotNextNext;
                stations[pivotNextNext].pre = pivot;

                // 기존 역 제거
                stations[pivotNext] = null;


            }
            // 이전 역 출력, 이전 역 제거
            else{ // command.equals("CP")
                int pivot = Integer.parseInt(st.nextToken());

                int pivotPre = stations[pivot].pre;
                int pivotPrePre = stations[pivotPre].pre;

                sb.append(pivotPre).append('\n');

                // 기존 역을 제외하고 원형으로 이어지도록 처리
                stations[pivot].pre = pivotPrePre;
                stations[pivotPrePre].next = pivot;

                // 기존 역 제거
                stations[pivotPre] = null;

            }


        }

        System.out.println(sb);

    }

}
