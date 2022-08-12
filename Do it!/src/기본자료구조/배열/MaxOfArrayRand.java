package 기본자료구조.배열;

import java.util.Random;
import java.util.Scanner;

/** 난수 사용 배열 요솟값 */
public class MaxOfArrayRand {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");
        int num = stdIn.nextInt();

        int[] height = new int[num]; // 요솟수가 num인 배열을 생성

        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90); // 요소의 값을 난수로 결정
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}

/** Q1 사람수도 난수로 */
class MaxOfArrayRand2 {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");
        int num = rand.nextInt(100);

        int[] height = new int[num]; // 요솟수가 num인 배열을 생성

        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90); // 요소의 값을 난수로 결정
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}


