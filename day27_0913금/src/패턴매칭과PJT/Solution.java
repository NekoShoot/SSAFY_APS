package 패턴매칭과PJT;

public class Solution {
    static String text = "ABABABACABAABABACACA";
    static String pattern = "ABABACA";

    public static void main(String[] args) {
        KMP(text, pattern);
    }

    public static void KMP(String T, String P) {
        int[] pi = getPi(P); // 점프 테이블(실패 함수 테이블) 준비
        
        int j = 0; // 패턴의 인덱스
        for(int i = 0; i < T.length(); i++) {
            // 달랐을 때
            while(j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j-1]; // 점프
            }
            
            // 같았을 때
            if(T.charAt(i) == P.charAt(j)) {
                if(j == P.length()-1) { // 패턴 끝이면
                    System.out.println((i - (P.length()-1)) + "번 인덱스 부터 시작하면 패턴 일치");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        
    } // KMP
    
    // pi[]: 패턴 P를 i 인덱스까지 잘라서(부분문자열)
    // 접두사와 접미사가 일치하는 최대 길이를 담을 배열
    public static int[] getPi(String P) {
        int[] pi = new int[P.length()];

        int j = 0; // j인덱스까지는 접두사와 접미사가 같음
        for(int i = 1; i < P.length(); i++) {
            // i와 j가 가리키는 값이 다르면
            // j의 포인터가 조건을 만족하지 않을때까지 내려감
            while(j > 0 && P.charAt(i) != P.charAt(j))
                j = pi[j-1];

            // i와 j가 가리키는 값이 같다면
            if(P.charAt(i) == P.charAt(j)) {
                pi[i] = ++j;
            }
        }
        
        return pi;
    }

}