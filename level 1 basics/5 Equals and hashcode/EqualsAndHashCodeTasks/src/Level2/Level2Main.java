package Level2;

import java.util.HashSet;
import java.util.Set;

public class Level2Main {
    public static void main(String[] args) {

        System.out.println("=== BEFORE overriding equals/hashCode (identity-based) ===");
        Set<PersonNoOverride> setNoOverride = new HashSet<>();
        setNoOverride.add(new PersonNoOverride(1, "Ahmed"));
        setNoOverride.add(new PersonNoOverride(1, "Ahmed")); // "duplicate" values, different object
        System.out.println("Size (expected 2, duplicates NOT detected): " + setNoOverride.size());

        System.out.println();
        System.out.println("=== AFTER overriding, equality by ID ===");
        Set<PersonById> setById = new HashSet<>();
        // 10 persons: some share id, some share name, some are unique
        setById.add(new PersonById(1, "Ahmed"));
        setById.add(new PersonById(1, "Mohamed"));   // same id as above -> duplicate, rejected
        setById.add(new PersonById(2, "Sara"));
        setById.add(new PersonById(3, "Sara"));      // different id, same name -> allowed
        setById.add(new PersonById(4, "Omar"));
        setById.add(new PersonById(4, "Omar"));      // exact duplicate -> rejected
        setById.add(new PersonById(5, "Laila"));
        setById.add(new PersonById(6, "Nour"));
        setById.add(new PersonById(6, "Different Name")); // same id -> rejected
        setById.add(new PersonById(7, "Hassan"));

        System.out.println("Added 10 objects, resulting set size: " + setById.size());
        setById.forEach(System.out::println);

        System.out.println();
        System.out.println("=== Equality by NAME ===");
        Set<PersonByName> setByName = new HashSet<>();
        setByName.add(new PersonByName(1, "Ahmed"));
        setByName.add(new PersonByName(2, "Ahmed")); // different id, same name -> rejected
        setByName.add(new PersonByName(3, "Sara"));
        System.out.println("Size (name-based, expect 2): " + setByName.size());

        System.out.println();
        System.out.println("=== Equality by ID AND NAME ===");
        Set<PersonByIdAndName> setByBoth = new HashSet<>();
        setByBoth.add(new PersonByIdAndName(1, "Ahmed"));
        setByBoth.add(new PersonByIdAndName(1, "Mohamed")); // same id, diff name -> allowed now
        setByBoth.add(new PersonByIdAndName(1, "Ahmed"));   // exact duplicate -> rejected
        System.out.println("Size (id+name based, expect 2): " + setByBoth.size());
    }
}
