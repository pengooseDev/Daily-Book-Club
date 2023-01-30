package org.example.week3;

public class BlockingNonBlockingSyncAsync {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.run();
        thread2.run();
    }
}


class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1 : Start");

        try {
            Thread.sleep(1000);
            sumNum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thread1 : End");
    }

    private static void sumNum() {
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num += i;
        }
        System.out.println(num);
    }

}


class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread2 : Start");

        try {
            Thread.sleep(1000);
            sumNum();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thread2 : End");
    }

    private static void sumNum() {
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num += i;
        }
        System.out.println(num);
    }
}
