package 기본알고리즘;

import java.util.Scanner;

public class SumForPos {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.println("n의 값 : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        int sum = 0;

        for (int i = 1; i <= n; i++)
            sum += i;

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}

/** Q10 b-a */
class minus {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a, b;

        System.out.println("a : ");
        a = stdIn.nextInt();

        do {
            System.out.println("b : ");
            b = stdIn.nextInt();
            System.out.println("a보다 큰 값을 입력하세요!");
        } while (b <= a);

        System.out.println("b - a = " + (b - a));

    }
}

/** Q11 자릿수 */
class Length {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        do {
            System.out.print("정숫값 : ");
            n = stdIn.nextInt();
            System.out.println("양수를 입력하세요!");
        } while (n <= 0);

        int no = 0;         // 자릿수
        while (n > 0) {
            n /= 10;         // n을 10으로 나눕니다
            no++;
        }

        System.out.println("그 수는 " + Integer.toString(n).length() + "자리입니다.");

    }
}
