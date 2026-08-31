package Level3;

import java.util.HashMap;
import java.util.Map;

public class Level3Main {
    public static void main(String[] args) {
        Map<Person, String> roles = new HashMap<>();

        Person p1 = new Person(1, "Ahmed");
        Person p2 = new Person(2, "Sara");

        roles.put(p1, "Employee");
        roles.put(p2, "Manager");
        System.out.println("After inserting 2 keys, size = " + roles.size());

        // Insert a NEW object with the same id as p1
        Person p1Duplicate = new Person(1, "Different Name");
        String previousValue = roles.put(p1Duplicate, "Team Lead");
        System.out.println();
        System.out.println("Inserted key with same id=1 but value 'Team Lead'.");
        System.out.println("Previous value that was replaced: " + previousValue); // "Employee"
        System.out.println("Map size (should still be 2, VALUE was replaced, not duplicated): " + roles.size());
        System.out.println("Value now stored for id=1: " + roles.get(new Person(1, "irrelevant")));

        // Retrieve using a brand new object with the same id
        System.out.println();
        Person lookup = new Person(2, "irrelevant name");
        System.out.println("Retrieve id=2 using a NEW object -> " + roles.get(lookup));
        System.out.println("(Works because equals/hashCode only look at id)");

        // --- The mutation problem ---
        System.out.println();
        System.out.println("=== Mutating a key AFTER insertion ===");
        Person mutable = new Person(3, "Original");
        roles.put(mutable, "Intern");
        System.out.println("Before mutation, get(id=3) -> " + roles.get(new Person(3, "x")));

        mutable.setId(99); // mutate the field that hashCode/equals depend on!
        System.out.println("Mutated key's id to 99 (same object still inside the map)");

        System.out.println("get(new Person(3,...)) -> " + roles.get(new Person(3, "x")));   // likely null now
        System.out.println("get(new Person(99,...)) -> " + roles.get(new Person(99, "x"))); // likely null too
        System.out.println("Map still reports size = " + roles.size() + " (entry is 'lost' but still occupies a slot)");

        System.out.println();
        System.out.println("Full map contents (still contains the stale entry internally):");
        for (Map.Entry<Person, String> entry : roles.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
