// @FEYİZ ALİ BOZKURT @SİNCE 19 March 2024
import java.util.ArrayList;
public class Assignment02_20220808073{
    public static void main(String[] args){
      
        Department cse = new Department("CSE", "Computer Engineering");
        Department cse2 = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "j@akdeniz.edu.tr", 123L, cse, 1);
        Course c101 = new Course(cse, 101, "Programing 1", "İntroduction to Programing", 6, t);
        Course c102 = new Course(cse, 102, "Programing 2", "Object oriented programing", 4, t);
        Student s = new Student("Test Student", "me@gmail.com", 123L, cse);
        s.addCourse(c101, 80);
        s.addCourse(c102, 30);
        System.out.println(s.getAKTS());
        System.out.println(s.getAttemptedAKTS());
        System.out.println(s.getGPA());
        System.out.println(s);
        s = new GradStudent("Test GRADSTUDENT", "me@somewhere.com", 456L, cse,2, "MDE");
        s.addCourse(c101, 80);
        s.addCourse(c102, 70);
        System.out.println(s.getAKTS());
        System.out.println(s.getAttemptedAKTS());
        System.out.println(s.getGPA());
        System.out.println(s);

        cse.setChair(t);
        Department math = new Department("MATH", "Mathematics");
        System.out.println(cse.getCode() + " Chair = " + cse.getChair());
        t.setDepartment(math);
        System.out.println(cse.getCode() + " Chair = " + cse.getChair());
        t.setDepartment(cse);
        System.out.println(cse.getCode() + " Chair = " + cse.getChair());

        
    }
}
class Department{ 
    private String code;
    private String name;
    private Teacher chair;

    Department(String code, String name){
        setCode(code);
        setName(name);   
    }
    public void setChair(Teacher chair) throws DepartmentMismatchException,
                                               GeneralErrorException {
        if (chair == null) {
            this.chair = null; 
        } else {
            if (chair.getDepartment() != this) {
                throw new DepartmentMismatchException(this, chair);
            }
            this.chair = chair;
        }
    }
    public void setCode(String code) {
        if(isCodeValid(code))
            this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Teacher getChair() {
        if (chair != null && chair.getDepartment() == this) {
            return chair;
        } else {
            return null; 
        }
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public boolean isCodeValid(String code) throws GeneralErrorException{
        if((code.length()==3||code.length()==4))
            return true;
        throw new GeneralErrorException("code is invalid.");
    }
}

