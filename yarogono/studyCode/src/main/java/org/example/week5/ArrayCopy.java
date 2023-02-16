package org.example.week5;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 4};
        int a2[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] shallowCopy = a; // 얕은 복사 => 주소만 복사

        // 1-1번 반복문
        int[] b1 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b1[i] = a[i];
        }

        // 1-2번. clone
        int[] b2 = a.clone();

        // 1-3번 Arrays.copyOf() -> 가변 길이(끝)
        int[] b3 = Arrays.copyOf(a, a.length);

        // 1-4번 Arrays.copyOfRange() -> 가변 길이(시작, 끝)
        int[] b4 = Arrays.copyOfRange(a, 1, 3);

        // 1-5번 System.arraycopy -> 원하는 위치에
        int[] b5 = new int[a.length];
        System.arraycopy(a, 0, b5, 0, a.length);
    }
}
