package org.example.week1;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    private String name;
    private String madeBy;

    public Reflection(String name, String madeBy) {
        this.name = name;
        this.madeBy = madeBy;
    }

    public Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe)field.get(null);
    }
}

class Reflection2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Reflection reflection = new Reflection("name", "john");
        Class<? extends Reflection> reflectionClass = reflection.getClass();

        // name 필드만 접근
        Field field = reflectionClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println("Only name : " + field.get(reflection));

        // 모든 필드 접근
        Field[] fields = reflectionClass.getDeclaredFields();
        for (Field tempField : fields) {
            tempField.setAccessible(true);
            System.out.println("All filed : " + tempField.getName());
        }

        // 메소드 접근
        Method method = reflectionClass.getDeclaredMethod("getUnsafe");
        method.invoke(reflection);
    }
}