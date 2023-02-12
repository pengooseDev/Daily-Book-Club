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