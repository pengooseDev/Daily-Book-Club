package org.example.week8;

public class SuperKeywordStudy {

    public static void main(String[] args) {
        SuperClass superClass = new SuperClass("Super");
        System.out.println(superClass.getSuperClasName());

        SubClass subClass = new SubClass("Sub");
        System.out.println(subClass.getSuperClasName());

        SubClass subClass2 = new SubClass();
        System.out.println(subClass2.getSubClassName());
    }
}

class SuperClass {
    protected String name = "superClass";

    public SuperClass() {

    }

    public SuperClass(String name) {
        this.name = name;
    }


    protected String getSuperClasName() {
        return this.name;
    }

}

class SubClass extends SuperClass {

     String name = "subClass";

    public SubClass() {
        this.name = super.name;
    }

    public SubClass(String name) {
        super(name);
    }

    @Override
    protected String getSuperClasName() {
        return super.getSuperClasName();
    }

    public String getSubClassName() {
        return this.name;
    }
}