import java.util.ArrayList;
/*
 * @author yunus turan
 * since 05.04.2024
 */
public class Assignment02_20230808049{
    public static void main(String[] args) {
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        System.out.println(s);
        // Course c101 = new Course(cse, 101, "Programing 1", "İntroduction to Programing", 6, t);
        // Course c102 = new Course(cse, 102, "Programing 2", "Object oriented programing", 4, t);
        // Student s = new Student("Test Student", "me@gmail.com", 123L, cse);
        // s.addCourse(c101, 80);
        // s.addCourse(c102, 30);
        // System.out.println(s.getAKTS());
        // System.out.println(s.getAttemptedAKTS());
        // System.out.println(s.getGPA());
        // System.out.println(s);
        // s = new GradStudent("Test GRADSTUDENT", "me@somewhere.com", 456L, cse,2, "MDE");
        // s.addCourse(c101, 80);
        // s.addCourse(c102, 70);
        // System.out.println(s.getAKTS());
        // System.out.println(s.getAttemptedAKTS());
        // System.out.println(s.getGPA());
        // System.out.println(s);

        // cse.setChair(t);
        // Department math = new Department("MATH", "Mathematics");
        // System.out.println(cse.getCode() + " Chair = " + cse.getChair());
        // t.setDepartment(math);
        // System.out.println(cse.getCode() + " Chair = " + cse.getChair());
        // t.setDepartment(cse);
        // System.out.println(cse.getCode() + " Chair = " + cse.getChair());
    }
}

class Course{
    private Department department;
    private Teacher teacher;
    private double grade;
    //private String departmentCode;//must be 3 or 4 characters
    private int courseNumber;//must be 100-999 or 5000-5999 or 7000-7999
    private String title;
    private String description;
    private int AKTS;//must be positive
    Course(Department department,int courseNumber,
    String title,String description,int AKTS,Teacher teacher) throws DepartmentMismatchException{
        if(department!=teacher.getDepartment()){
            throw new DepartmentMismatchException(this, teacher);
        }else{
        setAKTS(AKTS);
        setCourseNumber(courseNumber);
        this.department=department;
        this.teacher=teacher;
        //setDepartmentCode(departmentCode);
        setDescription(description);
        setTitle(title);
        }
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public int getAKTS() {
        return AKTS;
    }

    public int getCourseNumber() {
        return courseNumber;
    }
    
    public Department getDepartment() {
        return department;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setTeacher(Teacher teacher)throws DepartmentMismatchException {
        if(department!=teacher.getDepartment()){
            throw new DepartmentMismatchException(this, teacher);
        }else{
            this.teacher=teacher;
        }
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setAKTS(int AKTS) {
        if(AKTS>0){
        this.AKTS = AKTS;
        }else{
            throw new myException();
        }
    }

    public void setCourseNumber(int courseNumber) {
        if((courseNumber>=100&&courseNumber<=999)||
        (courseNumber>=5000&&courseNumber<=5999)||
        (courseNumber>=7000&&courseNumber<=7999)){
        this.courseNumber = courseNumber;
        }else{
            throw new myException();
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String courseCode(){
        return String.format("%s%d-%s(%d)",department.getCode(),courseNumber,title,AKTS);
    }

    @Override
    public String toString() {
        return String.format("%s%d - %s (%d)",
        department.getCode(),courseNumber,title,AKTS);
    }
}

abstract class Person{
    private String name;
    private String email;
    private long ID;
    private Department department;
    Person(String name,String email,long ID,Department department){
        this.department=department;
        //setDepartmentCode(departmentCode);
        setEmail(email);
        setID(ID);
        setName(name);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
    
    public void setID(long iD) {
        ID = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        if(email.contains("@")&&email.contains(".")){

            int i =email.indexOf("@");

            String sub1=email.substring(0, i);

            if(sub1.equals(email)){
                throw new myException();
            }else{

            if(sub1.equals("@")){
                throw new myException();
            }else{

            String sub2=email.substring(i+1);

            if(sub2.contains(".")){

                if(sub2.contains("@")){

                throw new myException();
                
                }else{
                    this.email=email;
                }
            }else{
                throw new myException();
             } }
            }
        }else{
            throw new myException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s",name,ID,email );
    }
}

class Teacher extends Person{
    private int rank;
    /*if the teacher has a department first make the current chair 
     * null then assign the teacher to new department
     */

    Teacher(String name,String email,long number,Department department,int rank)throws myException{
        super(name, email, number, department);
        if(rank>5||rank<1){
            throw new InvalidRankException(rank);
        }
        this.rank=rank;
    }

    @Override
    public void setDepartment(Department department) throws myException{
        if (department == null) {
            throw new myException();
        } else {
            Department currentDepartment = getDepartment();
            if (currentDepartment != null && currentDepartment.getChair() == this) {
                try {
                    currentDepartment.setChair(null);
                } catch (MatchException e) {
                    System.out.println("Failed to set chair: " + e.getMessage());
                }
            }
            super.setDepartment(department);
        }
    }

    public int getRank() {
        return rank;
    }

    public void promote()throws InvalidRankException{//?
        if(rank>=1&&rank<5){
            rank++;
        }else{
            throw new InvalidRankException(rank);
        }
    }

    public void demote()throws InvalidRankException{//?
        if(rank>1&&rank<=5){
            rank--;
        }else{
            throw new InvalidRankException(rank);
        }
    }
