package greedy;

import java.util.*;

public class p_11047 {
	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/11047
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int total = sc.nextInt();
		int size = 0;
		int min = total;
		
		int value[] = new int[t];
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			if(n < total & i != 0) {
				int div = total / n;
				int dd = n/value[i-1];
				min = min - (dd*div) + div;
			}else {
				
			}
			value[i] = n;
		}
		System.out.println(min);
		
	}

}
