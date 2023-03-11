package org.example;

import java.lang.reflect.Field;

public final class FinalClass {
    private final String name;

    public FinalClass(String name) {
        this.name = name;
    }

    public final String  getName() {
        return this.name;
    }
}


class FinalKeywordStudy {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // reflection으로 final 멤버 변수 값 변경하기
        FinalClass finalClass = new FinalClass("Final Class");
        Class reflectionFinalClass = FinalClass.class;
        Field field = reflectionFinalClass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(finalClass, "reflection");

        System.out.println(finalClass.getName());
    }
}