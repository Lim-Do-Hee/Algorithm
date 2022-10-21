package CH05.재귀알고리즘.하노이탑;

import CH05.재귀알고리즘.재귀알고리즘분석.IntStack;

public class HanoiNoRecur {

    static void move(int no, int x, int y) {
        IntStack xStack = new IntStack(100);
        IntStack yStack = new IntStack(100);
        while (true) {
            if (no > 1) {
                no -= 1;
                xStack.push(x);
                yStack.push(6 - x - y);
                continue;
            }

            x = xStack.pop();
            y = yStack.pop();
            System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");
            x = 6 - x - y;

        }
    }
}