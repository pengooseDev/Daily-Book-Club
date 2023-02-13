package org.example.week5;

public class DeepCopyAndShallowCopy {
    public static void main(String[] args) {
        ShallowCopyUser shallowCopyUser = new ShallowCopyUser("쉘카피", 34);
        ShallowCopyUser copiedShallowCopyUser = shallowCopyUser;
        System.out.println(copiedShallowCopyUser.getAge() + " " + copiedShallowCopyUser.getName());
        System.out.println(shallowCopyUser.hashCode() + "\n" + copiedShallowCopyUser.hashCode());

        try {
            DeepCopyUser deepCopyUser = new DeepCopyUser("딥카피", 50);
            DeepCopyUser copiedDeepCopyUser = (DeepCopyUser) deepCopyUser.clone();
            System.out.println(copiedDeepCopyUser.getAge() + " " + copiedDeepCopyUser.getName());
            System.out.println(deepCopyUser.hashCode() + "\n" + copiedDeepCopyUser.hashCode());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ShallowCopyUser implements Cloneable {
    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
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


class DeepCopyUser implements Cloneable {
    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

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
