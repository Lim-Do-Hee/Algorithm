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

    // 왼쪽 enque
    public int leftEnque(int x) throws OverflowDequeException {
        if (num > max)
            throw new OverflowDequeException();
        deque[leftRear++] = x;
        num++;
        if (leftRear > rightRear)
            leftRear = 0;
        return x;
    }

    // 오른쪽 enque
    public int rightEnque(int x) throws OverflowDequeException {
        if (num > max)
            throw new OverflowDequeException();
        deque[rightRear--] = x;
        num++;
        if (leftRear > rightRear)
            rightRear = max - 1;
        return x;
    }

    // 왼쪽 deque
    public int leftDeque() throws EmptyDequeException {
        if (num <= 0)
            throw new EmptyDequeException();
        int x = deque[leftFront++];
        num--;
        if (leftFront > rightRear)
            leftFront = 0;
        return x;
    }

    // 오른쪽 deque
    public int leftDeque() throws EmptyDequeException {
        if (num <= 0)
            throw new EmptyDequeException();
        int x = deque[rightFront--];
        num--;
        if (rightFront > leftRear)
            rightFront = max - 1;
        return x;
    }

    // 큐에서 데이터를 왼쪽 피크(프런트 데이터를 들여다봄)
    public int leftPeek() throws EmptyDequeException {
        if (num <= 0)
            throw new EmptyDequeException(); // 큐가 비어 있음
        return deque[leftFront];
    }

    // 큐에서 데이터를 왼쪽 피크(프런트 데이터를 들여다봄)
    public int rightPeek() throws EmptyDequeException {
        if (num <= 0)
            throw new EmptyDequeException(); // 큐가 비어 있음
        return deque[rightFront];
    }

    // 큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int leftIndexOf(int x) {
        for (int i = 0; i < leftRear; i++) {
            int idx = (i + leftFront) % (leftRear - leftFront);
            if (deque[idx] == x) // 검색 성공
                return idx;
        }
        return -1; // 검색 실패
    }

    public int rightIndexOf(int x) {
        for (int i = rightRear + 1; i <= rightFront; i++) {
            int idx = (i + rightRear + 1) % (rightFront - rightRear);
            if (deque[idx] == x) // 검색 성공
                return idx;
        }
        return -1; // 검색 실패
    }

    /** Q5. search intQueue 큐 안에서 몇번 째에 있는지 반환 */
    public int leftSearch(int x) {
        for (int i = 0; i < leftRear; i++) {
            int idx = (i + leftFront) % (leftRear - leftFront);
            if (deque[idx] == x)
                return i + 1;
        }
        return 0;
    }

    public int rightSearch(int x) {
        for (int i = rightRear + 1; i <= rightFront; i++) {
            int idx = (i + rightRear + 1) % (rightFront - rightRear);
            if (deque[idx] == x)
                return i + 1;
        }
        return 0;
    }

    // 큐를 비움
    public void clear() {
        num = leftFront = leftRear = rightFront = rightRear= 0;
    }

    public void leftClear() {
        leftFront = leftRear = 0;
    }

    public void rightClear() {
        rightFront = rightRear= 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓여 있는 데이터 수를 반환
    public int size() {
        return num;
    }

    // 큐가 비어 있나요?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 찼나요?
    public boolean isFull() {
        return num >= max;
    }

    // 큐 안ㄴ의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void leftDump() {
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = 0; i < leftRear; i++)
                System.out.println(deque[(i + rightRear + 1) % (rightFront - rightRear)] + " ");
            System.out.println();
        }
    }

    public void rightDump() {
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = rightRear + 1; i <= rightFront; i++)
                System.out.println(deque[(i + rightRear + 1) % (rightFront - rightRear)] + " ");
            System.out.println();
        }
    }
}