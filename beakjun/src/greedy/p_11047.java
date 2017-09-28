package greedy;

import java.util.*;


public class p_11047 {
	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/11047
		//again 2017-09-29
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = sc.nextInt();
		sc.nextLine();
		
		int values[] = new int[num];
		int min = total;
		for(int i = 0; i < num; i++) {
			int val = sc.nextInt();
			if(i > 0 & val <= total) {
				int dd = val/values[i-1];
				int div = total/val;
				
				min = min - (dd*div) + div;
			}
			values[i] = val;
		}
		System.out.println(min);
	}
}
