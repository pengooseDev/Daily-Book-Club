package org.example;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations=1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JMHtestClass {

//    String aValue = "abcde";
//
//    @Benchmark
//    @OperationsPerInvocation(10000)
//    public String strTest() {
//        String a = new String();
//        for (int loop = 0; loop < 10000; loop++) {
//            a += aValue;
//        }
//
//        return a;
//    }
//
//    @Benchmark
//    @OperationsPerInvocation(10000)
//    public String stringBuilderTest() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int loop = 0; loop < 10000; loop++) {
//            stringBuilder.append(aValue);
//        }
//
//        return stringBuilder.toString();
//    }
//
//    @Benchmark
//    @OperationsPerInvocation(10000)
//    public String stringBufferTest() {
//        StringBuffer stringBuffer = new StringBuffer();
//
//        for (int loop = 0; loop < 10000; loop++) {
//            stringBuffer.append(aValue);
//        }
//        String temp2 = stringBuffer.toString();
//
//        return stringBuffer.toString();
//    }


    @Benchmark
    public void longSumTest1() {
        Long sum = 0L;
        for (long i = 0; i < 1000000; i++) {
            sum += i;
        }
    }

    @Benchmark
    public void longSumTest2()  {
        long sum = 0;
        for (long i = 0; i < 1000000; i++) {
            sum += i;
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHtestClass.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}