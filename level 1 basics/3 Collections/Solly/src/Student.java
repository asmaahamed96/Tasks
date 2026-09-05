public class Student {
    private Integer id;
    private String name;

    public Student(){

    }

public Student(Integer id,String name){
        this.id=id;
        this.name=name;

}

public Integer getId(Integer id){
        return id;
}

public void setId(){
        this.id=id;
}


    public String getName(String name){
        return name;
    }

    public void setName(){
        this.name=name;
    }
    @Override
    public String toString(){
        return "id : "+id+"name : "+name;
    }

@Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || this.getClass()!=obj.getClass())
        {
            return false;
        }

        Student stu1=this;
        Student stu2=(Student)obj;
        return stu1.id==stu2.id&&stu1.name==stu2.name;
}








}
