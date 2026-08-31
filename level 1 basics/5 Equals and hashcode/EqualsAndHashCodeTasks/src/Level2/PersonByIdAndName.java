package Level2;

import java.util.Objects;

public class PersonByIdAndName {
    int id;
    String name;
    PersonByIdAndName(int id, String name) {
        this.id = id; this.name = name;
    }
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonByIdAndName)) return false;
        PersonByIdAndName other = (PersonByIdAndName) obj;
        return this.id == other.id && Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
