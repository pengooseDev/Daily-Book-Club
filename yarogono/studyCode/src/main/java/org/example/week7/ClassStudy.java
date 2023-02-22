package org.example.week7;


// 접근제어자(public) 키워드(class) 클래스명(ClassStudy)
public class ClassStudy {

    // 필드 변수, 멤버 변수
    private String name;
    private int age;

    // 기본 생성자
    public ClassStudy() {

    }

    // 생성자
    public ClassStudy(String name) {
        this.name = name;
    }

    // 생성자 오버로딩
    public ClassStudy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public ClassStudy(int age, String name) {
        this.name = name;
        this.age = age;
    }
}
