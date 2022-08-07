package 기본알고리즘;

import java.util.Scanner;

/** 직각 이등변 삼각형 */
public class TriangleLB {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");

        do {
            System.out.print("몇 단 삼각형입니까? : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/** Q15 직각 이등변 삼각형(왼쪽 아래, 왼쪽 위, 오른쪽 위, 오른쪽 아래) */
class Triangle {
    /** 왼쪽 아래 */
    static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    /** 왼쪽 위 */
    static void triangleLU(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print('*');
            System.out.println();
        }
    }

    /** 오른쪽 위 */
    static void triangleRU(int n) {

//        for (int i = n; i >= 1; i--)
//            System.out.print(" " * (n - i) + '*');
//        for (int i = n; i >= 1; i--) {
//            for (int j = 1; j <= i; j++)
//                System.out.print();
//            System.out.println();
//        }
    }



    public static void main(String[] args) {
        triangleLB(5);
        triangleLU(5);
        triangleRU(5);
    }
}
