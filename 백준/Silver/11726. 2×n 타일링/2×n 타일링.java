import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
       
        int[] dp = new int[1001];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<N+1; i++) {
        	dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        
        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }
}