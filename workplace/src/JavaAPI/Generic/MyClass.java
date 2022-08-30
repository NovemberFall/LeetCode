package JavaAPI.Generic;

public class MyClass<T> {
    T ob;

    MyClass(T i) {
        this.ob = i;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}
