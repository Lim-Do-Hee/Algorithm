package CH01.기본알고리즘;

import java.util.Scanner;

/** 곱셈표 */
public class Multi99Table {
    public static void main(String[] args) {
        System.out.println("----- 곱셈표 -----");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++)
                System.out.printf("%3d", i * j);
            System.out.println();
        }
    }
}

/** %d의 경우 정수 형식으로 출력을 의미
 * %3d의 경우 3자리로 지정, 오른쪽 정렬(남는 자리는 공백)
 * /

 /** Q12 곱셈표 */
class Multiple99Table {
    public static void main(String[] args) {

        System.out.printf("%3s", "|");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);
//        System.out.println();
        System.out.println("\n---+---------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}

/** Q13 덧셈 출력 */
class AddTable {
    public static void main(String[] args) {

        System.out.printf("%3s", "|");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);
        System.out.println("\n---+---------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i + j);
            }
            System.out.println();
        }
    }
}

/** Q14 정사각형 */
class Square {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("사각형을 출력합니다.");
        System.out.print("단수 : ");

        do {
            System.out.print("단수 : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}