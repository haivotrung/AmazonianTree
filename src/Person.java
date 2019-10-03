import java.util.*;
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void changePersonName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }
}
