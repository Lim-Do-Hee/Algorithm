package CH03.검색.이진검색;

import java.util.Arrays;
import java.util.Comparator;

public class CompareAndComparator {
    public static void main(String[] args) {
        MyInteger[] arr = new MyInteger[10];

        // 객체 배열 초기화 (랜덤 값으로)
        for (int i = 0; i < 10; i++) {
            arr[i] = new MyInteger((int)(Math.random() * 100));
        }

        // 정렬 이전
        System.out.print("정렬 전 : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].value + " ");
        }
        System.out.println();

        Arrays.sort(arr);

        Arrays.sort(arr, comp); // MyInteger에 대한 Comparator를 구현한 익명객체를 넘겨줌

        // 정렬 이후
        System.out.print("정렬 후 : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].value + " ");
        }
        System.out.println();
    }

    static Comparator<MyInteger> comp = new Comparator<MyInteger>() {
        @Override
        public int compare(MyInteger o1, MyInteger o2) {
            return o1.value - o2.value;
        }
    };
}

/**
 * Comparable를 구현하지 않았다면
 * MyInteger 클래스를 Arrays.sort 안에서 정렬을 하면서 원소를 비교하려 하는데,
 * 해당 클래스가 비교할 수 있는 기준이 정의되어있지 않아서 정렬 자체가 불가능하다.
 * 오름차순 정렬의 의미 :
 * 선행 원소가 후행 원소보다 작다
 * compare 혹은 compareTo 를 사용하여 비교할 경우 음수가 나오면 두 원소의 위치를 바꾸지 않는다.
 */
class MyInteger implements Comparable<MyInteger> {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyInteger o) {
        return this.value - o.value;
    }
}