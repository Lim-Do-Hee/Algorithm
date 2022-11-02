package CH05.재귀알고리즘.하노이탑;

import CH05.재귀알고리즘.재귀알고리즘분석.IntStack;

import java.util.Scanner;

/** Q7. 재귀없는 하노이 */
public class HanoiNoRecur {

    static void move(int no, int x, int y) {
        IntStack noStack = new IntStack(100);
        IntStack xStack = new IntStack(100);
        IntStack yStack = new IntStack(100);
        IntStack swStack = new IntStack(100);

        int sw = 0;

        while (true) {
            if (no > 0) {
                noStack.push(no);
                xStack.push(x);
                yStack.push(y);
                swStack.push(sw);

                no -= 1;
                y = 6 - x - y;
                continue;
            }

            if (!xStack.isEmpty() && !yStack.isEmpty()) {
                no = noStack.pop();
                x = xStack.pop();
                y = yStack.pop();
                sw = swStack.pop() + 1;

                if (sw == 1) {
                    System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");
                }

                no -= 1;
                x = 6 - x - y;
                sw = 0;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3); // 1번 기둥의 n개의 원반을 3번 기둥으로 옮김
    }
}