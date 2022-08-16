package 기본자료구조.배열;

import java.util.Arrays;
import java.util.Scanner;

/** 두 배열의 비교 */
class ArrayEqual {
    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 a의 요솟수 : ");
        int na = stdIn.nextInt();

        int[] a = new int[na];

        for (int i = 0; i < na; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();;
        }

        System.out.print("배열 b의 요솟수 : ");
        int nb = stdIn.nextInt();

        int[] b = new int[nb];

        for (int i = 0; i < nb; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();;
        }

        System.out.println("배열 a와 b는 " + (equals(a, b) ? "같습니다." : "같지 않습니다."));

    }
}

/** Q4 copy */
class Copy {
    static void copy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        int[] y = {4, 5};
        copy(x, y);
        System.out.println(Arrays.toString(x));
    }
}

/** Q5 역순으로 복사 */
class Rcopy {

    static void rcopy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++)
            a[i] = b[b.length - i - 1];
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 요솟수는 : ");
        int numa = stdIn.nextInt();		// 요솟수
        int[] a = new int[numa];			// 요솟수가 numa인 배열
        for (int i = 0; i < numa; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("b의 요솟수는  : ");
        int numb = stdIn.nextInt();		// 요솟수
        int[] b = new int[numb]; 			// 요솟수가 numb인 배열
        for (int i = 0; i < numb; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        rcopy(a, b);			// 배열 b의 모든 요소를 배열 a에 역순으로 copy

        System.out.println("배열 b의 모든 요소를 배열 a에 역순으로 copy 하였습니다.");
        for (int i = 0; i < numa; i++)
            System.out.println("a[" + i + "] = " + a[i]);
    }
}