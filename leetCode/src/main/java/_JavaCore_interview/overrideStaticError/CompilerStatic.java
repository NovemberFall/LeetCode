package _JavaCore_interview.overrideStaticError;

// super class
class CompilerStatic {
    public void nonStaticMethod(){
        System.out.println("This is a non static method");
    }
    public static void staticMethod(){
        System.out.println("This is a static method");
    }
}

//class CompilerStaticImpl extends CompilerStatic {
//    @Override
//    public static void nonStaticMethod() {
//        // compile-time error throw
//    }
//
//    @Override
//    public void staticMethod() {
//        // compile-time error throw
//    }
//
//    @Override
//    public static void staticMethod() {
//        // compile-time error throw
//    }
//    public static void main(String[] args) {
//        CompilerPoC compilerPoC = new CompilerPoC();
//        compilerPoC.nonStaticMethod();
//
//        CompilerPoCImpl compilerPocImpl = new CompilerPoCImpl();
//        compilerPocImpl.nonStaticMethod();
//    }
//}