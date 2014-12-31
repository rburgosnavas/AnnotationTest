package com.rburgosnavas.annotationtest;

/**
 * Maker handles creation of the of objects.
 */
public class Maker {

    // Ensure only one instance of this class is ever present.
    private static final Maker m = new Maker();

    /**
     * Returns a single instance of Maker.
     *
     * @return A single instance of Maker.
     */
    public static Maker instance() {
        return m;
    }

    /**
     * Method that creates the object.
     *
     * @param data A string of data separated by spaces, which is enough to
     *             for this example.
     * @param c The class to create an object from the data.
     *
     * @return An object with the data passed.
     */
    public Object create(String data, Class<?> c) {

        // Split the data string by spaces
        String[] dataArr = data.split(" ");

        // counter to iterate through `dataArr`
        int cnt = 0;

        // The object that the method will try to create, initialized to null
        Object p = null;

        try {
            // Get the fully qualified name of the class `c`, pass it to
            // Class.forName(...), and generate a new instance
            p = Class.forName(c.getName()).newInstance();

            System.out.print("{ ");

            // Iterate through the fields from `c`
            for (java.lang.reflect.Field f : c.getDeclaredFields()) {
                // Get a string from `dataArr`
                String d = dataArr[cnt];

                // If `d` is a DataType.INTEGER, then treat it as an `int`
                // else treat it as a `String`
                if (DataType.INT == f.getAnnotation(Field.class).type()) {
                    // For this field, add `int` data to object `p`
                    f.setInt(p, Integer.parseInt(d));
                } else {
                    // For this field, add `String` data to object `p`
                    f.set(p, d);
                }

                System.out.print(f.getAnnotation(Field.class).key() +
                        "=" + d + (cnt == 2 ? "" : ", "));

                // Increment the counter for `dataArr`
                cnt++;
            }

            System.out.print(" }");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return p;

    }
}
