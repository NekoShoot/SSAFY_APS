package SWEA_1215_회문1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_1215_회문1/input.txt"));
		Scanner sc = new Scanner(System.in);		
		// 테케 개수 10만큼 반복
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 단어를 이루는 글자 개수
			
			// 글자들을 저장할 배열 생성
			char[][] wordBoard = new char[8][8];
			
			// 2중 반복으로 2차원 배열에 각 값 저장
			for(int i = 0; i < 8; i++) {
				String line = sc.next();	
				for(int j = 0; j < 8; j++) {
					wordBoard[i][j] = line.charAt(j);					
					
				}	
			}
			
			// 개수 저장할 변수 생성
			int cnt = 0;
			
			// 3중 반복으로 각각의 배열에서 N길이 만큼 탐색(가로,세로)
			for(int i = 0; i < 8; i++) {				
				for(int j = 0; j < 8; j++) {
					String rowStr = "";
					String colStr = "";
					
					// N만큼의 길이 가로 세로 더해서 단어 만들기
					for(int m = 0; m < N; m++) {
						// 경계 체크 로직
						if(j+m < 8)	rowStr += wordBoard[i][j+m];
						if(i+m < 8) colStr += wordBoard[i+m][j];
					}									
					
					// 회문이면 cnt++					
					if(isReverseSame(rowStr, N)) cnt++;
					if(isReverseSame(colStr, N)) cnt++;


				}
			}
			
			System.out.printf("#%d %d\n", test_case, cnt);
			
		}		

	}
	
	// 회문인지 판별해주는 메소드
	static boolean isReverseSame(String word, int N) {
		if(word.length() != N) return false;
		String reversed = "";
						
		for(int i = word.length()-1; i >= 0; i--) {
			// 거꾸로 더해서 만들기
			reversed += word.charAt(i);		
		}
		
		if(word.equals(reversed)) return true;
			else return false;
		
	}
	
}