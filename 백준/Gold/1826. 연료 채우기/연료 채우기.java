import java.util.*;
import java.io.*;


// 다익스트라 알고리즘과 매우 유사
// 다익스트라 : 시작점에서 도착점까지 최단 거리, 연료 채우기 : 시작점에서 도착점까지 최소 주유
// 그리디 + 우선순위큐 (dfs 완탐은 시간초과)
// 1. 현재 연료로 도달 가능한 주유소를 모두 후보로 삼기 (우선순위 큐에 삽입)
// 2. 우선순위 큐 속 가장 연료를 많이 얻을 수 있는 주유소 방문
    // 도달 가능한 거리 업데이트
// 3. 반복하다 갈 수 있는 주유소가 하나도 없는 경우 -1 반환
// 4. 도달 가능한 거리에 도착 지점이 포함되는 경우 방문한 주유소 개수 반환

public class Main {

    static int n; // 정류장 총 개수
    static int remain; // 현재 연료 (현재 갈 수 있는 최대 거리)
    static int end; // 도착 지점 (마을)
    static Station[] stations; // 정류장 정보

    public static class Station implements Comparable<Station>{
        int dist;
        int fuel;
        public Station(int dist, int fuel){
           this.dist = dist;
           this.fuel = fuel;
        }
        
        @Override
        public int compareTo(Station o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {

        
        // 1. 주어진 정보 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        stations = new Station[n];
        
        StringTokenizer st;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        end = Integer.parseInt(st.nextToken());
        remain = Integer.parseInt(st.nextToken());
        
        // 2. 정류장 정보 거리 순으로 오름차순 정렬
        Arrays.sort(stations);

        // 3. 주유소 방문 시도 (그리디로 연료를 가장 많이 충전할 수 있는 주유소 우선 방문)
        int ans = 0; // 정답 (방문한 주유소 개수)
        int cur = 0; // 현재까지 방문한 주유소 위치
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(remain < end){

            // 현재 연료로 갈 수 있는 주유소를 pq에 삽입
            while(cur < n && stations[cur].dist <= remain){
                // 방문 가능한 주유소의 연료 값들을 pq에 삽입
                pq.add(stations[cur].fuel);
                cur++;
            }

            // 방문 가능한 주유소가 없는 경우 -1 출력
            if(pq.isEmpty()){
                System.out.println(-1);
                return;
            }

            // 가장 많은 연료를 얻을 수 있는 주유소를 실제 방문
            remain += pq.poll();
            ans++;
        }

        System.out.println(ans);




    }
}