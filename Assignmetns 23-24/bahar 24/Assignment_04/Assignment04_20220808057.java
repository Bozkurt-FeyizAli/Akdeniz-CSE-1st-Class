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
    public void setAKTS(int AKTS) {
        if(AKTS>0){
        this.AKTS = AKTS;
        }
        else{
            throw new ErrorException();
        }
    }
    public void setCourseNumber(int courseNumber) {
        if((courseNumber>=100&&courseNumber<=999)||
        (courseNumber>=5000&&courseNumber<=5999)||
        (courseNumber>=7000&&courseNumber<=7999)){
        this.courseNumber = courseNumber;
        }
        else{
            throw new ErrorException();
        }
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return courseCode()+" - "+title+" ("+AKTS+")";
    }
    public String courseCode(){
        return department.getCode()+courseNumber;
    }
}

abstract class Person{
    private String name;
    private String email;
    private long ID;
    private Department department;
    Person(String name,String email,long ID,Department department){
        this.department=department;
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
    public void setID(long id) {
        ID = id;
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
    public boolean isEmailValid(String email){
        if     (!email.contains("@"))
                {return false;}
        else if(!email.contains("."))
                {return false;}
        else if((email.indexOf("@", 2)-
                email.indexOf(".",email.indexOf("@")))>-2)
                {return false;}           
        else 
                {return true;}
        }
        public void setEmail(String email){
            if(isEmailValid(email))
                this.email=email;
            else {
                throw new ErrorException();
            }
        }
        @Override
        public String toString() {
            return name+ " "+" ("+ ID+")" +" - "+ email;
    }
}

class Teacher extends Person{

    private int rank;


    Teacher(String name,String email,long ID,Department department,int rank){
        super(name, email, ID, department);
        setDepartment(department);
        setRank(rank);
    }

    @Override
    public void setDepartment(Department department) {
        if(this.getDepartment()!=null){
        if(this.getDepartment().getChair()==this)
        this.getDepartment().setChair(null);}
        super.setDepartment(department);
    }
    private void setRank(int rank) {
        if(rank<6&&rank>0){
            this.rank = rank;
            }
        else{
            throw new InvalidRankException(rank);
            }
    }
    public int getRank() {
        return rank;
    }
    public String getTitle(){
        switch (rank) {
            case 1:
            return "Lecturer";
            case 2:
            return "Adjunct Instructor";  
            case 3:
                return "Assistant Professor";
            case 4:
                return "Associate Professor";
            default:
            return "Professor";
        }
    }
    public void promote(){
        if(rank!=5)
        rank++;
        else
        throw new InvalidRankException(rank);
    }
    public void demote(){
        if(rank!=1)
        rank--;
        else
        throw new InvalidRankException(rank);
    }
    @Override
    public String toString() {
        return getTitle()+" "+super.toString();
    }
}


class Student extends Person {
    private int AKTS;
    private int passedAKTS;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    //added
    private HashMap<Course, Double> courseWithMaxGrade= new HashMap<>();


    Student(String name, String email, long number, Department department) {
        super(name, email, number, department);
        AKTS = 0;
        courses = new ArrayList<>();
    }
    //added
    public HashMap<Course, Double> getCourseWithMaxGrade() {
        return courseWithMaxGrade;
    }

    public void setPassedAKTS(Course course) {
        if (course.getGrade() >= 60) {
            passedAKTS += course.getAKTS();
        }
    }

    
    // public void addCourse(Course course, Semester semester, double grade) throws InvalidGradeException {
    //     enrollments.add(new Enrollment(this, course, semester, grade));
    //     if (grade >= 0 && grade <= 100) {
    //         if (exists(courses, course)) {
    //             courses.get(existsindx(courses, course)).setGrade(grade);
    //         } else {
    //             courses.add(course);
    //             courses.get(existsindx(courses, course)).setGrade(grade);
    //         }
    //         AKTS += course.getAKTS();
    //     } 
    //     else {
    //         throw new InvalidGradeException(grade);
    //     }
    // }

    // public void addCourse(Course course, Semester semester, double grade) throws InvalidGradeException {
    //     enrollments.add(new Enrollment(this, course, semester, grade));
    //     if (grade >= 0 && grade <= 100) {
    //         if (exists(courses, course)) {
    //             courses.get(existsindx(courses, course)).setGrade(grade);
    //         } else {
    //             courses.add(course);
    //             courses.get(courses.size() - 1).setGrade(grade);
    //         }
    //         AKTS += course.getAKTS();
    //     } else {
    //         throw new InvalidGradeException(grade);
    //     }
    // }

    public void addCourse(Course course, Semester semester, double grade) throws InvalidGradeException {
        enrollments.add(new Enrollment(this, course, semester, grade));
        if (grade >= 0 && grade <= 100) {
            if (exists(courses, course)) {
                courses.get(existsindx(courses, course)).setGrade(grade);
            } else {
                courses.add(course);
                courses.get(courses.size() - 1).setGrade(grade);
            }
            AKTS += course.getAKTS();

            //added
            courseWithMaxGrade.putIfAbsent(course, grade);
            if(grade>courseWithMaxGrade.get(course))
                courseWithMaxGrade.put(course, grade);

        } else {
            throw new InvalidGradeException(grade);
        }
    }
    
    
    

    public int getAttemptedAKTS() {
        return AKTS;
    }

    public int getAKTS() {
        return passedAKTS;
    }

    // public boolean exists(ArrayList<Course> courses, Course course) {
    //     for (int i = 0; i < courses.size(); i++) {
    //         if (courses.get(i).getCourseNumber() == course.getCourseNumber()) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public boolean exists(ArrayList<Course> list, Course x) {
        for (Course element : list) {
            if (element.getCourseNumber() == x.getCourseNumber())
                return true;
        }
        return false;
    }

    // public int existsindx(ArrayList<Course> courses, Course course) {
    //     for (int i = 0; i < courses.size(); i++) {
    //         if (courses.get(i).getCourseNumber() == course.getCourseNumber()) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    public int existsindx(ArrayList<Course> list, Course x) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getCourseNumber() == x.getCourseNumber())
            return i;
    }
    return -1;
}

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public double courseGPAPoints(Course course) throws CourseNotFoundException {
        if (!exists(courses, course)) {
            throw new CourseNotFoundException();
        } else {
            if (course.getGrade() > 87)
                return 4.0;
            else if (course.getGrade() > 80)
                return 3.5;
            else if (course.getGrade() > 73)
                return 3.0;
            else if (course.getGrade() > 66)
                return 2.5;
            else if (course.getGrade() > 59)
                return 2.0;
            else if (course.getGrade() > 52)
                return 1.5;
            else if (course.getGrade() > 45)
                return 1.0;
            else if (course.getGrade() > 34)
                return 0.5;
            else
                return 0.0;
        }
    }

    public String courseGradeLetter(Course course) throws CourseNotFoundException {
        if (!exists(courses, course)) {
            throw new CourseNotFoundException();
        } else {
            if (course.getGrade() > 87)
                return "AA";
            else if (course.getGrade() > 80)
                return "BA";
            else if (course.getGrade() > 73)
                return "BB";
            else if (course.getGrade() > 66)
                return "CB";
            else if (course.getGrade() > 59)
                return "CC";
            else if (course.getGrade() > 52)
                return "DC";
            else if (course.getGrade() > 45)
                return "DD";
            else if (course.getGrade() > 34)
                return "FD";
            else
                return "FF";
        }
    }

    public String courseResult(Course course) throws CourseNotFoundException {
        if (!exists(courses, course)) {
            throw new CourseNotFoundException();
        } else {
            if (course.getGrade() > 87)
                return "Passed";
            else if (course.getGrade() > 80)
                return "Passed";
            else if (course.getGrade() > 73)
                return "Passed";
            else if (course.getGrade() > 66)
                return "Passed";
            else if (course.getGrade() > 59)
                return "Passed";
            else if (course.getGrade() > 52)
                return "Conditionally Passed";
            else if (course.getGrade() > 45)
                return "Conditionally Passed";
            else if (course.getGrade() > 34)
                return "Failed";
            else
                return "Failed";
        }
    }

    public double getGPA() {
        double getGPA = 0;
        for (int i = 0; i < courses.size(); i++) {
            getGPA += courseGPAPoints(courses.get(i)) * courses.get(i).getAKTS();
        }
        return getGPA / AKTS;
    }

    @Override
    public String toString() {
        return super.toString() + "-GPA:" + getGPA();
    }

        
    public String listGrades(Course course) {
        StringBuilder sb = new StringBuilder();
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                sb.append(e.getSemester()).append(" - ").append(e.courseGradeLetter()).append("\n");
            }
        }
        return sb.toString();
    }

    public String listGrades(Semester semester) {
        StringBuilder sb = new StringBuilder();
        for (Enrollment e : enrollments) {
            if (e.getSemester().equals(semester)) {
                // sb.append(e.getCourse()).append(" - "+e.courseGradeLetter()).append("\n");
                sb.append(e.getCourse().courseCode()).append(" - "+e.courseGradeLetter()).append("\n");
            }
        }
        return sb.toString();
    }

