package com.rburgosnavas.annotationtest;

public class Runner {
    public static void main(String... args) {
        // Create an instance of Maker. This is a singleton.
        Maker m = Maker.instance();

        // Create a Person object.
        // Use `create(...)` method by passing a string of data separated by
        // spaces, and the class that we want to create (Person.class).
        // Since `create(...)` returns an Object, the result needs to casted
        // to the correct class (in this case, Person)
        Person p = (Person) m.create("cthulhu king 100000", Person.class);
        print("\n\n" + p.toString());
    }

    static void print(String... text) {
        System.out.println(text);
    }
}
