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
                System.out.print('*');
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

    static void triangleLU2(int n) {
        for (int i = 1; i <= n; i++) {            // i 행( i = 1, 2, ... , n )
            for (int j = 1; j <= n - i + 1; j++)         // n - i + 1 개의 '*'을  출력
                System.out.print('*');
            System.out.println();                  // 줄바꿈
        }
    }

    /** 오른쪽 위 */
    static void triangleRU(int n) {

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++)
                System.out.print(j > n - i ? '*' : ' ');
            System.out.println();
        }
    }

    static void triangleRU2(int n) {
        for (int i = 1; i <= n; i++) {            // i 행( i = 1, 2, ... , n )
            for (int j = 1; j <= i - 1; j++)         // i - 1 개의 ' '을  출력
                System.out.print(' ');
            for (int j = 1; j <= n - i + 1; j++)   // n - i + 1 개의 '*'을  출력
                System.out.print('*');
            System.out.println();                  // 줄바꿈
        }
    }

    /** 오른쪽 아래 */
    static void triangleRB(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(j > n - i ? '*' : ' ');
            System.out.println();
        }
    }

    static void triangleRB2(int n) {
        for (int i = 1; i <= n; i++) {            // i 행( i = 1, 2, ... , n )
            for (int j = 1; j <= n - i; j++)         // n - i 개의 ' '을  출력
                System.out.print(' ');
            for (int j = 1; j <= i; j++)            // i 개의 '*'을  출력
                System.out.print('*');
            System.out.println();                  // 줄바꿈
        }
    }

    public static void main(String[] args) {
        triangleLB(5);
        System.out.println();
        triangleLU(5);
        System.out.println();
        triangleRU(5);
        System.out.println();
        triangleRB(5);
    }
}

/** Q16 n단의 피라미드 */
class Spira {
    static void spira(int n) {

        int range = (n - 1) * 2 + 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++)
                System.out.print(i > Math.abs(n - j) ? '*' : ' ');
            System.out.println();
        }
    }

    static void spira2(int n) {
        for (int i = 1; i <= n; i++) {					// i 행( i = 1, 2, ... , n )
            for (int j = 1; j <= n - i; j++)			// n - i 개의 ' ' 을 출력
                System.out.print(' ');
            for (int j = 1; j <= (i-1)*2+1; j++)	// (i - 1) * 2 + 1 개의 '*' 을 출력
                System.out.print('*');
            System.out.println();									// 줄바꿈
        }
    }

    public static void main(String[] args) {
        spira(4);
    }
}

/** Q17 n단의 숫자 피라미드 */
class Npira {
    static void npira(int n) {

        int range = (n - 1) * 2 + 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++)
                if (i > Math.abs(n - j))
                    System.out.print(i);
                else
                    System.out.print(' ');
            System.out.println();
        }
    }

    static void npira2(int n) {
        for (int i = 1; i <= n; i++) {					// i 행( i = 1, 2, ... , n )
            for (int j = 1; j <= n - i; j++)			// n - i 개의 ' ' 을 출력
                System.out.print(' ');
            for (int j = 1; j <= (i-1)*2+1; j++)	// (i - 1) * 2 + 1개의 '*' 을 출력
                System.out.print(i % 10);
            System.out.println();									// 줄바꿈
        }
    }

    public static void main(String[] args) {
        npira(4);
    }
}
