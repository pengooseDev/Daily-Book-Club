package org.example.week6;


import java.util.Arrays;

public class CloneableStudy implements Cloneable {

    public static void main(String[] args) {
        User eggKim = new User("김계란", 31, new String[5]);

        User baldGuy = new User(eggKim);

        User hellSpear = User.newInstance(baldGuy);


        System.out.println(eggKim);
        System.out.println(baldGuy);
        System.out.println(hellSpear);
    }
}


class User {
    private String name;
    private int age;
    private String[] friends;

    public User(String name, int age, String[] friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    // 복사 생성자
    public User(User user) {
        this.name = user.name;
        this.age = user.age;
        this.friends = user.friends;
    }


    // 복사 팩터리
    public static User newInstance(User user) {
        return new User(user);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                "} " +
                "hashCode =" + hashCode();
    }
}
