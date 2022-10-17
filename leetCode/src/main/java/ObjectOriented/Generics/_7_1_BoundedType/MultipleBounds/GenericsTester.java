package ObjectOriented.Generics._7_1_BoundedType.MultipleBounds;

/*
A type parameter can have multiple bounds.
Syntax:
        public static <T extends Number & Comparable<T>> T maximum(T x, T y, T z)
                maximum − maximum is a generic method.
                T − The generic type parameter passed to generic method. It can take any Object.

        The T is a type parameter passed to the generic class Box and {should be subtype of Number class}
            and must implement Comparable interface. In case {a class is passed as bound},
            {it should be passed first} before interface otherwise compile time error will occur.



*/
class GenericsTester {
    public static void main(String[] args) {
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
    }

    public static <T extends Number & Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }

        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    // Compiler throws error in case of below declaration
    /*
       public static <T extends Comparable<T> & Number> T maximum1(T x, T y, T z) {
          T max = x;
          if(y.compareTo(max) > 0) {
             max = y;
          }

          if(z.compareTo(max) > 0) {
             max = z;
          }
          return max;
       }
    */
}
