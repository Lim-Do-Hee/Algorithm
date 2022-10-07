package CH05.재귀알고리즘.재귀의기본;

import java.util.Arrays;

/** Q3. 배열 a의 모든 요소 최대 공약수 */
public class GcdArray {
    static int gcdArray(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++)
            a[i + 1] = gcd(a[i], a[i + 1]);
        return a[a.length - 1];
    }

    static int gcd(int x, int y) {
        if (x == 0)
            return y;
        else
            return gcd(y % x, x);
    }

    public static void main(String[] args) {
        System.out.println(gcdArray(new int[] {4, 6, 8, 10}));
    }
}