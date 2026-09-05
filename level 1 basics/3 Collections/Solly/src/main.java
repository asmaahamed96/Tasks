import java.util.*;

public class main {
    public static void main(String[] args) {
        Student student1=new Student(1,"ahmed");
        Student student2=new Student(2,"osama");
        Student student3=new Student(1,"ali");

        HashMap<Student,Student>map=new HashMap<>();

        map.put(new Student(1,"ahmed"),new Student(1,"ahmed"));
        map.put(new Student(2,"osama"),new Student(2,"osama"));


        System.out.println(map.containsKey(student1));
        System.out.println(map.containsKey(student2));
        System.out.println(map.containsKey(student3));

        System.out.println(map.containsValue(student1));
        System.out.println(map.containsValue(student2));
        System.out.println(map.containsValue(student3));














//        Student student1=new Student(1,"ahmed");
//        Student student2=new Student(2,"osama");
//        Student student3=new Student(1,"ali");
//
//        Set<Student>students=new HashSet<>();
//
//
//
//        students.add(new Student(1,"ahmed"));
//        students.add(new Student(2,"osama"));
//
//
//
//        System.out.println(students.contains(student1));
//        System.out.println(students.contains(student2));
//        System.out.println(students.contains(student3));


























//
//        Set<Integer> names=new HashSet<>();
//        names.add(1);
//        names.add(10);
//        names.add(20);
//        names.add(1);
//        names.add(20);
//        names.add(50);
//
//        System.out.println(names); //1 10 20 50 set مش بتكرر
//






























//       String name1=new String("ahmed");
//        String name2=new String("osama");
//        String name3=new String("ali");
//
//        ArrayList<String>names=new ArrayList<>();
//
//        names.add(new String("ahmed"));
//        names.add(new String("osama"));
//
//
//        System.out.println(names.contains(name1));
//        System.out.println(names.contains(name2));
//        System.out.println(names.contains(name3));




















//        Student student1=new Student(1,"ahmed");//ref
//        Student student2=new Student(2,"osama");//ref
//        Student student3=new Student(1,"ahmed");//ref
//
//        ArrayList<Student>students=new ArrayList<>();
//
//
//
//        students.add(new Student(1,"ahmed"));//ref
//        students.add(new Student(2,"osama"));//ref
//
//
//
//        System.out.println(students.contains(student1)); //false
//        System.out.println(students.contains(student2)); //false
//        System.out.println(students.contains(student3)); //false


//contain جواها ref عشان كدا كلهم غلط
        //contain مرتبطة بال equals
        //لو عملت override ل equals بالتالي contain هتشاور ع ال value




















//Teacher teacher=new Teacher(1,"ahmed");



// System.out.println("-----------------------------------------");
// //equals
//        System.out.println(student3.equals(teacher)); //false
//        System.out.println(student1.equals(null));//false
//        System.out.println(student3.equals(student3));//true
















    }
}
