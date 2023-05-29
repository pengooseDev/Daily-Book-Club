package org.example;

public class DeepCopyAndShallowCopy {
    public static void main(String[] args) {
        ShallowCopyUser shallowCopyUser = new ShallowCopyUser("쉘카피", 34);
        ShallowCopyUser copiedShallowCopyUser = shallowCopyUser;
        System.out.println(copiedShallowCopyUser.getAge() + " " + copiedShallowCopyUser.getName());
        System.out.println(shallowCopyUser.hashCode() + "\n" + copiedShallowCopyUser.hashCode());

        DeepCopyUser deepCopyUser = new DeepCopyUser("딥카피", 50);
        DeepCopyUser copiedDeepCopyUser = new DeepCopyUser(deepCopyUser.getName(), deepCopyUser.getAge());
        System.out.println(copiedDeepCopyUser.getAge() + " " + copiedDeepCopyUser.getName());
        System.out.println(deepCopyUser.hashCode() + "\n" + copiedDeepCopyUser.hashCode());
    }
}

class ShallowCopyUser {
    private String name;
    private int age;

    public ShallowCopyUser(String name, int age) {
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


class DeepCopyUser {
    private String name;
    private int age;

    public DeepCopyUser(String name, int age) {
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
