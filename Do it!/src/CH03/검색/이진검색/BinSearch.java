package CH03.검색.이진검색;

import java.util.Scanner;

/** 이진 검색 */
class BinSearch {
    // 요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색합니다.
    static int binSearch(int[] a, int n, int key) {
        int pl = 0; // 검색 범위의 첫 인덱스
        int pr = n - 1; // 검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr) / 2; // 중앙 요소의 인덱스
            if (a[pc] == key)
                return pc; // 검색 성공!
            else if (a[pc] < key)
                pl = pc + 1; // 검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1; // 검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; // 요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]); // 바로 앞의 요소보다 작으면 다시 입력
        }

        System.out.print("검색할 값 : "); // 키 값을 입력
        int ky = stdIn.nextInt();;

        int idx = binSearch(x, num, ky); // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}

/** Q3 검색 배열 idx 저장, 요솟수 */
class searchIdx{
    // 선형검색
    static int seqSearchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;

        for (int i = 0; i < n; i++)
            if (a[i] == key)
                idx[count++] = i;
        return count;
    }

    // 이진검색 (오름차순으로 정렬 되어있을 때 가능)
    static int binSearchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;

        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                idx[count++] = pc;
            else if (a[pc] < key)
                pl = pc + 1;
            else if (a[pc] > key)
                pr = pc - 1;
        } while (pl <= pr);

        return count;
    }

    //--- 배열 a의 앞쪽 n개의 요소에서 key와 일치하는 요소를 이진검색 ---//
    static int binSearchX2(int[] a, int n, int key) {
        int pl = 0;			// 검색 범위 맨앞의 인덱스
        int pr = n - 1;		// 　 〃    　맨끝의 인덱스

        do {
            int   pc = (pl + pr) / 2;	// 중앙요소의 인덱스
            if (a[pc] == key) {
                for ( ; pc > pl; pc--)	// key와 같은 맨앞의 요소를 검색합니다
                    if (a[pc - 1] < key)
                        break;
                return pc;							// 검색 성공
            } else if (a[pc] < key)
                pl = pc + 1;						// 검색 범위를 앞쪽 절반으로 좁힘
            else
                pr = pc - 1;						// 검색 범위를 뒤쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1;									// 검색 실패
    }

    public static void main(String[] args) {
        System.out.println(seqSearchIdx(new int[] {1, 9, 2, 9, 4, 6, 7, 9}, 8, 9, new int[3]));
        System.out.println(seqSearchIdx(new int[] {1, 9, 2, 9, 4, 6, 7, 9}, 8, 9, new int[3]));
    }
}

/** Q5. 이진 검색 맨 앞의 요소 찾기 */
class BinSearchX {
    static int binSearchX(int[] a, int n, int key) {
        int resultIdx = -1;

        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                resultIdx = pc;
                pr = pc - 1;
            }
            else if (a[pc] < key)
                pl = pc + 1;
            else if (a[pc] > key)
                pr = pc - 1;
        } while (pl <= pr);

        return resultIdx;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];				// 요솟수가 num 인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");		// 맨앞 요소를 입력받음
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);	// 바로 앞의 요소보다 작으면 다시 입력 받음
        }

        System.out.print("검색 값 : ");			// 키값을 입력받음
        int ky = stdIn.nextInt();

        int idx = binSearchX(x, num, ky);	// 배열 x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
    }
}