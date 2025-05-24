package _Java8.Comparator_comparing;


import _Java8.Data.DataBase;
import _Java8.Data.Employee;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorTest {


    /*
        其返回值是 `(c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))` 一个lambda表达式，
        也就是一个Comparator 。所以上面那个例子也可以改造成 如下，
     */
    public static void main(String[] args) {
        List<Employee> employees = DataBase.getEmployees();

        employees.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        employees.forEach(obj -> System.out.println(obj));
    }



    @Test
    void testComparator() {
        List<Employee> employees = DataBase.getEmployees();

        Collections.sort(employees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        employees.stream().forEach(System.out::println);
    }




    @Test
    void testComparatorComparing() {
        List<Employee> employees = DataBase.getEmployees();
        /*
         * Comparator.comparing 方法的使用
         *
         * comparing 方法接收一个 Function 函数式接口 ，通过一个 lambda 表达式传入
         */
        employees.sort(Comparator.comparing(e -> e.getSalary()));

        /*
         * 该方法引用 Employee::getName 可以代替 lambda表达式
         */
        employees.stream().forEach(System.out::println);
        System.out.println();
        System.out.println();

        employees.sort(Comparator.comparing(Employee::getId));
        employees.stream().forEach(System.out::println);
    }








    /**
    public static <T, U> Comparator<T> comparing(
          Function<? super T, ? extends U> keyExtractor,
          Comparator<? super U> keyComparator)
    {
          Objects.requireNonNull(keyExtractor);
          Objects.requireNonNull(keyComparator);
          return (Comparator<T> & Serializable)
              (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1),
                                                keyExtractor.apply(c2));
    }
     */
    @Test
    void testComparatorComparing2() {
    // 和comparing方法一不同的是 该方法多了一个参数keyComparator，keyComparator 是创建一个自定义的比较器。
        List<Employee> employees = DataBase.getEmployees();

        Collections.sort(employees, Comparator.comparing(
                Employee::getSalary, (e1, e2) -> {
                    return e2.compareTo(e1);
                }
        ));
        employees.stream().forEach(System.out::println);
    }







    /*
        使用 Comparator.reversed 进行排序, 返回相反的排序规则
     */
    @Test
    void testComparatorReversed() {
        List<Employee> employees = DataBase.getEmployees();

        Collections.sort(employees, Comparator.comparing(Employee::getName).reversed());
        employees.stream().forEach(System.out::println);
    }








    /*
        使用 Comparator.nullsFirst进行排序
            当集合中存在null元素时，可以使用针对null友好的比较器，null元素排在集合的最前面
     */
    @Test
    void testComparatorNullFirst() {
        List<Employee> employees = DataBase.getEmployees();
        employees.add(null);

        Collections.sort(employees,
                Comparator.nullsFirst(Comparator.comparing(Employee::getName)));
        employees.stream().forEach(System.out::println);
    }








    /*
        使用 Comparator.thenComparing 排序
            首先使用 name 排序，紧接着在使用salary 排序，来看下使用效果
     */
    @Test
    void testComparator_ThenComparing() {
        List<Employee> employees = DataBase.getEmployees();
        Collections.sort(employees, Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary));

        employees.stream().forEach(System.out::println);
    }
}




