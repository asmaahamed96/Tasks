package Level4;

import java.util.Objects;

public class StudentById {
    private final int id;
    private final String email;

    public StudentById(int id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", email='" + email + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StudentById)) return false;
        return this.id == ((StudentById) obj).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
