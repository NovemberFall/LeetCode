package OOD.Generic;

public class NumericFunction <T extends Number> {
    T num;

    NumericFunction(T obj) {
        this.num = obj;
    }

    boolean Equals(NumericFunction<?> ob) {
        if (num.doubleValue() == ob.num.doubleValue()) {
            return true;
        }
        return false;
    }
}
