package CH05.재귀알고리즘.재귀의기본;
import java.util.Scanner;

/** 팩토리얼을 재귀적으로 구현 */
public class Factorial {
    // 양의 정수 n의 팩토리얼을 반환합니다.
    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}

/** Q1. 재귀 없이 factorial */
class FactorialNoRecur {
    static int factorialNoRecur(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorialNoRecur(x) + "입니다.");
    }
}
