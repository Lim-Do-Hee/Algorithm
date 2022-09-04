package CH03.검색.선형검색;

import java.util.Scanner;

/** 선형검색(보초법)*/
class SeqSearchSen {

    // 요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색합니다.
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key; // 보초를 추가

        while (true) {
            if (a[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; // 요솟수가 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : "); // 키 값을 입력
        int ky = stdIn.nextInt();

        int idx = seqSearchSen(x, num, ky); // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다");
    }
}

/** Q1 seqSearchSen for문*/
class SeqSearchSenFor {

    // 요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색합니다.
    static int seqSearchSenFor(int[] a, int n, int key) {

        a[n] = key; // 보초를 추가

        for (int i = 0; i < n; i++)
            if (a[i] == key)
                return i;
        return -1;
    }

    static int seqSearchSenFo2r(int[] a, int n, int key) {
        int i;

        a[n] = key;					// 보초를 추가

        for (i = 0 ; a[i] != key; i++)
            ;
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; // 요솟수가 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : "); // 키 값을 입력
        int ky = stdIn.nextInt();

        int idx = seqSearchSenFor(x, num, ky); // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다");
    }
}

/** Q2 선형 검색 과정 */
class SeqSearchEx {

    //--- 배열 a의 앞쪽 n개의 요소에서 key와 일치하는 요소를 선형검색(보초법)---//
    static int seqSearchEx(int[] a, int n, int key) {
        System.out.print("   |");
        for (int k = 0; k < n; k++)
            System.out.printf("%4d", k);
        System.out.println();

        System.out.print("---+");
        for (int k = 0; k < 4 * n + 2; k++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
            System.out.printf("%3d|", i);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[i] == key)
                return i;					// 검색 성공
        }
        return -1;						// 검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];		// 요솟수가 num 인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색 값 : ");				// 키값을 입력받음
        int ky = stdIn.nextInt();

        int idx = seqSearchEx(x, num, ky);	// 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}