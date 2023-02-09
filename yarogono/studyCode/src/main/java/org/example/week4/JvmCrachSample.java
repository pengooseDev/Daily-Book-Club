package org.example.week4;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class JvmCrachSample {
    public static void main(String... args) throws Exception {
        getUnsafe().getInt(0);
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}
