package CH04.스택과큐;

/** Q7. IntDeque */
public class IntDeque {
    private int max; // 큐 용량
    private int num; // 큐 데이터 개수
    private int leftFront; // 왼쪽 큐 front
    private int leftRear; // 왼쪽 큐 rear
    private int rightFront; // 오른쪽 큐 front
    private int rightRear; // 오른쪽 큐 rear
    private int[] deque; // 큐 본체

    public class EmptyDequeException extends RuntimeException {
        public EmptyDequeException() {};
    }

    public class OverflowDequeException extends RuntimeException {
        public OverflowDequeException() {};
    }

    // 생성자
    IntDeque(int max) {
        this.max = max;
        leftFront = leftRear = 0 ;
        rightFront = rightRear = max - 1;
        try {
            deque = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }
}