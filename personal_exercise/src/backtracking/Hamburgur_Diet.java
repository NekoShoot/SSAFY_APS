package backtracking;

import java.util.*;
import java.io.*;

public class Hamburgur_Diet {
	static int N, L; //N 재료의 개수, L 제한 칼로리
	static int[] cals;
	static int[] scores;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			cals = new int[N];
			scores = new int[N];
			
			for(int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			answer = 0; // 정답 초기화
			
			makeBurger(0, 0, 0);
			System.out.println(answer);
			
		}
	}
	
	// 중간에 계산한 결과들을 들고 다닐 것(sumScore, sumCal)
	static void makeBurger(int idx, int sumScore, int sumCal) {
		if(sumCal > L) return; // <- backtracking의 가지치기(칼로리 중에 음수가 없음)		
		
		// 기저 조건
		if(idx == N) { // 모든 재료를 고려한 경우			
			// 베스트인지 아닌지 판단
			if(answer < sumScore) {
				answer = sumScore;
				return;
			}
			
		}
		
		// 재귀 부분
		// idx에 해당하는 재료를 사용한 경우
		makeBurger(idx+1, sumScore+scores[idx], sumCal+cals[idx]);
		// idx에 해당하는 재료를 사용하지 않은 경우
		makeBurger(idx+1, sumScore, sumCal);
	}
}
