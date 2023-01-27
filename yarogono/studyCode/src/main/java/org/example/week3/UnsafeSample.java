package org.example.week3;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeSample {

    private final static byte BYTE = 1;
    private long size;
    private long address;

    public UnsafeSample(long size) throws NoSuchFieldException, IllegalAccessException {
        this.size = size;
        address = getUnsafe().allocateMemory(size * BYTE);
    }

    public Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

    public void set(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().putByte(address + i * BYTE, value);
    }

    public long size() {
        return size;
    }

    public void freeMemory() throws NoSuchFieldException, IllegalAccessException {
        getUnsafe().freeMemory(address);
    }

    public byte get(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
        return getUnsafe().getByte(address + i * BYTE);
    }
}

class RunUnsafeSample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        UnsafeSample unsafeSample = new UnsafeSample(SUPER_SIZE);
        byte tempByte = 8;
        unsafeSample.set(2L, tempByte);

        System.out.println(unsafeSample.get(2L, tempByte));
    }
}
