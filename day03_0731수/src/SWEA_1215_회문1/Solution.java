package SWEA_1215_회문1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1215_회문1/input.txt"));
		Scanner sc = new Scanner(System.in);		
		// 테케 개수 10만큼 반복
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 단어를 이루는 글자 개수
			
			char[][] worldBoard = new char[8][8];
			
			for(int i = 0; i < 8; i++) {
				String line = sc.next();	
				for(int j = 0; j < 8; j++) {
					worldBoard[i][j] = line.charAt(j);
					
					
				}				 
				
				
			}
						
			
			System.out.println(Arrays.deepToString(worldBoard));
		}
		

	}
}