// public String transcript() {
//     StringBuilder sb = new StringBuilder();
//     double totalGPA = 0.0;
//     int totalCourses = 0;

//     for (Enrollment e : enrollments) {
//         sb.append(e.getSemester()).append("  \n\t")
//                 .append(e.getCourse().courseCode())
//                 .append(" - ")
//                 .append(e.courseGradeLetter()).append("\n");

//         totalGPA += e.getGPA() * e.getCourse().getAKTS();
//         totalCourses += e.getCourse().getAKTS();

//         sb.append("GPA: ").append(e.getGPA()).append("\n\n");
//     }

//     double overallGPA = totalGPA / totalCourses;
//     sb.append("Overall GPA: ").append(overallGPA).append("\n");

//     return sb.toString();
// }

public String transcript() {
    StringBuilder sb = new StringBuilder();
    double totalGPA = 0.0;
    int totalCourses = 0;

    // Dönemlerin listesini tutmak için bir HashSet oluşturuyoruz
    HashSet<Semester> semesters = new HashSet<>();
    for (Enrollment e : enrollments) {
        semesters.add(e.getSemester());
    }

    // Her dönem için ayrı ayrı notları listeliyoruz
    for (Semester semester : semesters) {
        sb.append(semester).append("\n");

        double semesterGPA = 0.0;
        int semesterCourses = 0;

        for (Enrollment e : enrollments) {
            if (e.getSemester().equals(semester)) {
                sb.append("\t").append(e.getCourse().courseCode())
                  .append(" - ").append(e.courseGradeLetter()).append("\n");

                semesterGPA += e.getGPA() * e.getCourse().getAKTS();
                semesterCourses += e.getCourse().getAKTS();
            }
        }

        double semesterOverallGPA = semesterGPA / semesterCourses;
        sb.append("GPA: ").append(semesterOverallGPA).append("\n\n");

        totalGPA += semesterGPA;
        totalCourses += semesterCourses;
    }

    double overallGPA = totalGPA / totalCourses;
    sb.append("Overall GPA: ").append(overallGPA).append("\n");

    return sb.toString();
}


}


