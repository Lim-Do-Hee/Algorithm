package CH04.스택과큐;

/**  int형 스택 */
public class IntStack {
    private int max; // 스택용량
    private int ptr; // 스택 포인터
    private int[] stk; // 스택 본체

    // 실행 시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득팜
    public class OverflowIntStackException extends  RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없음
            max = 0;
        }
    }

    // 스택에 x를 푸시
    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max) // 스택이 가득 참
            throw new OverflowIntStackException();
        return stk[ptr++] = x; // x를 저장한 후의 stk[ptr]값을 반환
    }

    // 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) // 스택이 비어있음
            throw new EmptyIntStackException();
        return stk[--ptr];
    }
}
