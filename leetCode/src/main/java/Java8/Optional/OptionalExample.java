package Java8.Optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String name = "John";
        Optional<String> optionalName = Optional.of(name);

        if (optionalName.isPresent()) {
            System.out.println("Name is present: " + optionalName.get());// John
        } else {
            System.out.println("Name is not present.");
        }

        optionalName.ifPresent((n) -> System.out.println("Name is present: " + n));// John

        String nullName = null;
        Optional<String> nullOptionalName = Optional.ofNullable(nullName);

        if (nullOptionalName.isPresent()) {
            System.out.println("Name is present: " + nullOptionalName.get());
        } else {
            System.out.println("Name is not present.");// Name is not present.
        }

        String defaultValue = "Unknown";
        String nameOrDefault = optionalName.orElse(defaultValue);
        System.out.println("Name or default value: " + nameOrDefault);// John

        String nullOrDefault = nullOptionalName.orElse(defaultValue);
        System.out.println("Null or default value: " + nullOrDefault);// Unknown
    }
}

