package CH05.재귀알고리즘.재귀알고리즘분석;

import java.util.Scanner;

/** Q5 Recur3 재귀제거 */
public class Recur3 {
    static void recur3(int n) {
        IntStack nStk = new IntStack(n * 10);
        IntStack sStk = new IntStack(n * 10);
        int sw = 0;

        while (true) {
            if (n > 0) {
                nStk.push(n);
                sStk.push(sw);
                if (sw == 0)
                    n -= 1;
                else if (sw == 1) {
                    n -= 2;
                    sw = 0;
                }
                continue;
            }

            do {
                n = nStk.pop(); // 저장하고 있떤 스택의 값을 팝
                sw = sStk.pop() + 1;
                if (sw == 2) {
                    System.out.println(n);
                    if (sStk.isEmpty()) {
                        return;
                    }

                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        recur3(3);
    }
}

class Recur3A {

    //--- 메서드 recur의 비재귀적 구현 ---//
    static void recur3(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n  = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int   x = stdIn.nextInt();

        recur3(x);
    }
}

