package nhnent;
import java.io.IOException;
import java.util.*;

public class three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int mSize = sc.nextInt();
		int [][]map = new int[mSize+2][mSize+2];
		int [][]ans = new int[mSize+2][mSize+2];
		
		for(int i = 1; i< mSize+1; i++) {
			
			for(int j = 1; j < mSize+1; j++) {
				String str = sc.next();
				char []ch = str.toCharArray();
				if(ch[0] == 48) {
					map[i][j] = 0;
				}else {
					map[i][j] = ch[0];
				}
			}
		}
		
		for(int i = 1; i< mSize+1; i++) {
			for(int j = 1; j < mSize+1; j++) {
				int minus = 0;
				int value = map[i][j];
				
				if(map[i-1][j] != 0) {
					minus = minus+1;
				}
				if(map[i][j-1] != 0) {
					minus = minus+2;
				}
				if(map[i][j+1] != 0) {
					minus = minus+4;
				}
				if(map[i+1][j] != 0) {
					minus = minus+8;
				}
				
				if(value == 0) {
					ans[i][j] = -1;
				}else {
					value = value-65;
					value = 16*value+minus;
					ans[i][j] = value;
				}
			}
		}
		/*
		for(int i = 1; i< mSize+1; i++) {
			for(int j = 1; j < mSize+1; j++) {
				System.out.printf("%2d", map[i][j]);
				if(j == mSize) {
					System.out.println();
				}else {
					System.out.print(" ");
				}
			}
		}*/
		for(int i = 1; i< mSize+1; i++) {
			for(int j = 1; j < mSize+1; j++) {
				System.out.printf("%2d", ans[i][j]);
				if(j == mSize) {
					System.out.println();
				}else {
					System.out.print(" ");
				}
			}
		}
	}

}
