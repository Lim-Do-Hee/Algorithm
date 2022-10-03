package CH04.스택과큐.큐;

/** Q4. 큐 구현 */
public class IntAryQueue {
    private int max; // 큐 용량
    private int num; // 현재 데이터 수
    private int[] que; // 큐 본체

    // 실행 시 예외 : 큐이 비어 있음
    public class EmptyIntArrayQueueException extends RuntimeException {
        public EmptyIntArrayQueueException() {}
    }

    // 실행 시 예외 : 큐이 가득참
    public class OverflowIntArrayQueueException extends RuntimeException {
        public OverflowIntArrayQueueException() {}
    }

    // 생성자
    public IntAryQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없음
            max = 0;
        }
    }

    // 큐에 x를 인큐
    public int enque(int x) throws OverflowIntArrayQueueException {
        if (num >= max) // 큐가 가득 참
            throw new OverflowIntArrayQueueException();
        return que[num++] = x; // x를 저장한 후의 que[num]값을 반환
    }

    // 큐에서 데이터를 디큐(맨 앞에 있는 데이터를 꺼냄)
    public int deque() throws EmptyIntArrayQueueException {
        if (num <= 0) // 큐가 비어있음
            throw new EmptyIntArrayQueueException();
        int dequeValue = que[0];
        for (int i = 1; i < num; i++)
            que[i - 1] = que[i];
        num -= 1;
        return dequeValue;
    }

    public int deque2() throws EmptyIntArrayQueueException {
        if (num <= 0)
            throw new EmptyIntArrayQueueException();				// 큐가 비어 있음
        int x = que[0];
        for (int i = 0; i < num - 1; i++)
            que[i] = que[i + 1];
        num--;
        return x;
    }

    // 큐에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public int peek() throws EmptyIntArrayQueueException {
        if (num <= 0)
            throw new EmptyIntArrayQueueException();
        return que[num - 1];
    }

    // 큐에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) // 정상 쪽에서 선형 검색
            if (que[i] == x)
                return i; // 검색 성공
        return -1; // 검색 실패
    }

    // 큐을 비움
    public void clear() {
        num = 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓여있는 데이터 수를 반환
    public int size() {
        return num;
    }

    // 큐이 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐이 가득 찼는가?
    public boolean isFull() {
        return num >= max;
    }

    // 큐 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else
            for (int i = 0; i < num; i++)
                System.out.println(i + "번 : " + que[i] + " ");
        System.out.println();
    }
}

class IntAryQueueTester {
    public static void main(String[] args) {
        IntAryQueue que = new IntAryQueue(8);

        que.enque(1);
        que.enque(2);
        que.enque(3);
        que.dump();
        que.deque();
        que.dump();
    }
}
