import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
	private static int N, M;
	private static int[] arr;
	private static int[] result;
	private static boolean[] visited;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		String strr = br.readLine();
		st = new StringTokenizer(strr);
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int depth) throws IOException {
		
		if(depth == M) {
			for(int re: result) {
				bw.write(re + " ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				int d = 0;
				if(depth > 0) {
					d = result[depth-1];
				}
				
				if(d < arr[i]) {
					
					visited[i] = true;
					result[depth] = arr[i];
					
					dfs(depth + 1);
					
					visited[i] = false;
				}
			}
		}
	}
}