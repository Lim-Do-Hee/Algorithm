package CH04.스택과큐.스택;

/** Q2. 제네릭 스택 클래스 */
public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    //--- 실행 시 예외 : 스택이 비어 있음 ---//
    public static class EmptyGstackException extends RuntimeException {
        public EmptyGstackException() { }
    }

    //--- 실행 시 예외 : 스택이 가득 참 ---//
    public static class OverflowGstackException extends RuntimeException {
        public OverflowGstackException() { }
    }

    // 생성자
    @SuppressWarnings("unchecked")
    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            this.stk = (E[]) new Object[max];
        } catch (OutOfMemoryError err) {
            max = 0;
        }
    }


    //--- 스택에 x를 푸시 ---//
    public E push(E x) throws OverflowGstackException {
        if (ptr >= max)								// 스택이 가득 참
            throw new OverflowGstackException();
        return stk[ptr++] = x;
    }

    //--- 스택에서 데이터를 팝(꼭대기의 데이터를 꺼냄) ---//
    public E pop() throws EmptyGstackException {
        if (ptr <= 0)												// 스택이 비어 있음
            throw new EmptyGstackException();
        return stk[--ptr];
    }

    //--- 스택에서 데이터를 피크(꼭대기의 데이터를 들여다 봄) ---//
    public E peek() throws EmptyGstackException {
        if (ptr <= 0)												// 스택이 비어 있음
            throw new EmptyGstackException();
        return stk[ptr - 1];
    }

    //--- 스택을 비웁니다 ---//
    public void clear() {
        ptr = 0;
    }

    //--- 스택에서 x를 검색하여 인덱스(발견하지 못하면 -1)를 반환합니다 ---//
    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--)		// 꼭대기 쪽에서 선형검색
            if (stk[i].equals(x))
                return i;						// 검색 성공
        return -1;							// 검색 실패
    }

    //--- 스택 용량을 반환합니다 ---//
    public int getMax() {
        return max;
    }

    //--- 스택에 쌓여있는 데이터수를 반환합니다 ---//
    public int size() {
        return ptr;
    }

    //--- 스택이 비어 있는가? ---//
    public boolean isEmpty() {
        return ptr <= 0;
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull() {
        return ptr >= max;
    }

    //--- 스택 안의 모든 데이터를 바닥 → 꼭대기의 순서로 출력 ---//
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }


}