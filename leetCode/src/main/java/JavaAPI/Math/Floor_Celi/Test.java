package JavaAPI.Math.Floor_Celi;

/**
 ceil:
    - Math ceil function in Java returns the smallest integer
                                    that is greater than or equal to the argument
 floor:
    - Java floor method returns the largest integer that is less than or equal to the argument
 */

class Test {
    public static void main(String[] args) {
        double d1 = 84.6;
        double d2 = 0.45;
        System.out.println("Ceiling of '" + d1 + "' = " + Math.ceil(d1));

        System.out.println("Floor of '" + d1 + "' = " + Math.floor(d1));

        System.out.println("Ceiling of '" + d2 + "' = " + Math.ceil(d2));

        System.out.println("Floor of '" + d2 + "' = " + Math.floor(d2));
    }
}
