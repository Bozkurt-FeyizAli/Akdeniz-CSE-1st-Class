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

