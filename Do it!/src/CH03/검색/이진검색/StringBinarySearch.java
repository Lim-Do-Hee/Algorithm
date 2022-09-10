package CH03.검색.이진검색;

import java.util.Arrays;
import java.util.Scanner;

/** 문자열의 배열(Java의 키워드)에서 검색 */
class StringBinarySearch {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        // Java에서 사용하는 키워드입니다.
        String[] x = {    // 자바에서 사용하는 키워드(알파벳 순)
                "abstract",   "assert",       "boolean",   "break",      "byte",
                "case",       "catch",        "char",      "class",      "const",
                "continue",   "default",      "do",        "double",     "else",
                "enum",       "extends",      "final",     "finally",    "float",
                "for",        "goto",         "if",        "implements", "import",
                "instanceof", "int",          "interface", "long",       "native",
                "new",        "package",      "private",   "protected",  "public",
                "return",     "short",        "static",    "strictfp",   "super",
                "switch",     "synchronized", "this",      "throw",      "throws",
                "transient",  "try",          "void",      "volatile",   "while"
        };

        System.out.print("원하는 키워드를 입력하세요. : "); // 키 값을 입력

        String ky = stdIn.next();

        int idx = Arrays.binarySearch(x, ky); // 배열 x에서 값이 ky인 요소를 검색

        if (idx < 0)
            System.out.println("해당 키워드가 없습니다.");
        else
            System.out.println("해당 키워드는 x[" + idx + "]에 있습니다.");
    }
}

/** 자연스러운 정렬을 하려면 다음과 같은 방법으로 클래스를 정의합니다. */
class A implements Comparable<A> {
    // 필드, 메서드 등

    public int compareTo(A o) {
        return 0;
    }


    public boolean equals(Object obj) {
        return true;
    }
}
