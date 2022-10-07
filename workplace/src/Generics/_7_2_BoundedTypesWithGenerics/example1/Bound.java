package Generics._7_2_BoundedTypesWithGenerics.example1;

// This class only accepts type parameters as any class
// which extends class A or class A itself.
// Passing any other type will cause compiler time error
class Bound<T extends A> {
    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}

class A {
    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

class B extends A {
    public void displayClass() {
        System.out.println("Inside sub class B");
    }
}

class C extends A {
    public void displayClass() {
        System.out.println("Inside sub class C");
    }
}

class BoundedClass {
    public static void main(String a[]) {

        // Creating object of subclass C and
        // passing it to Bound as a type parameter.
        Bound<C> bec = new Bound<C>(new C());
        bec.doRunTest();

        // Creating object of subclass B and
        // passing it to Bound as a type parameter.
        Bound<B> beb = new Bound<B>(new B());
        beb.doRunTest();

        // similarly passing superclass A
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();

    }
}