package CH05.재귀알고리즘.재귀알고리즘분석;

/** */
public class Recur3 {
    static void recur3(int n) {
        IntStack nStk = new IntStack(n);
//        IntStack sStk = new IntStack(n);
        int sw = 0;

        while (true) {
            if (n > 0) {
                nStk.push(n);
                if (sw == 0)
                    n -= 1;
                else if (sw == 1) {
                    n -= 2;
                    sw = 0;
                }
                continue;
            }

            if (!nStk.isEmpty()) { // 스택이 비어있지 않다면
                sw += 1;
                n = nStk.pop(); // 저장하고 있떤 스택의 값을 팝
                if (sw == 2)
                    System.out.println();
                else
                    nStk.push(n);
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        recur3(3);
    }
}
