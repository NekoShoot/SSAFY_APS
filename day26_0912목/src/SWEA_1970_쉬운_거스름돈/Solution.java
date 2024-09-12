package SWEA_1970_쉬운_거스름돈;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1970_쉬운_거스름돈/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int N = sc.nextInt();			
						
			int change = N;
			int[] bills = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 }; // idx 0이 5만원 -> 7이 10원			
					
			// 거스름돈 계산(돈의 종류가 8개)
			for(int i = 0; i < 8; i++) {
				int cnt = change / bills[i]; // 몫 저장
				change = change % bills[i];
				
				if(i < 7) {
					sb.append(cnt);
					sb.append(" ");
				}
				else sb.append(cnt);
			}
			
			sb.append("\n");
			String result = sb.toString();
			System.out.print(result);			
			
			sb.delete(0, sb.length());
		} // T
		
	} // main
}