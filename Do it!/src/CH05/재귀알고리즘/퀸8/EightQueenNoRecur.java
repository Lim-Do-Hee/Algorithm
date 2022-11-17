package CH05.재귀알고리즘.퀸8;

import CH05.재귀알고리즘.재귀알고리즘분석.IntStack;

public class EightQueenNoRecur {
    static boolean[] flag_a = new boolean[8];     // 각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15];    // 대각선 ↙에 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15];    // 대각선 ↘에 퀸이 배치했는지 체크
    static int[] pos = new int[8];    // 각 열의 퀸의 위치
    static IntStack iStk = new IntStack(30); // set 메서드 매개변수 i 스택
    static IntStack jStk = new IntStack(30); // set 메서드 j 스택
    static int j = 0; // for문 j

    // 각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    static void set(int i) {
        // 재귀에 필요한 반복문
        while (true) {
            boolean isAllCheck = true;
            for (; j < 8; j++) {
                if (!flag_a[j] &&                // 가로(j행)에 아직 배치하지 않았습니다.
                        !flag_b[i + j] &&            // 대각선 ↙에 아직 배치하지 않았습니다.
                        !flag_c[i - j + 7])          // 대각선 ↘에 아직 배치하지 않았습니다.
                {
                    pos[i] = j;                  // 퀸을 j행에 배치합니다.
                    if (i == 7) {                // 모든 열에 배치했다면
                        print();
                    } else {                     // 모든 열에 배치하지 않았다면
                        flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true; // flag_a, flag_b, falg_c 해당 index에 true
                        iStk.push(i);            // iStack에 현재 i push
                        jStk.push(j);            // jStack에 현재 j push
                        i += 1;
                        j = 0;                   // j 초기화
                        isAllCheck = false;
                        break;
                    }
                }
            }
            if (!iStk.isEmpty() && !jStk.isEmpty()) {
                if (isAllCheck) {
                    i = iStk.pop();          // iStack에서 pop
                    j = jStk.pop();
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false; // flag_a, flag_b, falg_c 해당 index에 false
                    j++;
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}

class EightQueenN {

    static boolean[] flag_a = new boolean[8];		// 각행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15];		// /대각선에 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15];		// ＼대각선에 퀸을 배치했는지 체크
    static int[] pos = new int[8];	// 각열의 퀸의 위치

    //--- 배치 상황(각열의 퀸의 위치)을 출력 ---//
    static void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.printf("%s", j == pos[i] ? "■" : "□");
            System.out.println();
        }
        System.out.println();
    }

    //--- i열의 알맞은 위치에 퀸을 배치 ---//
    static void set(int i) {
        int j;
        int[] jstk = new int[8];

        Start : while (true) {
            j = 0;
            while (true) {
                while (j < 8) {
                    if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
                        pos[i] = j;
                        if (i == 7)								// 모든 열에 배치종료
                            print();
                        else {
                            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                            jstk[i++] = j;					// i열의 행을 Push
                            continue Start;
                        }
                    }
                    j++;
                }
                if (--i == -1) return;
                j = jstk[i];									// i열의 행을 Pop
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}