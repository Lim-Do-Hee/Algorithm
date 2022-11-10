package CH05.재귀알고리즘.퀸8;

public class EightQueenNoRecur {
    static boolean[] flag_a = new boolean[8];     // 각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15];    // 대각선 ↙에 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15];    // 대각선 ↘에 퀸이 배치했는지 체크
    static int[] pos = new int[8];    // 각 열의 퀸의 위치

    // 각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    static void set(int i) {
        // 재귀에 필요한 반복문
        while (true) {

        }
        // 가로(j행)에 아직 배치하지 않았습니다.
        // 대각선 ↙에 아직 배치하지 않았습니다.
        // 대각선 ↘에 아직 배치하지 않았습니다.
        // 퀸을 j행에 배치합니다.
        // 모든 열에 배치했다면
        // iStack에서 pop
        // flag_a, flag_b, falg_c 해당 index에 false
        // 모든 열에 배치하지 않았다면
        // flag_a, flag_b, falg_c 해당 index에 true
        // iStack에 현재 i push

    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set2(int i) {
        for (int j = 0; j < 8; j++) {
            if (!flag_a[j] &&                            // 가로(j행)에 아직 배치하지 않았습니다.
                !flag_b[i + j] &&                        // 대각선 ↙에 아직 배치하지 않았습니다.
                !flag_c[i - j + 7]) {                    // 대각선 ↘에 아직 배치하지 않았습니다.
                pos[i] = j;                              // 퀸을 j행에 배치합니다.
                if (i == 7)                              // 모든 열에 배치했다면
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
