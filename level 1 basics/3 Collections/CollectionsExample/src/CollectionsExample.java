import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        //ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        //adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");
        //deleting an element from the ArrayList
        fruits.remove("Banana");
        //updating an element in the ArrayList
        fruits.set(1, "Mango");
        //printing the ArrayList
        System.out.println("Fruits: " + fruits);

        //LinkedList
        LinkedList<String> animals = new LinkedList<>();
        //adding elements to the LinkedList
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Elephant");
        animals.add("Giraffe");
        //deleting an element from the LinkedList
        animals.remove("Tiger");
        //updating an element in the LinkedList
        animals.set(1, "Zebra");
        //printing the LinkedList
        System.out.println("Animals: " + animals);

        //Vector
        Vector<String> colors = new Vector<>();
        //adding elements to the Vector
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        //deleting an element from the Vector
        colors.remove("Green");
        //updating an element in the Vector
        colors.set(1, "Purple");
        //printing the Vector
        System.out.println("Colors: " + colors);

        //Stack
        Stack<String> books = new Stack<>();
        //adding elements to the Stack
        books.push("The Great Gatsby");
        books.push("To Kill a Mockingbird");
        books.push("1984");
        books.push("Pride and Prejudice");
        //deleting an element from the Stack
        books.pop();
        //updating an element in the Stack
        books.set(1, "The Catcher in the Rye");
        //printing the Stack
        System.out.println("Books: " + books);

        //ArrayDeque
        ArrayDeque<String> tasks = new ArrayDeque<>();
        //adding elements to the ArrayDeque
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");
        tasks.add("Task 4");
        //deleting an element from the ArrayDeque
        tasks.remove("Task 2");
        //updating an element in the ArrayDeque (there is no direct method to update an element in ArrayDeque, so we can remove and add)
        //printing the ArrayDeque
        System.out.println("Tasks: " + tasks);

        //PriorityQueue
        PriorityQueue<String> queue = new PriorityQueue<>();
        //adding elements to the PriorityQueue
        queue.add("Task A");
        queue.add("Task B");
        queue.add("Task C");
        queue.add("Task D");
        //updating an element in the PriorityQueue (there is no direct method to update an element in PriorityQueue, so we can remove and add)
        //deleting an element from the PriorityQueue
        queue.remove("Task B");
        //printing the PriorityQueue
        System.out.println("Priority Queue: " + queue);

        //HashSet
        HashSet<String> countries = new HashSet<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Mexico");
        countries.add("Brazil");
        //updating an element in the HashSet (there is no direct method to update an element in HashSet, so we can remove and add)
        //deleting an element from the HashSet
        countries.remove("USA");
        //printing the HashSet
        System.out.println("Countries: " + countries);

        //LinkedHashSet
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("Houston");
        //updating an element in the LinkedHashSet (there is no direct method to update an element in LinkedHashSet, so we can remove and add)
        //deleting an element from the LinkedHashSet
        cities.remove("Chicago");
        //printing the LinkedHashSet
        System.out.println("Cities: " + cities);

        //TreeSet
        TreeSet<String> names = new TreeSet<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        //updating an element in the TreeSet (there is no direct method to update an element in TreeSet, so we can remove and add)
        //deleting an element from the TreeSet
        names.remove("Bob");
        //printing the TreeSet
        System.out.println("Names: " + names);
    }
}
