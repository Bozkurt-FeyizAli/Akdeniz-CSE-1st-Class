import java.util.*;

public class Assignment04_20220808057 {

    public static void main(String[] args) {
        Department cse = new Department("CSE", "Computer Engineering");
        Teacher teacher = new Teacher("Josep LEDET", "josephledet@akdeniz.edu.tr", 123L, cse, 3);
        System.out.println(teacher);
        Student stu = new Student("Assignment 4 STUDENT", "me@somewhere.com", 456L, cse);
        Semester s1 = new Semester(1,2020 );
        Course c101 = new Course(cse, 101,"Programming 1","Introduction",6, teacher);
        Semester s2 = new Semester(2,2021 );
        Course c102 = new Course(cse, 102,"Programming 2","OOP",4, teacher);
        Course c204 = new Course(cse, 204,"Database Systems","DBMS",6, teacher);

        stu.addCourse(c101, s1,80);
        stu.addCourse(c102, s2,30);
        stu.addCourse(c204, s2,70);
        System.out.println("List Grades for CSE101:\n"+stu.listGrades(c101));
        System.out.println("List Grades for Spring 2021:\n"+stu.listGrades(s2));
        System.out.println("Student Transcript:\n"+stu.transcript());

        GradStudent gs = new GradStudent("Assignment 4 GRADSTUDENT", "me@somewhere.com", 789L, cse,2,"MDE");
        gs.addCourse(c101, s1,85);
        gs.addCourse(c102, s1,40);
        gs.setTeachingAssistant(c101);
        System.out.println("Teaching Assistant:\n"+gs.getTeachingAssistant());
        gs.setTeachingAssistant(c102);
        System.out.println("Teaching Assistant:\n"+gs.getTeachingAssistant());



        
    }

}

class Department{
    private String code;
    private String name;
    private Teacher chair;

    Department(String code,String name){
        this.name=name;
        setCode(code);
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
    
    // public void setChair(Teacher chair) throws DepartmentMismatchException {
    //     if (chair == null) {
    //         this.chair = null;
    //     } else {
    //         if (chair.getDepartment() != this) {
    //             throw new DepartmentMismatchException(this, chair);
    //         }
    //         this.chair = chair;
    //     }
    // }
    public void setChair(Teacher chair) throws DepartmentMismatchException {
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
        if(code.length()==3||code.length()==4){
        this.code = code;
        }else{
            throw new ErrorException();
        }
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Course{
    private Department department;
    private Teacher teacher;
    private double grade;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;

    
    // Course(Department department, int courseNumber, String title, 
    // String description, int AKTS, Teacher teacher) throws DepartmentMismatchException {
    //     if (department != teacher.getDepartment()) {
    //         throw new DepartmentMismatchException(this, teacher);
    //     } else {
    //         setAKTS(AKTS);
    //         setCourseNumber(courseNumber);
    //         this.department = department;
    //         this.teacher = teacher;
    //         setDescription(description);
    //         setTitle(title);
    //     }
    // }

    Course(Department department, int courseNumber, String title, 
    String description, int AKTS, Teacher teacher) throws DepartmentMismatchException {
    if (department != teacher.getDepartment()) {
        throw new DepartmentMismatchException(this, teacher);
    } else {
        setAKTS(AKTS);
        setCourseNumber(courseNumber);
        this.department = department;
        this.teacher = teacher;
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
    
    public void setTeacher(Teacher teacher) throws DepartmentMismatchException {
        if (department != teacher.getDepartment()) {
            throw new DepartmentMismatchException(this, teacher);
        } else {
            this.teacher = teacher;
        }
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
