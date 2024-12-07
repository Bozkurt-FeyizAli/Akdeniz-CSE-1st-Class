// @FEYİZ ALİ BOZKURT @SİNCE 19 May 2024
import java.util.HashSet;
import java.util.TreeMap;
public class Assignment04_20220808073{

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
        throw new GeneralErrorException(" Department code is invalid vith value"+
                          code.length()+" valid values are 3 nd; 4");
    }
}

class Course implements Comparable<Course>{
    private Department department;
    private Teacher teacher;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;
    private double GPA;
    
    public boolean isDepartmentCodeVaild(String department) throws 
                                             GeneralErrorException{
        return (department.length()==3||department.length()==4);
    }
    public boolean isCourseNumberValid(int courseNumber){
        if     (courseNumber>=100&& courseNumber<1000) return true ;
        else if(courseNumber>=5000&&courseNumber<6000) return true ;
        else if(courseNumber>=7000&&courseNumber<8000) return true ;
        else 
        throw new 
        GeneralErrorException("Course , department code is invalid with value "+courseNumber+
                             " valid values 100-999 , 5000-5999 , 7000-7999");
    }
    public boolean isAKTSValid(int AKTS) throws GeneralErrorException{
        if (AKTS>0)
            return true;
        else throw new GeneralErrorException("Course AKTS is invalid with value "+AKTS+" it must be poisitive.");
    }
    Course(Department department,int courseNumber,
           String title, String description, 
           int AKTS, Teacher teacher){
        this.department=department;
        setCourseNumber(courseNumber);
        setTitle(title);
        setDescription(description);
        setAKTS(AKTS);
         if((teacher.getDepartment()!=department))
            throw new DepartmentMismatchException(department, teacher);
        else 
            setTeacher(teacher);
    }
    public double getGPA() {
        return GPA;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setTeacher(Teacher teacher){
        if(teacher.getDepartment()==department)
            this.teacher = teacher;
        else    
        throw new DepartmentMismatchException(department, teacher);          
    }
    public void setDepartmentCode(String departmentCode){
        if(isDepartmentCodeVaild(departmentCode))
            setDepartmentCode(departmentCode);
    } 
    public int getCourseNumber(){
        return courseNumber;
    }
    public void setCourseNumber(int courseNumber){
        if(isCourseNumberValid(courseNumber))
            this.courseNumber=courseNumber;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public int getAKTS(){
        return AKTS;
    }
    public void setAKTS(int AKTS){
        if(isAKTSValid(AKTS))
            this.AKTS=AKTS;    
    }
    public String courseCode(){
        return department.getCode()+Integer.toString(courseNumber);
    }
    @Override
    public String toString(){
        return String.format
    ("%s%d - %s (%d)", department.getCode(), courseNumber, 
                              title, AKTS);
    }
    @Override
    public int compareTo(Course o) {
        return courseCode().compareTo(o.courseCode());
    }
}

abstract class Person{
    private Department department;
    private String name;
    private String email;
    private long ID;
    // private String departmentCode;
    public double grade;
    
    public boolean isDepartmentCodeVaild(String departmentCode) 
                                   throws GeneralErrorException{
        if(departmentCode==null)
            throw new 
            GeneralErrorException("Department code is invalid vith value"+
        "null"+" valid values are 3 nd; 4");
        if(departmentCode.length()==3||departmentCode.length()==4)
            return true;
        else 
        throw new 
        GeneralErrorException("Department code is invalid vith value"+
        departmentCode.length()+" valid values are 3 nd; 4");
    }
    //  {username}@{university name}.{domain}
    public double getGPA() {
        double GPA=0;
        HashSet<Course> courses= new HashSet<>();
        for (var sCG : studentCourses.entrySet()) {
            for (var cG : sCG.getValue().entrySet()) {
                courses.add(cG.getKey());
            }
        } 
        for (Course course : courses) {
                GPA+=courseGPAPoints(course)*course.getAKTS();
        }
        return GPA/getAttemptedAKTS();
    }
    public boolean isCourseTaken(Course course){
        for (var studentCourse : studentCourses.entrySet()) {
           if(studentCourse.getValue().containsKey(course))
                return true;
        }
        return false; 
    }
    public void addCourse(Course course, Semester semester, double grade) throws InvalidGradeException{
        isGradeInvalid(grade);
        if(course==null||semester==null)
            throw new GeneralErrorException("Student value is invalid ");
        TreeMap<Course, Double> courseGrade=studentCourses.get(semester);
        if (courseGrade==null) {
            courseGrade=new TreeMap<>();
            studentCourses.put(semester, courseGrade);
        }
        courseGrade.put(course, grade);
        
    }
    public  String gradeLetter(double grade ){
        if      (grade>=87.5) return "AA"; 
        else if (grade>=80.5) return "BA";
        else if (grade>=73.5) return "BB";
        else if (grade>=66.5) return "CB";
        else if (grade>=59.5) return "CC";
        else if (grade>=52.5) return "DC";
        else if (grade>=45.5) return "DD";
        else if (grade>=34.5) return "FD";
        else                  return "FF";
    }
    public double GPAPoints(double result) {
                 if (result>=87.5) return 4.0;
            else if (result>=80.5) return 3.5;    
            else if (result>=73.5) return 3.0;
            else if (result>=66.5) return 2.5; 
            else if (result>=59.5) return 2.0;     
            else if (result>=52.5) return 1.5;          
            else if (result>=45.5) return 1.0;
            else if (result>=34.5) return 0.5;    
            else                   return 0.0;  
        }
    public TreeMap<Semester, TreeMap<Course, Double>> getStudentCourses() {
        return studentCourses;
    }
    public String listGrades(Semester semester) throws SemesterNotFoundException{
        if(!studentCourses.keySet().contains(semester))
            throw new SemesterNotFoundException(this, semester);
        String message="";
        for (var coursesGrade : studentCourses.get(semester).entrySet()) {
            Course c= coursesGrade.getKey();
            message+= c.courseCode()+" - "+gradeLetter(coursesGrade.getValue())+"\n";
        }
        return message;   
    }
    public String listGrades(Course course){
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        String message="";
        for (var sCG : studentCourses.entrySet()) {
            Semester s=sCG.getKey();
            TreeMap<Course, Double> cG=sCG.getValue();
            for (var courseGrade : cG.entrySet()) {
                if(courseGrade.getKey()==course)
                    message+=  s.toString()+" - "+gradeLetter(courseGrade.getValue())+"\n";           
            }
        }
        return message;
    }
    public String transcript(){
        String message="";
        double GPA=0;
        int AKTS=0;
        for (var sCG : studentCourses.entrySet()) {
            Semester s=sCG.getKey();
            message+=s.toString()+"\n";
            TreeMap<Course, Double> cG=sCG.getValue();
            AKTS=0;
            GPA=0;
            for (var cg : cG.entrySet()) {
                Course c=cg.getKey();
                message+="   d"+c.courseCode()+" - "+courseGradeLetter(c)+"\n";
                GPA+=GPAPoints(cg.getValue())*cg.getKey().getAKTS();
                AKTS+=cg.getKey().getAKTS();
            }
            message+="GPA: - "+GPA/AKTS+"\n\n";
        }
        message+="OverallGPA: "+getGPA();
        return message;
    }
    
    public void isGradeInvalid(double grade) throws InvalidGradeException{
        if(grade>100||grade<0)
            throw new InvalidGradeException(grade);   
    }
    public double getHGrade(Course course) throws CourseNotFoundException{
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        double grdReturn=-1;
        for (var sc : studentCourses.entrySet()) {
            TreeMap<Course, Double> cg=sc.getValue();
            for (var g : cg.entrySet()) {
                if(g.getKey()==course){
                    if(g.getValue()>grdReturn)
                        grdReturn=g.getValue();
                }
                    
            }
        }
        return grdReturn;
    }
    public double courseGPAPoints(Course course) {
        double result=getHGrade(course);
                 if (result>=87.5) return 4.0;
            else if (result>=80.5) return 3.5;    
            else if (result>=73.5) return 3.0;
            else if (result>=66.5) return 2.5; 
            else if (result>=59.5) return 2.0;     
            else if (result>=52.5) return 1.5;          
            else if (result>=45.5) return 1.0;
            else if (result>=34.5) return 0.5;    
            else                   return 0.0;  
        }
    public String courseGradeLetter(Course course) {   
        double result =getHGrade(course);
             if (result>=87.5) return "AA";
        else if (result>=80.5) return "BA";    
        else if (result>=73.5) return "BB";
        else if (result>=66.5) return "CB"; 
        else if (result>=59.5) return "CC";     
        else if (result>=52.5) return "DC";          
        else if (result>=45.5) return "DD";
        else if (result>=34.5) return "FD";    
        else                   return "FF";
    }
    public String courseResult(Course course) {
            double result =getHGrade(course);
             if (result>=59.5) return               "Passed";              
        else if (result>=45.5) return "Conditionally Passed";  
        else                   return               "Failed";
    }
    @Override
    public String toString() throws GeneralErrorException{ 
        if(getGPA()<=4.00&&getGPA()>=0.00){
        return  super.toString() + " – GPA: " + getGPA(); 
        }
        else throw new GeneralErrorException("GPA is invalid");
    }
}

class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    private Course TeachingAssistant;
    GradStudent(String name, String email, long number, Department department,
                int rank, String thesisTopic) throws InvalidRankException{
        super(name, email, number, department);
        setRank(rank);
        setThesisTopic(thesisTopic);
    }
    public void setRank(int rank) throws InvalidRankException{
        if(rank>0&&rank<4)
            this.rank=rank;
        else 
            throw new InvalidRankException(rank);
    }
    public void setTeachingAssistant(Course course) throws CourseNotFoundException{
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        if(getHGrade(course)>=80)
            TeachingAssistant=course;
        else 
            throw new CourseNotFoundException(this, course);
    }
    public Course getTeachingAssistant(){
        return TeachingAssistant;
    }
    @Override
    public String listGrades(Semester semester) throws SemesterNotFoundException{
        if(getStudentCourses().get(semester).size()==0)
            throw new SemesterNotFoundException(this, semester);
        String message="";
        for (var coursesGrade : getStudentCourses().get(semester).entrySet()) {
            Course c= coursesGrade.getKey();
            message+= c.courseCode()+" - "+gradeLetter(coursesGrade.getValue())+"\n";
        }
        return message;   
    }
    @Override
    public String listGrades(Course course){
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        String message="";
        for (var sCG : getStudentCourses().entrySet()) {
            Semester s=sCG.getKey();
            TreeMap<Course, Double> cG=sCG.getValue();
            for (var courseGrade : cG.entrySet()) {
                if(courseGrade.getKey()==course)
                    message+=  s.toString()+" - "+gradeLetter(courseGrade.getValue());           
            }
        }
        return message;
    }
    @Override
    public String transcript(){
        String message="";
        double GPA=0;
        int AKTS=0;
        for (var sCG : getStudentCourses().entrySet()) {
            Semester s=sCG.getKey();
            message+=s.toString()+"\n";
            TreeMap<Course, Double> cG=sCG.getValue();
            AKTS=0;
            GPA=0;
            for (var cg : cG.entrySet()) {
                Course c=cg.getKey();
                message+="   "+c.courseCode()+" - "+courseGradeLetter(c)+"\n";
                GPA+=GPAPoints(cg.getValue())*cg.getKey().getAKTS();
                AKTS+=cg.getKey().getAKTS();
            }
            message+="GPA: - "+GPA/AKTS+"\n\n";
        }
        message+="OverallGPA: "+getGPA();
        return message;
    }
    @Override
    public double courseGPAPoints(Course course)
                    throws CourseNotFoundException{
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        double result =getHGrade(course);
             if (result>=89.5) return 4.0;
        else if (result>=84.5) return 3.5;    
        else if (result>=79.5) return 3.0;
        else if (result>=74.5) return 2.5; 
        else if (result>=69.5) return 2.0;    
        else                   return 0.0;
    }
    @Override
    public String courseGradeLetter(Course course) 
                    throws CourseNotFoundException{
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        double result =getHGrade(course);
        if      (result>=89.5) return "AA";
        else if (result>=84.5) return "BA";    
        else if (result>=79.5) return "BB";
        else if (result>=74.5) return "CB"; 
        else if (result>=69.5) return "CC";  
        else                   return "FF";
    }
    @Override
    public String courseResult(Course course) 
               throws CourseNotFoundException{
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(this, course);
        double result =getHGrade(course);
        if (result>=69.5) return               "Passed";  
        else              return               "Failed";
    }
    @Override
    public double GPAPoints(double result){
             if (result>=89.5) return 4.0;
        else if (result>=84.5) return 3.5;    
        else if (result>=79.5) return 3.0;
        else if (result>=74.5) return 2.5; 
        else if (result>=69.5) return 2.0;    
        else                   return 0.0;
    }
    @Override
    public String gradeLetter(double result) {
        if      (result>=89.5) return "AA";
        else if (result>=84.5) return "BA";    
        else if (result>=79.5) return "BB";
        else if (result>=74.5) return "CB"; 
        else if (result>=69.5) return "CC";  
        else                   return "FF";
    }
    public String getLevel() throws GeneralErrorException{
             if(rank==1) return "Master’s Student " ;
        else if(rank==2) return "Doctoral Student"  ;
        else if(rank==3) return "Doctoral Candidate";
        else throw new GeneralErrorException("rank is invalid");
    }
    public String getThesisTopic(){
        return thesisTopic;
    }
    public void setThesisTopic(String thesisTopic){
        this.thesisTopic=thesisTopic;
    }
    @Override
    public String toString(){
        return super.toString();
    }
}

class Semester implements Comparable<Semester>{
    private final int season;
    private final int year;
    public Semester(int season, int year)throws GeneralErrorException {
        if(season>3||season<1)
            throw new GeneralErrorException("Semester invalid paramter foe season "+season+ " invalid values: 1, 2 or 3.");
        this.season = season;
        this.year = year;
    }
    public String getSeason(){
             if(season==1) return "Fall";
        else if(season==2) return "Spring";
        else               return "Summer";   
    }
    public int getYear(){
        return year;
    }
    @Override
    public String toString() {
        return getSeason()+" – " +getYear();
    }
    @Override
    public int compareTo(Semester o) {
        return getYear()-o.getYear()-o.getSeason().compareTo(getSeason());
    }
}
class SemesterNotFoundException extends RuntimeException{
    private Student student;
    private Semester semester;
    public SemesterNotFoundException(Student student, Semester semester) {
        this.student = student;
        this.semester = semester;
    }
    @Override
    public String toString() {
        return "SemesterNotFoundException: " + student.getID() + 
        " has not taken any courses in " + semester;
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
        return String.format("InvalidGradeException: %f",  grade);
    }
}

class CourseNotFoundException extends RuntimeException{
    Student student;
    Course course;
    CourseNotFoundException(Student student, Course course){
        this.student=student;
        this.course=course;
    }
    @Override
    public String toString(){
        return "CourseNotFoundException: " + student.getID()
        + " has not yet taken " + course.courseCode(); 
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

class DepartmentMismatchException extends RuntimeException{
    Department department;
    Teacher person;
    Course course;
    Teacher chair;
    DepartmentMismatchException(Teacher person, Course course){
        this.department=null;
        this.person=person;
        this.course=course;
    }
    DepartmentMismatchException(Department department, Teacher person)
                                          throws GeneralErrorException{
        this.course=null;
        this.department=department;
        this.person=person;
    }
    @Override
    public String toString(){
        if(course==null)
            return "DepartmentMismatchException: " + person.getName() +
            "(" + person.getID() + ") cannot be chair of " +  
            department.getCode() + " because he/she is currently assigned to "
            + person.getDepartment().getCode() ;
        else if(course!=null)
            return "DepartmentMismatchException: " + 
            person.getName() + "(" + person.getID() + 
            ") cannot teach " + course.getDepartment().getCode() +
            " because he/she is currently assigned to "+
            person.getDepartment().getCode();
        else throw new GeneralErrorException("some objects are null");
    }
}

class GeneralErrorException extends RuntimeException{
    String message;
    GeneralErrorException(String message){
        this.message=message;
    }    
    @Override
    public String toString(){
        return "GeneralErrorException: " + message + getMessage();
    }
}