class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    private Course teachingAssistant;
    private long studentID;
    private HashSet<String> coursesTaken;

    public void addCourseTaken(String courseCode) {
        coursesTaken.add(courseCode);
    }
    //added
    GradStudent(String name, String email, long number, Department department,
                int rank, String thesisTopic) throws InvalidRankException{
        super(name, email, number, department);
        setRank(rank);
        setThesisTopic(thesisTopic);
    }
    public void setRank(int rank)throws InvalidRankException {
        if(rank>=1&&rank<=3){
            this.rank=rank;
        }else{
            throw new InvalidRankException(rank);
        }
    }
    public String getLevel(){
        switch(rank){
            case 1: 
                return "Master's Student";
            case 2:
                return "Doctoral Student";
            default:
                return "Doctoral Candidate";
        }
    }
    public String getThesisTopic() {
        return thesisTopic;
    }
    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

        public List<Course> getCoursesTaken() {
            List<Course> coursesTaken = new ArrayList<>();
            return coursesTaken;
        }
    
    //added
    public void setTeachingAssistant(Course course) {
        if(getCourseWithMaxGrade().containsKey(course)){
            if(getCourseWithMaxGrade().get(course)>=80)
                teachingAssistant=course;
            else
            throw new CourseNotFoundException(course, this);    
        }
        else
        throw new CourseNotFoundException(course, this);
    }
    
    
    // public String getTeachingAssistant() {
    //     Course e = teachingAssistant;
    //     e.courseCode();
    //     return e.courseCode() + " - " + e.getTitle()+"("+e.getAKTS()+")";
    // }
    public Course getTeachingAssistant() {
        return teachingAssistant;
    }
    
    
    

    @Override
   public double courseGPAPoints(Course course) throws CourseNotFoundException{
        if(!exists(getCourses(), course)){
            throw new CourseNotFoundException();
        }else{
        if(course.getGrade()>89)
        return 4.0;
        else if(course.getGrade()>84)
        return 3.5;
        else if(course.getGrade()>79)
        return 3.0;
        else if(course.getGrade()>74)
        return 2.5;
        else if(course.getGrade()>69)
        return 2.0;
        else 
        return 0.0;
        }
    }

    @Override
    public String courseGradeLetter(Course course)
              throws CourseNotFoundException {
        if(!exists(getCourses(), course)){
            throw new CourseNotFoundException();
        }else{
        if(course.getGrade()>89)
        return "AA";
        else if(course.getGrade()>84)
        return "BA";
        else if(course.getGrade()>79)
        return "BB";
        else if(course.getGrade()>74)
        return "CB";
        else if(course.getGrade()>69)
        return "CC";
        else 
        return "FF";
        }   
    }
    @Override
    public String courseResult(Course course) throws CourseNotFoundException{
        if(!exists(getCourses(), course)){
            throw new CourseNotFoundException();
        }else{
        if(course.getGrade()>89)
        return "Passed";
        else if(course.getGrade()>84)
        return "Passed";
        else if(course.getGrade()>79)
        return "Passed";
        else if(course.getGrade()>74)
        return "Passed";
        else if(course.getGrade()>69)
        return "Passed";
        else 
        return "Failed";
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

class Semester {
    private final int season;
    private final int year;

    public Semester(int season, int year) {
        if (season < 1 || season > 3) {
            throw new IllegalArgumentException("Invalid season");
        }
        this.season = season;
        this.year = year;
    }

    public String getSeason() {
        switch (season) {
            case 1:
                return "Fall";
            case 2:
                return "Spring";
            case 3:
                return "Summer";
            default:
                return "Unknown";
        }
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return getSeason() + " - " + year;
    }
}

class Enrollment {
    private ArrayList<Course> courses;
    private Student student;
    private Course course;
    private Semester semester;
    private double grade;
    

    Enrollment(Student student, Course course, Semester semester, double grade) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.grade = grade;
    }

    public boolean exists(ArrayList<Course> list, Course x) {
        for (Course element : list) {
            if (element.getCourseNumber() == x.getCourseNumber())
                return true;
        }
        return false;
    }

public int existsindx(ArrayList<Course> list, Course x) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getCourseNumber() == x.getCourseNumber())
            return i;
    }
    return -1;
}

