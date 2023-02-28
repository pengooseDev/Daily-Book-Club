package org.example.week8;

public class FloatingPointError {
    public static void main(String[] args) {
        // 0.1과 1.1을 더한것과 1.2의 값이 같지 않다고 나온다. false
        float num1 = 0.1f;
        float num2 = 1.1f;
        System.out.println(	num1 + num2 == 1.2);
    }
}
