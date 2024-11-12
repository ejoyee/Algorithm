import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
	
	static String X;
	static int Xnum;
	static Integer[] arr;
	
	static Integer[] mixed;
	static boolean[] isSelected;
	
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = br.readLine();
		Xnum = Integer.parseInt(X);
		
		arr = new Integer[X.length()];
		mixed = new Integer[X.length()];
		isSelected = new boolean[X.length()];
		for (int i = 0; i < X.length(); i++) {
			arr[i] = X.charAt(i) - '0';
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		String tmp = "";
		for (int i = 0; i < arr.length; i++) {
			tmp += arr[i].toString();
		}
		
		if (X.equals(tmp)) {
			System.out.println(0);
		}
		else {
			Arrays.sort(arr);
			mix(0);
			System.out.println(result);
		}
	}
	
	static void mix (int cnt) {
		
		if (result != -1) return;
		
		if (cnt == X.length()) {
			String tmp = "";
			for (int i = 0; i < cnt; i++) {
				tmp += mixed[i].toString();
			}
			int num = Integer.parseInt(tmp);
			
			if (num > Xnum) {
				result = num;
				return;
			}
		}
		
		for (int i = 0; i < X.length(); i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			mixed[cnt] = arr[i];
			mix(cnt + 1);
			isSelected[i] = false;
		}
	}

}