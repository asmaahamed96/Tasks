package Level2;

public class PersonNoOverride {
    int id;
    String name;
    PersonNoOverride(int id, String name) {
        this.id = id; this.name = name;
    }
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
    // equals() and hashCode() are NOT overridden -> inherited from Object
}

