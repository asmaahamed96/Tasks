public class StudentServiceImpl implements SchoolService,StudentService,TeacherService{
  @Override
  public void add(){
      System.out.println("add");
  }
    @Override
    public void remove(){
        System.out.println("remove");
    }

    @Override
    public void addStudent(){
        System.out.println("addStudent");
    }
    @Override
    public void removeStudent(){
        System.out.println("removeStudent");
    }


    @Override
    public void addTeacher(){
        System.out.println("addTeacher");
    }
    @Override
    public void removeTeacher(){
        System.out.println("removeTeacher");
    }












}
