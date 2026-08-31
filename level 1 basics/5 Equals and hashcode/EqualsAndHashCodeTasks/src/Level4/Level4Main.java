package Level4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Level4Main {
    public static void main(String[] args) {

        System.out.println("=== Product: equality by code ===");
        Set<Product> products = new HashSet<>();
        products.add(new Product("P100", 25.0));
        products.add(new Product("P100", 99.0)); // same code, diff price -> rejected
        products.add(new Product("P200", 10.0));
        System.out.println("Set size (expect 2): " + products.size());
        products.forEach(System.out::println);

        System.out.println();
        System.out.println("=== Student: equality by ID ===");
        Set<StudentById> studentsById = new HashSet<>();
        studentsById.add(new StudentById(1, "a@mail.com"));
        studentsById.add(new StudentById(1, "b@mail.com")); // same id -> rejected
        studentsById.add(new StudentById(2, "a@mail.com")); // different id, same email as first -> allowed here
        System.out.println("Size by id (expect 2): " + studentsById.size());

        System.out.println();
        System.out.println("=== Student: equality by EMAIL ===");
        Set<StudentByEmail> studentsByEmail = new HashSet<>();
        studentsByEmail.add(new StudentByEmail(1, "a@mail.com"));
        studentsByEmail.add(new StudentByEmail(2, "a@mail.com")); // same email, diff id -> rejected
        studentsByEmail.add(new StudentByEmail(3, "c@mail.com"));
        System.out.println("Size by email (expect 2): " + studentsByEmail.size());
        System.out.println("Notice: (id=1,a@mail.com) and (id=2,a@mail.com) are 'the same student' "
                + "under email-based equality, but were TWO DIFFERENT students under id-based equality above.");

        System.out.println();
        System.out.println("=== Car as a HashMap key (simulated parking system) ===");
        Map<Car, String> parkingSpots = new HashMap<>();
        parkingSpots.put(new Car("XYZ-123", "Red"), "Spot A1");
        parkingSpots.put(new Car("ABC-789", "Blue"), "Spot A2");

        // Same plate re-registers into a different spot (e.g. car re-parked) -> value replaced
        String oldSpot = parkingSpots.put(new Car("XYZ-123", "Red"), "Spot B5");
        System.out.println("Re-parked plate XYZ-123. Old spot: " + oldSpot + ", size still: " + parkingSpots.size());

        // Lookup by a freshly created Car with same plate but different color
        Car lookupCar = new Car("XYZ-123", "Green"); // color doesn't matter for equality
        System.out.println("Lookup XYZ-123 (different color object) -> " + parkingSpots.get(lookupCar));

        System.out.println();
        for (Map.Entry<Car, String> entry : parkingSpots.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
