import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

    static int N, map[][], white, green;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String st = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }
        cut(0, 0, N);
        
        System.out.println(sb);
    }

    static void cut(int r, int c, int size) {
    	
    	
    	
    	// 주어진 공간이 모두 같은 색으로 이루어졌는지 체크
        int sum = 0;
        for(int i =  r, rEnd = r+size; i < rEnd; i++) {
            for(int j = c, cEnd = c+size; j < cEnd; j++) {
                sum+=map[i][j];
            }
        }
        
        if (sum == 0) {
        	sb.append('0');
        }
        else if(sum == size * size) {
        	sb.append('1');
        }
        else {
        	sb.append('(');
        	//같은색으로 이루어져있지 않으면 4분할
        	int half = size/2;
        	cut(r, c, half);
        	cut(r, c+half, half);
        	cut(r+half, c, half);
        	cut(r+half, c+half, half);
        	sb.append(')');
        }
        
        
    }
    
    
}