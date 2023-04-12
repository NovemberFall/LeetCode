package JavaCore.Generics._7_2_BoundedTypesWithGenerics.example3;

/**
 * Multiple Bounds
 * Bounded type parameters can be used with methods as well as classes and interfaces.
 * <p>
 * Java JavaCore.Generics supports multiple bounds also, i.e., In this case, A can be an interface or class.
 * If A is class, then B and C should be interfaces. We can’t have more than one class in multiple bounds.
 * <p>
 * <T extends superClassName & Interface>
 */
public class Bound<T extends A & B> {
    private T objRef;

    public Bound(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}

interface B {
    public void displayClass();
}

class A implements B {
    public void displayClass() {
        System.out.println("Inside super class A");
    }
}

class BoundedClass {
    public static void main(String a[]) {
        //Creating object of subclass A and
        //passing it to Bound as a type parameter.
        Bound<A> bea = new Bound<A>(new A());
        bea.doRunTest();
    }
}