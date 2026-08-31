package Level2;

import java.util.Objects;

public class PersonByName {
    int id;
    String name;
    PersonByName(int id, String name) {
        this.id = id; this.name = name;
    }
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonByName)) return false;
        return Objects.equals(this.name, ((PersonByName) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
