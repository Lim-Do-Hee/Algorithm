package CH05.재귀알고리즘.재귀알고리즘분석;

import java.util.Scanner;

/** 재귀함수 이해하기 */
class Recur {
    // 재귀 함수
    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    // 꼬리 재귀를 제거
    static void recurX1(int n) {
        while (n > 0) {
            recurX1(n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }

    // 꼬리 재귀를 제거
    static void recurX2(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n); // n의 값을 푸시
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) { // 스택이 비어있지 않다면
                n = s.pop(); // 저장하고 있떤 스택의 값을 팝
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = stdIn.nextInt();

        recurX2(x);
    }
}
