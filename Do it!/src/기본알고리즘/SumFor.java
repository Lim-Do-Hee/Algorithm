package 기본알고리즘;

import java.util.Scanner;

public class SumFor {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.println("n의 깂 : ");
        int n = stdIn.nextInt();

        int sum = 0;

        for (int i = 0; i <= n; i++) {
            sum += i;
        }

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");

    }
}

/** Q7 1 ~ 7 합 */
class SumFor7 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 7; i++) {
            sum += i;
        }

        System.out.println("1 + 2 + 3 + 4 + 5 + 6 + 7 = " + sum);
    }
}

/** Q8 가우스의 덧셈 */
class Gauss {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();

        int halfN = n / 2;
        int sum = 0;

        // n이 짝수
        if (n % 2 == 0)
            sum = (1 + n) * halfN;
        else
            sum = (1 + n) * (halfN) + (halfN + 1);

        int sum2 = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0);

        System.out.println(sum);
    }
}

/** Q9 a, b를 포함하여 그 사의 모든 정수의 합 */
class SumOf {
    static int sumOf(int a, int b) {

        int sum = 0;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (; a <= b; a++) {
            sum += a;
        }

        return sum;
    }

    static int sumOf2(int a, int b) {
        int min;		// a, b의 작은 쪽의 값
        int max;		// a, b의 큰 쪽의 값

        if (a < b) {
            min = a;  max = b;
        } else {
            min = b;  max = a;
        }

        int sum = 0;		// 총합
        for (int i = min; i <= max; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOf(3, 5));
        System.out.println(sumOf(6, 4));
    }
}