package dfs_and_bfs;

import java.util.Scanner;

public class p_10451 {
	public static int mat[];
	public static boolean vistied[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			
			mat = new int[n+2];
			vistied = new boolean[n+2];
			
			for(int i = 1; i < n+1; i++) {
				int v = sc.nextInt();
				mat[i] = v;
			}
			int cnt = 0;
			for(int i = 1; i < n+1; i++) {
				if(!vistied[i]) {
					if(i == dfs(i)){
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static int dfs(int x) {
		vistied[x] = true;
		
		int next = mat[x];
		if(!vistied[next]) {
			return dfs(next);
		}else {
			return next;
		}
	}
}
