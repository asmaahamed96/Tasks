package Level1;

import java.util.Objects;

public class Person {
    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }

    // --- Equality is defined by id ONLY ---
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                 // same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
