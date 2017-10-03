package midas;

//don't place package name.

import java.io.*;
import java.util.*;

//don't change 'Program' class name and without 'public' accessor.
class p5 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int cnt = sc.nextInt();
     Character arr[] = new Character[cnt];
     for(int i = 0; i < cnt; i++){
         arr[i] = (char)('A'+i);
     }
     
     int t = sc.nextInt();
     pair p[] = new pair[t];
     for(int i = 0; i < t; i++){
         char x = sc.next().charAt(0);
         char y = sc.next().charAt(0);
         sc.nextLine();
         
         p[i] = new pair(x, y);
     }
     
     for(int i = 0; i < t; i++) {
    	 	int idx1 = 0;
    	 	int idx2 = 0;
    	 	for(int j = 0; j < cnt; j++) {
    	 		if(arr[j] == p[i].x) {
    	 			idx1 = j;
    	 		}else if(arr[j] == p[i].y) {
    	 			idx2 = j;
    	 		}
    	 	}
    	 	if(idx1 > idx2) {
    	 		char temp = arr[idx2];
    	 		int h = 0;
    	 		for(h = idx2; h < idx1; h++) {
    	 			arr[h] = arr[h+1];
    	 		}
    	 		while(h < cnt-1) {
    	 			if(arr[h+1] < temp) {
    	 				arr[h] = arr[h+1];
        	 			h++;
    	 			}else {
    	 				break;
    	 			}
    	 		}
    	 		arr[h] = temp;
    	 		i = 0;
    	 	}
     }
     for(int i = 0; i < cnt; i++){
         System.out.print(arr[i]);
     }
 }
}
class pair{
    char x;
    char y;
    public pair(char x, char y) {
        this.x =x;
        this.y = y;
    }
}
