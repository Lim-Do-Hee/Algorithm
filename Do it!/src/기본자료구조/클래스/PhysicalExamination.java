package 기본자료구조.클래스;

import java.util.Scanner;

/** 신체검사 데이터용 클래스 배열에서 평균 키와 시력의 분포를 구함 */
public class PhysicalExamination {

    static final int VMAX = 21; // 시력 분포(0.0에서 0.1 단위로 21개)

    static class PhyscData {
        String name; // 이름
        int height; // 키
        double vision; // 시력

        // 생성자
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    // 키의 평균값을 구함
    static double aveHeight(PhyscData[] dat) {
        double sum = 0;

        for (int i = 0; i < dat.length; i++)
            sum += dat[i].height;

        return sum / dat.length;
    }

    // 시력 분포를 구함
    static void distVision(PhyscData[] dat, int[] dist) {
        int i = 0;

        dist[i] = 0;

        for (i = 0; i < dat.length; i++)
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
                dist[(int)(dat[i].vision * 10)]++;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {
            new PhyscData("박현규", 162, 0.3),
            new PhyscData("함진아", 173, 0.7),
            new PhyscData("최윤미", 175, 2.0),
            new PhyscData("홍연의", 171, 1.5),
            new PhyscData("이수진", 168, 0.4),
            new PhyscData("김영준", 174, 1.2),
            new PhyscData("박용규", 169, 0.8),
        };

        int[] vdist = new int[VMAX]; // 시력분포

        System.out.println("- 신체검사 리스트 -");
        System.out.println("이름       키   시력");
        System.out.println("--------------------");

        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

        System.out.printf("\n평균 키 : %5.1fcm\n", aveHeight(x));

        distVision(x, vdist); // 시력 분포를 구함

        System.out.println("\n시력 분포");
        for (int i = 0; i < VMAX; i++)
            System.out.printf("%3.1f~ : %2d명\n", i / 10.0, vdist[i]);
    }
}

/** Q10 시력분포 *로 표시 */
class PhysicalExamination2 {

    static final int VMAX = 21; // 시력 분포(0.0에서 0.1 단위로 21개)

    static class PhyscData {
        String name; // 이름
        int height; // 키
        double vision; // 시력

        // 생성자
        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    // 키의 평균값을 구함
    static double aveHeight(PhyscData[] dat) {
        double sum = 0;

        for (int i = 0; i < dat.length; i++)
            sum += dat[i].height;

        return sum / dat.length;
    }

    // 시력 분포를 구함
    static void distVision(PhyscData[] dat, int[] dist) {
        int i = 0;

        dist[i] = 0;

        for (i = 0; i < dat.length; i++)
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
                dist[(int)(dat[i].vision * 10)]++;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("박현규", 162, 0.3),
                new PhyscData("함진아", 173, 0.7),
                new PhyscData("최윤미", 175, 2.0),
                new PhyscData("홍연의", 171, 1.5),
                new PhyscData("이수진", 168, 0.4),
                new PhyscData("김영준", 174, 1.2),
                new PhyscData("박용규", 169, 0.8),
        };

        int[] vdist = new int[VMAX]; // 시력분포

        System.out.println("- 신체검사 리스트 -");
        System.out.println("이름       키   시력");
        System.out.println("--------------------");

        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

        System.out.printf("\n평균 키 : %5.1fcm\n", aveHeight(x));

        distVision(x, vdist); // 시력 분포를 구함

        System.out.println("\n시력 분포");
        for (int i = 0; i < VMAX; i++) {
            System.out.printf("%3.1f~ : ", i / 10.0);
            for (int count = 1; count <= vdist[i]; count++)
                System.out.print("*");
            System.out.println();
        }
    }
}

/** Q11 YMD */
class YMD {
    int y; // 년
    int m; // 월(1 ~ 12)
    int d; // 일(1 ~ 31)

    YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    // 각 달의 일수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31}, // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31}  // 윤년
    };

    // 서기 year년은 윤년인가? (윤년: 1 / 평년: 0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1: 0;
    }

    YMD before(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return after(-n);

        temp.d -= n;

        while (temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--;
                temp.m = 12;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }
        return temp;
    }

    YMD after(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        if (n < 0)
            return before(-n);

        temp.d += n;

        while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if (++temp.m > 12) {
                temp.y++;
                temp.m = 1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("날짜를 입력하세요.\n");
        System.out.print("년 : ");  int y = stdIn.nextInt();
        System.out.print("월 : ");  int m = stdIn.nextInt();
        System.out.print("일 : ");  int d = stdIn.nextInt();
        YMD date = new YMD(y, m, d);

        System.out.print("며칠 전/후의 날짜를 구할까요? : ");
        int n = stdIn.nextInt();

        YMD d1 = date.after(n);
        System.out.printf("%d일 후의 날짜는 %d년%d월%d일입니다.\n", n, d1.y, d1.m, d1.d);

        YMD d2 = date.before(n);
        System.out.printf("%d일 전의 날짜는 %d년%d월%d일입니다.\n", n, d2.y, d2.m, d2.d);
    }
}

