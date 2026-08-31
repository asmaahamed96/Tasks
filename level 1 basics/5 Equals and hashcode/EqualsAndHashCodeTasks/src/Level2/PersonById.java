package Level2;

import java.util.Objects;

public class PersonById {
    int id;
    String name;
    PersonById(int id, String name) {
        this.id = id; this.name = name;
    }
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonById)) return false;
        return this.id == ((PersonById) obj).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
