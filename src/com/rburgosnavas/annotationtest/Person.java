package com.rburgosnavas.annotationtest;

/**
 * A simple class to generalize a person. Each field is annotated with a key
 * which default to DataType.STRING. Field `age` has a type declared as
 * DataType.INTEGER.
 */
public class Person {
    @Field(key = "first_name")
    public String firstName;

    @Field(key = "last_name")
    public String lastName;

    @Field(key = "age", type = DataType.INT)
    public int age;

    public Person() { }

    @Override
    public String toString() {
        return "Person { " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                " }";
    }
}
