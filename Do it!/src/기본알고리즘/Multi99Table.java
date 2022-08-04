package 기본알고리즘;

/** 곱셈표 */
public class Multi99Table {
    public static void main(String[] args) {
        System.out.println("----- 곱셈표 -----");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++)
                System.out.printf("%3d", i * j);
            System.out.println();
        }
    }
}

/** %d의 경우 정수 형식으로 출력을 의미
 * %3d의 경우 3자리로 지정, 오른쪽 정렬(남는 자리는 공백)
 * /

 /** Q12 곱셈표 */
class Multiple99Table {
    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}