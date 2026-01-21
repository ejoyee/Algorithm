import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		int maxNum = 0;
		
		for (int i = 0; i < N; i++) {
			
			int tmp = Integer.parseInt(br.readLine());
			list.add(tmp);
			
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			
			if (map.get(tmp) > maxNum) maxNum = map.get(tmp);
		}
		
		Collections.sort(list);
		
		// avg
		// center
		// mode
		// range
		
		long sumNum = 0;
		int center = 0;
		int mode = 0;
		
		List<Integer> modeList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			
			sumNum += list.get(i);
			
			if (N/2 == i) center = list.get(i);
			
//			if (map.get(list.get(i)) == maxNum) modeList.add(list.get(i));
		}
		
		for (int key : map.keySet()) {
		    if (map.get(key) == maxNum) {
		    	modeList.add(key);
		    }
		}
		
		Collections.sort(modeList);
		
		if (modeList.size() <= 1) mode = modeList.get(0);
		else {mode = modeList.get(1);}
		
		int range = list.get(N-1) - list.get(0);
		
		double avg = (double) sumNum / N;
	
		sb.append(Math.round(avg)).append('\n').append(center).append('\n').append(mode).append('\n').append(range);
		
		System.out.println(sb);
		
		
	}

}
