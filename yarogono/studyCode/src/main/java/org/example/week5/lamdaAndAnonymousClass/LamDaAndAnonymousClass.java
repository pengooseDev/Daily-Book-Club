package org.example.week5.lamdaAndAnonymousClass;

import java.util.Comparator;

public class LamDaAndAnonymousClass {
    public static void main(String[] args) {
        // 익명 클래스(Anonymous Class)
       Comparator<Integer> comp = new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1.compareTo(o2);
           }
       };


        // 람다식(Lamda Expression)
       Comparator<Integer> comp2 = (o1, o2) -> (o1.compareTo(o2));
    }
}