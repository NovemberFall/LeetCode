package _JavaCore_interview.Singleton_Impl;

import static org.junit.Assert.assertSame;
import org.junit.jupiter.api.Test;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {             // First check
            synchronized (Singleton.class) {
                if (instance == null) {     // Second check (double-checked)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Test
    public void testSingletonInstance() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Assert that both instances are the same object
        System.out.println(singleton1 == singleton2);
        assertSame(singleton1, singleton2);
    }
}
