package CH03.검색.이진검색;

import java.util.Comparator;

/** 클래스 X의 내부에서 comparator를 정의하는 방법은 다음과 같습니다. */
class X {
    // 필드, 메서드 등
    public static final Comparator<X> COMPARATOR = new Comp();

    private static class Comp implements Comparator<X> {
        public int compare(X o1, X o2) {
            return 0;
        }
    }
}
