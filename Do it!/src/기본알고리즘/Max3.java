package 기본알고리즘;

import java.util.Scanner;

/** 세 개의 최댓값 1-1 */
public class Max3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.println("a의 값 : "); int a = stdIn.nextInt();
        System.out.println("b의 값 : "); int b = stdIn.nextInt();
        System.out.println("c의 값 : "); int c = stdIn.nextInt();
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("최댓값은 " + max + "입니다.");
    }
}

/** 세 개의 최댓값 1-2 */
class Max3m {
    // a, b, c의 최댓값을 구하여 반환합니다.
    static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        return max;
    }

    public static void main(String[] args) {
        System.out.println("max(1, 2, 3) = " + max3(1, 2, 3));
        System.out.println("max(2, 3, 1) = " + max3(2, 3, 1));
    }
}