public double getGPA() {
    if (this.grade > 87)
        return 4.0;
    else if (this.grade > 80)
        return 3.5;
    else if (this.grade > 73)
        return 3.0;
    else if (this.grade > 66)
        return 2.5;
    else if (this.grade > 59)
        return 2.0;
    else if (this.grade > 52)
        return 1.5;
    else if (this.grade > 45)
        return 1.0;
    else if (this.grade > 34)
        return 0.5;
    else
        return 0.0;
}

public double courseGPAPoints() {
    if (this.grade > 87)
        return 4.0;
    else if (this.grade > 80)
        return 3.5;
    else if (this.grade > 73)
        return 3.0;
    else if (this.grade > 66)
        return 2.5;
    else if (this.grade > 59)
        return 2.0;
    else if (this.grade > 52)
        return 1.5;
    else if (this.grade > 45)
        return 1.0;
    else if (this.grade > 34)
        return 0.5;
    else
        return 0.0;
}

public String courseGradeLetter() {
    if (this.grade > 87)
        return "AA";
    else if (this.grade > 80)
        return "BA";
    else if (this.grade > 73)
        return "BB";
    else if (this.grade > 66)
        return "CB";
    else if (this.grade > 59)
        return "CC";
    else if (this.grade > 52)
        return "DC";
    else if (this.grade > 45)
        return "DD";
    else if (this.grade > 34)
        return "FD";
    else
        return "FF";
}

