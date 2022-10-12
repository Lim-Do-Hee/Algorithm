package CH05.재귀알고리즘.재귀알고리즘분석;

import java.util.Scanner;

/** Q2. 하향식, 상향식 분석 수행 */
class Recur2 {
    // 재귀 함수
    static void recur2(int n) {
        if (n > 0) {
            recur2(n - 2);
            System.out.println(n);
            recur2(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = stdIn.nextInt();

        recur2(x);
    }
}
