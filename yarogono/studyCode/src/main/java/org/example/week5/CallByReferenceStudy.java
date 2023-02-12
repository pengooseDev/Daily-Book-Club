package org.example.week5;

public class CallByReferenceStudy {


    public static void main(String[] args) {
        CallByReferenceStudy callByReferenceStudy = new CallByReferenceStudy();
        callByReferenceStudy.start();
    }

    private void start() {
        String testStr= "Test String";
        int testNum = 10;
        String testStr2 = callByValue1(testStr);
        int testNum2 = callByValue2(testNum);
        System.out.println(testStr == testStr2);
        System.out.println(testNum == testNum2);

        int address = System.identityHashCode(testStr);
        int address2 = System.identityHashCode(testStr2);
        System.out.println(address);
        System.out.println(address2);
        testStr = "Test String3";
        System.out.println(testStr2);
    }

    private String callByValue1(String testStr) {
        testStr = "Test String2";
        return testStr;
    }

    private int callByValue2(int testNum) {
        return testNum;
    }
}
