package nhnent;
import java.awt.print.Printable;
import java.lang.reflect.Array;
import java.util.*;

public class four {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//원래는 5번째 문제이지만,..
		//섬탈출 문제
		//우선순위(성별, 나이, 조건)
		//사람수
		//사람 별 특징
		Scanner sc = new Scanner(System.in);
		int[] prio = new int[3];
		int perNum;
		
		String []line = sc.nextLine().split(" ");
		for(int i = 0; i < 3; i++) {
			prio[i] = Integer.parseInt(line[i]);
		}
		perNum = sc.nextInt();
		sc.nextLine();
		
		String[][] person = new String[perNum][3];
		int[][] prioPer = new int[perNum][3];
		
		for(int i = 0; i < perNum; i++) {
			String []perOne = sc.nextLine().split(" ");
			person[i] = perOne;
			//성별
			if(perOne[0].equals("M")) {
				prioPer[i][0] = 1;
			}else if(perOne[0].equals("F")) {
				prioPer[i][0] = 2;
			}
			//나이
			int age = Integer.parseInt(perOne[1]);
			int agePrio = 1;
			if(age <= 7) {
				for(int j = 0; j < i; j++) {
					if(Integer.parseInt(person[j][1]) < age) {
						prioPer[j][1]++;
					}else {
						agePrio++;
					}
				}
				prioPer[i][1] = agePrio;
			}else{
				for(int j = 0; j < i; j++) {
					if(Integer.parseInt(person[j][1]) <= 7) {
						prioPer[j][1]++;
					}else if(Integer.parseInt(person[j][1]) < age) {
						agePrio++;
					}else {
						prioPer[j][1]++;
					}
				}
				prioPer[i][1] = agePrio;
			}
			//조건
			if(perOne.length == 3) {
				String iff = perOne[2];
				if(iff.equals("PW")) {
					prioPer[i][2] = 3;
				}else if(iff.equals("DP")) {
					prioPer[i][2] = 2;
				}else if(iff.equals("P")) {
					prioPer[i][2] = 1;
				}
			}
		}
		
		for(int i = 0; i < perNum; i++) {
			System.out.println(prioPer[i][0] + " " + prioPer[i][1] + " " + prioPer[i][2]);
		}
		
		for(int i = 0; i < perNum; i++) {
		
			int prion = prio[0]-1;
			int max = 0;
			
			for(int j = 1; j < perNum; j++) {
				if(prioPer[max][prion] < prioPer[j][prion]) {
					max = j;
				}else if(prioPer[max][prion] == prioPer[j][prion]) {
					prion = prio[1]-1;
					
					if(prioPer[max][prion] < prioPer[j][prion]) {
						max = j;
					}else if(prioPer[max][prion] == prioPer[j][prion]) {
						prion = prio[2]-1;
						
						if(prioPer[max][prion] < prioPer[j][prion]) {
							max = j;
						}
					}
				}
			}
			if(person[max].length == 3) {
				System.out.println(person[max][0]+" " + person[max][1]+" " + person[max][2]);
			}else {
				System.out.println(person[max][0]+" " + person[max][1]);
			}
			prioPer[max][0] = 0;
			prioPer[max][1] = 0;
			prioPer[max][2] = 0;
		}
		
	}

}
