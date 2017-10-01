package midas;

import java.io.*;
import java.util.*;

public class p2 {//tsp 알고리즘 .. number4(수정중)
	public static int[][] W;
	public static int[][] dp;
    public static int N;
    public static final int INF = 1000000000;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        W = new int[N+1][N+1];
        dp = new int[N + 1][1 << N];
        //visited = new boolean[n+1];
        
        while(m-- > 0){
            int v = sc.nextInt();
            int w = sc.nextInt();
            int val = sc.nextInt();
            sc.nextLine();
            W[v][w] = val;
            W[w][v] = val;
        }
        //dijkstra(1);
        
        for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int start = 1;
		System.out.println(getShortestPath(start, 1));
    }
	public static int getShortestPath(int current, int visited) {
		
		// 모든 정점을 다 들른 경우
		if (visited == (1 << N) - 1)
			return W[current][1];

		// 이미 들렀던 경로이므로 바로 return
		if (dp[current][visited] >= 0)
			return dp[current][visited];

		int ret = INF;

		// 집합에서 다음에 올 원소를 고르자!
		for (int i = 1; i <= N; i++) {
			int next = i;

			if ((visited & (1 << (next - 1))) != 0) // 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				continue;
			
			if(W[current][next] == 0) // 0은 경로가 없으므로 pass
				continue;
			
			int temp = W[current][next] + getShortestPath(next, visited + (1 << (next - 1)));
			ret = Math.min(ret, temp);
		}

		return dp[current][visited] = ret;

	}
    
}
