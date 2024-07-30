package SWEA_2068_최대수구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result = 0;
             
            for(int i = 0; i < 10; i++) {
                int tmp = sc.nextInt();
                if(tmp > result) result = tmp;             
            }
             
            System.out.printf("#%d %s\n", test_case, result);
        }
	}
}