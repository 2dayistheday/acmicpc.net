package beakjun;

import java.util.*;
public class main_2 {
	
	public static void main(String[] args) {
		String[] arrStr = {"toast", "standard", "bank", "display", "book"};
		//a e i o u
		int v2 = 0;
		int not3 = 0;
		
		for(int i = 0; i < arrStr.length; i++) {
			int v = 0;
			int n = 0;
			for(int j = 0; j < arrStr[i].length(); j++) {
				char ch = arrStr[i].charAt(j);
				if(ch == 'a' | ch == 'e' | ch == 'i' | ch == 'o' | ch == 'u') {
					v++;
					if(n < 3) {
						n = 0;
					}
				}else {
					n++;
					if(v < 2) {
						v = 0;
					}
				}
			}
			if(v > 1) {
				v2++;
			}
			if(n > 2) {
				not3++;
			}
		}
		System.out.println(v2 + " "+ not3);
	}
}
