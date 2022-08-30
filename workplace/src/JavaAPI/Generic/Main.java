package JavaAPI.Generic;

public class Main {
    public static void main(String[] args) {
        NumericFunction<Integer> iob = new NumericFunction<>(6);
        NumericFunction<Double> dob = new NumericFunction<>(6.0);
        iob.Equals(dob);
    }
}




//        String str = "word ladder";
//        System.out.println(str.substring(1));
