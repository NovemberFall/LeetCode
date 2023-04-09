package Java8.mapVsflatMap;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;


public class MapVsFlatMap {

    @Test
    void testMap() {
        List<Customer> customers = CusDataBase.getAll();

        //List<Customer> convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  |  one to one mapping
        List<String> emails = customers
                .stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(emails);

        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<List<String>> phoneNumbers = customers
                .stream()
                .map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);
    }







    @Test
    void testFlatMap() {
        List<Customer> customers = CusDataBase.getAll();

        //List<Customer> convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  |  one to one mapping
        List<String> emails = customers
                .stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(emails);




        //customer -> customer.getPhoneNumbers()  ->> one to one mapping
        List<List<String>> phoneNumbers = customers
                .stream()
                .map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);




        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<String> phones = customers
                .stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phones);
    }
}
