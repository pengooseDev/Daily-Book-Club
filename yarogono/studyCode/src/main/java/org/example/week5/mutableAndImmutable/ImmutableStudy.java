package org.example.week5.mutableAndImmutable;

public class ImmutableStudy {
    private final String name;
    private final int age;

    public ImmutableStudy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ttttttest {
    public static void main(String[] args) {
        ImmutableStudy immutableStudy = new ImmutableStudy("test", 10);
        System.out.println(immutableStudy.getAge());
        System.out.println(immutableStudy.getName());

        immutableStudy = new ImmutableStudy("test2", 50);
        System.out.println(immutableStudy.getAge());
        System.out.println(immutableStudy.getName());
        String
    }
}
