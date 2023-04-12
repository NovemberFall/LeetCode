package JavaCore.Generics._3_TypeInference;

/*
Type inference represents the Java compiler's ability to look at a method invocation and
its corresponding declaration to check and determine the type argument(s).
The inference algorithm checks the types of the arguments and, if available, assigned type is returned.
Inference algorithms tries to find a specific type which can fulfill all type parameters.

Compiler generates unchecked conversion warning in-case type inference is not used.

Syntax
Box<Integer> integerBox = new Box<>();

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
        //type inference
        Box<Integer> integerBox = new Box<>();
        //unchecked conversion warning
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        System.out.printf("Integer Value :%d\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());
    }
}

