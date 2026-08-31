package Level1;

public class Level1Main {
    public static void main(String[] args) {
        Person p1 = new Person(1, "Ahmed");
        Person p2 = new Person(1, "Mohamed"); // same id, different name
        Person p3 = new Person(2, "Sara");

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);

        System.out.println();
        System.out.println("p1 == p2 (reference)   -> " + (p1 == p2));       // false, different objects
        System.out.println("p1.equals(p2) (same id)-> " + p1.equals(p2));    // true, we overrode equals by id
        System.out.println("p1.equals(p3) (diff id)-> " + p1.equals(p3));    // false

        System.out.println();
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());
        System.out.println("(they must be equal because p1.equals(p2) is true)");
    }
}
