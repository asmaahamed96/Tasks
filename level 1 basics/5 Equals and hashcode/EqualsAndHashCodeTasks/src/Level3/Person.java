package Level3;

import java.util.Objects;

public class Person {
    private int id;      // NOT final, so we can demonstrate mutating a key
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        return this.id == ((Person) obj).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
