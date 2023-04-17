package JavaCore_interview.Generics._1_GenericClasses;

/**
 * The type parameter section of a generic class can have one or more type parameters separated by commas.
 * These classes are known as parameterized classes or parameterized types because they accept one or more parameters.
 * <p>
 * public class Box<T> {
 * private T t;
 * }
 * <p>
 * Box − Box is a generic class.
 * T − The generic type parameter passed to generic class. It can take any Object.
 * t − Instance of generic type T.
 */

class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

class GenericsTester {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        System.out.printf("Integer Value :%d\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }
}
