package CH02.기본자료구조.배열;

import java.util.Arrays;
import java.util.Scanner;

/** 배열 요소를 역순으로 정렬하기 */
class ReverseArray {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        // 교환 횟수 = 요소 개수 / 2
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();;
         }

        reverse(x);

        System.out.println("요소를 역순으로 정렬했습니다.");
        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}

/** Q2 역순 정렬 과정 */
class ReverseArrayProcess {
    static void swap(int[] array, int idx1, int idx2) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n[" + idx1 + "]과(와) " + "a[" + idx2 + "]를 교환합니다.");
        int t = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = t;
    }

    static void reverse(int[] array) {
        // 주석과 같이 toString으로 가능
//        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
//            System.out.println("a[" + i + "]와 a[" + (array.length - i - 1) + "]을 교환합니다.");
            swap(array, i, array.length - i - 1);
//            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();;
        }

        reverse(x);

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println("\n역순 정렬을 마쳤습니다.");
    }
}

/** Q3 배열의 모든 요소의 합 */
class SumOf {
    static int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();;
        }

        System.out.println(sumOf(x));
    }
}
