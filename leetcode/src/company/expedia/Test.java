package company.expedia;

public class Test {
    static class A {
        public int a = 0;
    }

    static class B extends A {
        public int a = 1;
    }

    static class C extends B {
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof B);
        System.out.println(!(b instanceof A));
    }
}
