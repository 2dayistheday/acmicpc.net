package midas;

import java.util.*;

//don't change 'Program' class name and without 'public' accessor.
//don't change 'Program' class name and without 'public' accessor.
class Main {//number2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int select = sc.nextInt();
		sc.nextLine();

        int[] n = new int[select];

        while (select-- > 0) {
            String str = sc.next();

            if (!isP(str)) {
                char[] stra = str.toCharArray();
                char a = 'a';
                int cnt = 0;
                for (int i = 0; i <= str.length() / 2; i++) {
                    if (stra[i] != a) {
                        cnt = cnt + stra[i] - a;
                        stra[i] = a;
                    }
                    a++;
                }
                a--;
                int start = str.length() / 2;
                if (str.length() % 2 != 0) {
                    a--;
                    start++;
                } else {
                    a--;
                }
                for (int i = start; i < str.length(); i++) {
                    if (stra[i] != a) {
                        cnt = cnt + stra[i] - a;
                        stra[i] = a;

                    }
                    a--;
                }
                // System.out.println(stra);
                System.out.println(cnt);
            } else {
                System.out.println(0);
            }
        }
      sc.close();
    }

    public static boolean isP(String str) {
        boolean flag = true;

        int len = str.length();
        int end = len / 2;

        for (int i = 0; i < end; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}


