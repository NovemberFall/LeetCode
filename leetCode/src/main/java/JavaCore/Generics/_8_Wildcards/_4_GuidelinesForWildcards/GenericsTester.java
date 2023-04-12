package JavaCore.Generics._8_Wildcards._4_GuidelinesForWildcards;

import java.util.ArrayList;
import java.util.List;

/*
Wildcards can be used in three ways −

    Upper bound Wildcard − ? extends Type.
    Lower bound Wildcard − ? super Type.
    Unbounded Wildcard − ?

In order to decide which type of wildcard best suits the condition,
let's first classify the type of parameters passed to a method as in and out parameter.

in variable − An in variable provides data to the code. For Data, copy(src, dest).
                Here src acts as in variable being data to be copied.

out variable − An out variable holds data updated by the code. For Data, copy(src, dest).
                Here dest acts as in variable having copied data.

Guidelines for Wildcards.
    Upper bound wildcard − If a variable is of in category, use extends keyword with wildcard.
    Lower bound wildcard − If a variable is of out category, use super keyword with wildcard.
    Unbounded wildcard − If a variable can be accessed using Object class method then use an unbound wildcard.
    No wildcard − If code is accessing variable in both in and out category then do not use wildcards.
 */

class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

class RedCat extends Cat {
    RedCat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class GenericsTester {
    //Upper bound wildcard
    //in category
    public static void deleteCat(List<? extends Cat> catList, Cat cat) {
        catList.remove(cat);
        System.out.println("Cat Removed");
    }

    //Lower bound wildcard
    //out category
    public static void addCat(List<? super RedCat> catList) {
        catList.add(new RedCat("Red Cat"));
        System.out.println("Cat Added");
    }

    //Unbounded wildcard
    //Using Object method toString()
    public static void printAll(List<?> list) {
        for (Object item : list) {
            System.out.println(item + " ");
        }
    }

    public static void main(String[] args) {

        List<Animal> animalList= new ArrayList<Animal>();
        List<RedCat> redCatList= new ArrayList<RedCat>();

        //add list of super class Animal of Cat class
        addCat(animalList);
        //add list of Cat class
        addCat(redCatList);
        addCat(redCatList);

        //print all animals
        printAll(animalList);
        printAll(redCatList);

        Cat cat = redCatList.get(0);
        //delete cat
        deleteCat(redCatList, cat);
        printAll(redCatList);
    }
}
