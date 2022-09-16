package CH03.검색.이진검색;

/** 제네릭 클래스의 예 */
public class GenericClassTester {
    // 제네릭 클래스의 파라미터를 T라고 작성합니다.
    static class GenericClass<T> {
        private T xyz;
        GenericClass(T t) { // 생성자
            this.xyz = t;
        }
        T getXyz() { // xyz를 반환합니다.
            return xyz;
        }
    }

    public static void main(String[] args) {
        // 다음과 같이 파라미터에 String을 넘길 수도 있고 Integer를 넘길 수도 있습니다.
        GenericClass<String> s = new GenericClass<String>("ABC");
        GenericClass<Integer> n = new GenericClass<Integer>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}

/**
 * 제네릭
 * 제네릭(Generic)은 클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미
 * <T>	Type
 * <E>	Element
 * <K>	Key
 * <V>	Value
 * <N>	Number
 *  제네릭이 사용되는 메소드를 정적메소드로 두고 싶은 경우 제네릭 클래스와 별도로 독립적인 제네릭이 사용되어야 한다
 */