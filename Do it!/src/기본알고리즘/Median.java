package 기본알고리즘;

import java.util.Scanner;
/** 세 값의 중앙값 */
public class Median {
    static int med3(int a, int b, int c) {
        if (a >= b)
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.println("b의 값 : ");
        int b = stdIn.nextInt();
        System.out.println("c의 값 : ");
        int c = stdIn.nextInt();

        System.out.println("중앙값은 " + med3(a, b, c) + "입니다.");

    }
}

/** Q4 세 값의 대소관계 13종류 중앙값 */
class Median13 {
    static int median13(int a, int b, int c) {
        if (a >= b)
            if (b >= c)
                return b;
            else if (c >= a)
                return a;
            else
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }
}

/** Q5 med3에 비해 효율이 떨어지는 이유 */
/** or로 되어 있어 조건을 다 봐야 한다.
 *   처음 if 문의 판단
 * 　if ((b >= a && c<= a) || (b <= a && c >= a)
 *  에 주목합니다.
 *   여기서 b >= a 및 b <= a의 판단을 뒤집은 판단
 *   (실질적으로 동일한 판단)이, 계속하여  else 이후에서
 * 　　 else if ((a > b && c < b) || (b <= a && c > b)
 *   로 수행됩니다. 즉, 처음 if가 성립하지 않는 경우,
 *   2번째 if에서도 (실질적으로 ) 같은 판단을 수행하므로,
 *   효율이 나빠집니다.
 * */

class badMed3 {
    static int badMed3(int a, int b, int c) {
        if ((b >= a && c <= a) || ((b <= a && c >= a)))
            return a;
        else if ((a > b && c < b) || (a < b && c > b))
            return b;
        return c;
    }
}