import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	static public class Node {
		Map<Character, Node> child = new HashMap<>();
		int isEnd = 0;
	}
	
	static public class Trie {
		Node root = new Node();
		
		public void insert(String str) {
			Node node = root;
			boolean endFlag = false;
			
			for (int i = 0; i < str.length(); i++) {
				// 해당 자식 노드 존재할 때 
				if (node.child.get(str.charAt(i)) != null) {
					node = node.child.get(str.charAt(i));
					sb.append(str.charAt(i));
				}
				
				// 해당 자식 노드 없을 때
				else {
					Node next = new Node();
					node.child.put(str.charAt(i), next);
					node = next;
					
					if(!endFlag) {
						sb.append(str.charAt(i));
						endFlag = true;
					}
				}
			}
			
			if (node.isEnd == 0) {
				node.isEnd = 1;
			}
			else {
				node.isEnd += 1;
				sb.append(node.isEnd);
			}
		}
	}
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}
}
