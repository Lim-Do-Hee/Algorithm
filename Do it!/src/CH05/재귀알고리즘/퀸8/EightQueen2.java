package CH05.재귀알고리즘.퀸8;

/** 8퀸 print(■, □) */
class EightQueen2 {
    static boolean[] flag_a = new boolean[8];     // 각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15];    // 대각선 ↙에 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15];    // 대각선 ↘에 퀸이 배치했는지 체크
    static int[] pos = new int[8];    // 각 열의 퀸의 위치

    // 각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.print(flag_a[i] ? '■' : '□');
        System.out.println();
    }

    static void print2() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                System.out.printf("%s", j == pos[i] ? "■" : "□");
            System.out.println();
        }
        System.out.println();
    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false &&                    // 가로(j행)에 아직 배치하지 않았습니다.
                    flag_b[i + j] == false &&            // 대각선 ↙에 아직 배치하지 않았습니다.
                    flag_c[i - j + 7] == false) {        // 대각선 ↘에 아직 배치하지 않았습니다.
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
