package CH05.재귀알고리즘.재귀알고리즘분석;

/** */
public class Recur3 {
    static void recur3(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n -= 1;
                continue;
            }
            if (!s.isEmpty()) { // 스택이 비어있지 않다면
                int m;
                m = n = s.pop(); // 저장하고 있떤 스택의 값을 팝
                System.out.println(n);
                continue;
            }

            break;
        }
    }

    public static void main(String[] args) {
        recur3(3);
    }
}
