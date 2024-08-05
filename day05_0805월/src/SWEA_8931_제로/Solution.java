package SWEA_8931_제로;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution  {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/SWEA_8931_제로/input.txt"));
		// 제로
		/*
		 * 1. 테케 개수 받기
			int T = sc.nextInt();
			2. K 받기
			int K = sc.nextInt();
			3. for 1<K
			for(int i = 0; i < K; i++) 
			4. 0이면 가장 최근에 받은 수 지우기(pop)
			if(N == 0) list.remove(list.size())
			5. 0이 아니면 push
			if(N != 0) list.add(N)
		 */		
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt(); // 테케 수
		
		// 테케 수 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++) {			
			int K = sc.nextInt();
			List<Integer> clubAccount = new ArrayList<>();
			
			// K 개수만큼 반복
			int sum = 0;
			for(int i = 0; i < K; i++) {
				int N = sc.nextInt();
				int top = clubAccount.size() - 1;
				if(N == 0) {
					// 반드시 지울 수 있는 수가 있으니 isEmpty 체크 안해도 됨
					sum -= clubAccount.get(top);
					clubAccount.remove(top); 
				} else {
					clubAccount.add(N);		
					sum += N;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, sum);
			
		}				
		
	}
	
	
}