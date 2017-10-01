package beakjun;

import java.util.Scanner;

public class p_11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int arr[][] = new int[t][2];
		int sort[][] = new int[t][2];
		
		for(int i = 0; i < t; i++) {
			for(int j = 0; j <2; j++) {
				int n = sc.nextInt();
				arr[i][j] = n;
				
				int prio = 1;
				for(int e = 0; e < i; e++) {
					if(arr[e][j] < n) {
						prio++;
					}else if(arr[e][j] == n){
						
					}else {
						sort[e][j]++;
					}
				}
				sort[i][j] = prio;
			}
		}
		
		for(int i = 0; i < t; i++) {
			int minIdx = 0;
			for(int j = 1; j < t; j++) {
				if(sort[minIdx][0] > sort[j][0]) {
					minIdx = j;
				}else if(sort[minIdx][0] == sort[j][0]){
					minIdx = (sort[minIdx][1] < sort[j][1])? minIdx : j;
				}
			}
			System.out.println(arr[minIdx][0] + " "+arr[minIdx][1]);
			sort[minIdx][0] = 100001;
			sort[minIdx][1] = 100001;
		}//시간초과....
	}
}
