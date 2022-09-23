package CH04.스택과큐;

import java.util.Scanner;

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
        if (ptr <= 0) // 스택이 비어있음음
           throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크(정사에 있는 데이터를 들여다봄)
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) // 정상 쪽에서 선형 검색
            if (stk[i] == x)
                return i; // 검색 성공
        return -1; // 검색 실패
    }

    // 스택을 비움 - 스택에 대한 푸시와 팝 등 모든 작업은 스택 포인터를 바탕으로 이루어집니다.
    // 따라서 스택의 배열 요솟값을 변경할 필요가 없습니다.
    // 모든 요소의 삭제는 스택 포인터 ptr 값을 0으로 하면 끝납니다.
    public void clear() {
        ptr = 0;
    }

    // 스택의 용량을 반환
    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수를 반환
    public int size() {
        return ptr;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else
            for (int i = 0; i < ptr; i++)
                System.out.println(stk[i] + " ");
            System.out.println();
    }
}

/** int형 스택의 사용 예 */
class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64); // 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.println("(1)푸시 (2)팝 (3)피크 " + "(4)덤프 (0) 종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: // 푸시
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다");
                    }
                    break;

                case 2: // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4: // 덤프
                    s.dump();
                    break;
            }
        }
    }
}

/** Q1.IntStack의 모든 메서드를 사용하는 프로그램 */
class IntStackTesterAll {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64); // 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.println("(1)푸시 (2)팝 (3)피크 " + "(4)검색 (5)초기화 (6)용량 " + "(7)데이터 수 (8)Empty (9)Full " +" (10)덤프 (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: // 푸시
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다");
                    }
                    break;

                case 2: // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4: // 검색
                    try {
                        int key = stdIn.nextInt();
                        x = s.indexOf(key);
                        if (x == -1)
                            System.out.println("검색 결과가 없습니다.");
                        else
                            System.out.println(x + "번 째에 존자합니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 5: // 초기화
                    s.clear();
                    break;

                case 6: // 용량
                    x = s.capacity();
                    System.out.println("스택의 용량은 " + x + "입니다.");
                    break;

                case 7: // 데이터 수
                    x = s.size();
                    System.out.println("스택의 데이터 수는 " + x + "입니다.");
                    break;

                case 8: // Empty 유무 확인
                    boolean empty = s.isEmpty();
                    if (empty)
                        System.out.println("비어있습니다.");
                    else
                        System.out.println("비어 있지 않습니다.");
                    break;

                case 9: // Full 확인
                    boolean full = s.isFull();
                    if (full)
                        System.out.println("가득 찼습니다.");
                    else
                        System.out.println("push 가능합니다.");
                    break;

                case 10: // 덤프
                    s.dump();
                    break;
            }
        }
    }
}

/** Q3. 하나의 배열을 공유하여 2개의 스택 구현 */
class IntStackShare {
    private int max; // 스택 용량
    private int leftPtr; // 왼쪽 스택 포인터
    private int rightPtr; // 오른쪽 스택 포인터
    private int[] stk; // 스택 본체

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득참
    public static class OverflowIntStackException extends  RuntimeException {
        public OverflowIntStackException() {}
    }

    IntStackShare(int max) {
        this.leftPtr = 0;
        this.rightPtr = max - 1;
        this.max = max;
        try {
            stk = new int[this.max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    // 왼쪽 스택 추가
    public int pushLeft(int x) throws OverflowIntStackException {
        if (leftPtr > rightPtr)
            throw new OverflowIntStackException();
        return stk[leftPtr++] = x;
    }

    // 오른쪽 스택 추가
    public int pushRight(int x) throws OverflowIntStackException {
        if (rightPtr < leftPtr)
            throw new OverflowIntStackException();
        return stk[rightPtr--] = x;
    }

    // 왼쪽 스택 pop
    public int popLeft() throws EmptyIntStackException {
        if (leftPtr <= 0)
            throw new EmptyIntStackException();
        return stk[--leftPtr];
    }

    // 오른쪽 스택 pop
    public int popRight() throws EmptyIntStackException {
        if (rightPtr >= max - 1)
            throw new EmptyIntStackException();
        return stk[++rightPtr];
    }

    // 왼쪽 스택 정상에 있는 데이터를 들여다봄
    public int peekLeft() throws EmptyIntStackException {
        if (leftPtr <= 0)
            throw new EmptyIntStackException();
        return stk[leftPtr - 1];
    }

    // 오른쪽 스택 정상에 있는 데이터를 들여다봄
    public int peekRight() throws EmptyIntStackException {
        if (rightPtr >= max - 1)
            throw new EmptyIntStackException();
        return stk[rightPtr + 1];
    }

    // 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        // 왼쪽 스택에서 검색
        for (int i = 0; i < leftPtr; i++)
            if (stk[i] == x)
                return i;

        // 오른쪽 스택에서 검색
        for (int i = rightPtr + 1; i < max; i++)
            if (stk[i] == x)
                return i;

        return -1;
    }

    // 왼쪽, 오른쪽 스택 한번에 비움
    public void clear() {
        leftPtr = 0;
        rightPtr = max - 1;
    }

    // 왼쪽 스택을 비움
    public void leftClear() {
        leftPtr = 0;
    }

    // 오른쪽 스택을 비움
    public void rightClear() {
        rightPtr = max - 1;
    }

    // 스택의 용량을 반환
    public int capacity() {
        return max;
    }

    // 왼쪽 스택에 쌓여있는 데이터 수를 반환
    public int leftSize() {
        return leftPtr;
    }

    // 오른쪽 스택에 쌓여있는 데이터 수 반환
    public int rightSize() {
        return max - rightPtr - 1;
    }

    // 왼쪽, 오른쪽 스택 합친 데이터 수 반환
    public int totalSize() {
        return leftPtr + max - rightPtr - 1;
    }

    // 왼쪽 스택이 비어 있는가?
    public boolean isLeftEmpty() {
        return leftPtr <= 0;
    }

    // 오른쪽 스택이 비어 있는가?
    public boolean isRightEmpty() {
        return rightPtr >= max - 1;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return leftPtr > rightPtr;
    }

    // 왼쪽 스택 바닥 -> 꼭대기 출력
    public void dumpLeft() {
        if (leftPtr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else
            for (int i = 0; i < leftPtr; i++)
                System.out.println(stk[i] + " ");
        System.out.println();
    }

    // 오른쪽 스택 바닥 -> 꼭대기 출력
    public void dumpRight() {
        if (rightPtr >= max - 1)
            System.out.println("스택이 비어 있습니다.");
        else
            for (int i = max - 1; i > rightPtr; i--)
                System.out.println(stk[i] + " ");
        System.out.println();
    }
}

class IntStackShareTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStackShare s = new IntStackShare(10); // 최대 64개를 푸시할 수 있는 스택

        System.out.println(s.pushLeft(1));


    }
}