public String courseResult() {
    if (this.grade > 87)
        return "Passed";
    else if (this.grade > 80)
        return "Passed";
    else if (this.grade > 73)
        return "Passed";
    else if (this.grade > 66)
        return "Passed";
    else if (this.grade > 59)
        return "Passed";
    else if (this.grade > 52)
        return "Conditionally Passed";
    else if (this.grade > 45)
        return "Conditionally Passed";
    else if (this.grade > 34)
        return "Failed";
    else
        return "Failed";
}

    public Course getCourse() {
        return course;
    }

    public Semester getSemester() {
        return semester;
    }

    public double getGrade() {
        return grade;
    }
    @Override
public String toString() {
    return course.courseCode() + " - " + course.getTitle() + " (" + course.getAKTS() + ")" + ": " + grade;
}
}

// SemesterNotFoundException
class SemesterNotFoundException extends RuntimeException {
    private final Student student;
    private final Semester semester;

    public SemesterNotFoundException(Student student, Semester semester) {
        this.student = student;
        this.semester = semester;
    }
    
    @Override
    public String toString() {
        return "SemesterNotFoundException: " + student.getID() + " has not taken any courses in " + semester;
    }
}

class ErrorException extends RuntimeException{
    @Override
    public String toString(){
        return "ErrorException : "+ getMessage();
    }
}
class InvalidRankException extends RuntimeException{
    int rank;
    InvalidRankException(int rank){
        this.rank=rank;
    }
    @Override
    public String toString(){
        return "InvalidRankException: " + rank ;
    }
}
class InvalidGradeException extends RuntimeException{
    double grade;
    InvalidGradeException(double grade){
       setGrade(grade);
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString(){
        return String.format("InvalidGradeException:  %f",  grade);
    }
}

class CourseNotFoundException extends RuntimeException{
    private Course course;
    private Student student;
    CourseNotFoundException(){

    }
    CourseNotFoundException(Course course, Student student){
        this.student=student;
        this.course=course;
    }
    @Override
    public String toString() {
        
        return "CourseNotFoundException: " + student.getID() + 
        " has not yet taken " + course.courseCode();
    }
}
class DepartmentMismatchException extends RuntimeException{
    private Department department;
    private Teacher person;
    private Course course;
    DepartmentMismatchException(Course course,Teacher person){
        this.course = course;
        this.person = person;
        department = null;
    }
    DepartmentMismatchException(Department department,Teacher person){
        this.department = department;
        this.person = person;
        course = null;
    }
    @Override
    public String toString() {
        if(course == null){
            return "DepartmentMismatchException: " + person.getName()+
            " ("+ person.getID()+") cannot be chair of " + department.getCode()+" because he"+
            "/she is currently assigned to "+ person.getDepartment().getCode();
        }
        else{
            return "DepartmentMismatchException: " + person.getName()+
            " ("+ person.getID()+") cannot teach " + course.courseCode()+" because he"+
            "/she is currently assigned to "+ person.getDepartment();
        }

    }
}

// class DepartmentMismatchException extends Exception {
//     public DepartmentMismatchException(Department d, Teacher t) {
//         super("Department mismatch: " + d.getName() + " and " + t.getDepartment().getName());
//     }

//     public DepartmentMismatchException(Course c, Teacher t) {
//         super("Department mismatch: " + c.getDepartment().getName() + " and " + t.getDepartment().getName());
//     }
// }

// class InvalidGradeException extends RuntimeException {
//     public InvalidGradeException(double grade) {
//         super("Invalid grade: " + grade);
//     }
// }
// class ErrorException extends RuntimeException {
//     public ErrorException() {
//         super("Error");
//     }
// }
