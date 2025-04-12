package design;

public class TestQuestions implements A, B {

    @Override
    public void show() {
        // TODO Auto-generated method stub
        System.out.println("Overridden in C");
        A.super.show();
        B.super.show();
    }

    public static void main(String[] args) {
        TestQuestions obj = new TestQuestions();
        obj.show();
    }

}

interface A {
    default void show() {
        System.out.println("Default method from Interface A");
    }
}

interface B {
    default void show() {
        System.out.println("Default method from Interface B");
    }
}
