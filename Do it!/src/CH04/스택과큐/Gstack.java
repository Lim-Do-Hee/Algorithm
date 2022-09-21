package CH04.스택과큐;

/** Q2. 제네릭 스택 클래스 */
public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    // 생성자
    @SuppressWarnings("unchecked")
    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            this.stk = (E[]) new Object[capacity];
        } catch (OutOfMemoryError err) {
            max = 0;
        }
    }
}