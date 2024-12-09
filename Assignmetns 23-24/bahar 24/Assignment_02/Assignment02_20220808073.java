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

class Course{
    private Department department;
    private Teacher teacher;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;
    private double grade;
    private String gradeLetter;
    private double GPA;
    private String gradeResult;
    
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
        GeneralErrorException("department code is invalid");
    }
    public boolean isAKTSValid(int AKTS) throws GeneralErrorException{
        if (AKTS>0)
            return true;
        else throw new GeneralErrorException("AKTS is invalid.");
    }
    Course(Department department,int courseNumber,
           String title, String description, 
           int AKTS, Teacher teacher){
        setDepartment(department);
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
    public String getGradeResult() {
        return gradeResult;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public void setGradeResult(String gradeResult) {
        this.gradeResult = gradeResult;
    }
    public String getGradeLetter() {
        return gradeLetter;
    }
    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
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
}

abstract class Person{
    private Department department;
    private String name;
    private String email;
    private Long ID;
    private String departmentCode;
    public double grade;
    
    public boolean isDepartmentCodeVaild(String departmentCode) 
                                   throws GeneralErrorException{
        if(departmentCode==null)
            throw new 
            GeneralErrorException("departmentCode is null.");
        if(departmentCode.length()==3||departmentCode.length()==4)
            return true;
        else 
        throw new 
        GeneralErrorException("department code is invalid.");
    }
    //  {username}@{university name}.{domain}
    public boolean isEmailValid(String email) throws GeneralErrorException{
        if     (!email.contains("@"))
            throw new GeneralErrorException("email is invalid.");
        else if(!email.contains("."))
            throw new GeneralErrorException("email is invalid.");
        else if((email.indexOf("@", 2)-email.indexOf(".",
                 email.indexOf("@")))>-2)
            throw new GeneralErrorException("email is invalid.");
        else 
            return true;
    }

    public Person (String name, String email, long ID, Department department){
        setName(name);
        setEmail(email);
        setDepartment(department);
        setID(ID);
    }
    public Department getDepartment() {
        return department;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        if(isEmailValid(email))
            this.email=email;
    }
    public long getID(){
        return ID;
    }
    public void setID(long ID){
        this.ID=ID;
    }
    public String getDepartmentCode(){
        return departmentCode;
    }
    @Override
    public String toString(){
        return String.format("%s (%d) - %s", name, ID, email);
    }
}

class Teacher extends Person{
    private int rank;

    public Teacher(String name, String email, long ID, 
                   Department department, int rank){
        super(name, email, ID, department);
        if(isRankValid(rank))
            this.rank=rank;
    }
    public boolean isRankValid(int rank){
        if(rank>0&&rank<=5)
            return true;
        else throw new GeneralErrorException("rank is invalid." );
    }
    public int getRank() {
        return rank;
    }
    public String getTitle() throws GeneralErrorException{
             if(rank==1) return "Teaching  Assistant";
        else if(rank==2) return "Lecturer"           ;
        else if(rank==3) return "Assistant Professor";
        else if(rank==4) return "Associate Professor";
        else if(rank==5) return "Professor"          ;    
        else throw new  GeneralErrorException("rank is invalid")             ;
    }
    public void promote(){
        if(rank<0&&rank>3)
            throw new 
            GeneralErrorException("GeneralErrorException: ..."); 
        rank++;
    }
    public void demote(){
        if(rank<1&&rank>4)
            throw new 
            GeneralErrorException("GeneralErrorException: ...");
        rank--;
    }
    @Override
public void setDepartment(Department department) {
    if (department == null) {
        throw new GeneralErrorException("Department is null");
    } else {
        Department currentDepartment = getDepartment();
        if (currentDepartment != null && currentDepartment.getChair() == this){
            try {
                currentDepartment.setChair(null);
            } catch (GeneralErrorException e) {
                System.out.println("Failed to set chair: " + e.getMessage());
            }
        }
        super.setDepartment(department);
    }
}
    @Override
    public String toString(){
        return String.format
        ("%s + %s", getTitle(), super.toString());
    }
}

class Student extends Person{
    private double GPA;
    private int AKTS;
    private int passedAKTS;
    private ArrayList<Course> courses;
    

    public Student(String name, String email, long ID, Department department){
        super(name, email, ID, department);
        courses=new ArrayList<>();
    }
    public double virgüldenSonra2Basamak(double number){
        return ((double)((int)(number*100)))/100;
    }
    public boolean isAKTSValid(int AKTS){
        return AKTS>0;
    }
    public void addCourses(Course courses) {
        this.courses.add(courses);
    }
    public int getAKTS(){
        calculateAKTS(); 
        return passedAKTS;
    }
    public int getAttemptedAKTS(){
        calculateAKTS();
        return AKTS;
    }
    public double getGPA() {
        calculateGPA();  
        return GPA;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public boolean isCourseTaken(Course course){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i) == course) 
                return true;  
        }
        return false; 
    }
    public void calculateAKTS(){
        int passedAKTS=0;
        int calculateAKTS=0;
        for (int i = 0; i < courses.size(); i++){
            calculateAKTS+=courses.get(i).getAKTS();
            if(courses.get(i).getGrade()>59.5)
                passedAKTS+=courses.get(i).getAKTS();}
        this.passedAKTS=passedAKTS;        
        this.AKTS=calculateAKTS;
    }
    public void removeCourse(Course course){
        courses.remove(course);
    }
    public void addCourse(Course course, double grade)
                        throws CourseNotFoundException{
        //////////////* */
        isGradeInvalid(grade);
        if(!isCourseTaken(course)){
        course.setGrade(grade);
        addCourses(course);
        course.setGradeLetter(courseGradeLetter(course)); 
        calculateAKTS(); 
        calculateGPA();  
        }
        else {
            throw new CourseNotFoundException(course, this);
        }
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void calculateGPA(){
        int totalAKTS=0;
        double calculateGPA=0;
        for (int index = 0; index < courses.size(); index++) {
            // System.out.println(courses.get(index).getGrade());
            calculateGPA+=(courses.get(index).getAKTS()*
                           courseGPAPoints(courses.get(index)));
            totalAKTS+=courses.get(index).getAKTS();
        }
        calculateGPA=calculateGPA/totalAKTS;
        calculateGPA=virgüldenSonra2Basamak(calculateGPA);
        this.GPA=calculateGPA;
    }
    public void isGradeInvalid(double grade) throws InvalidGradeException{
        if(grade>100&&grade<0)
            throw new InvalidGradeException(grade);   
    }
    public double courseGPAPoints(Course course) {
        isGradeInvalid(course.getGrade());
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(course, this);    
        double result=course.getGrade();
                 if (result>87.5) return 4.0;
            else if (result>80.5) return 3.5;    
            else if (result>73.5) return 3.0;
            else if (result>66.5) return 2.5; 
            else if (result>59.5) return 2.0;     
            else if (result>52.5) return 1.5;          
            else if (result>45.5) return 1.0;
            else if (result>34.5) return 0.5;    
            else                  return 0.0;  
        }
    public String courseGradeLetter(Course course) {
        isGradeInvalid(course.getGrade());
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(course, this);    
        double result =course.getGrade();
             if (result>87.5) return "AA";
        else if (result>80.5) return "BA";    
        else if (result>73.5) return "BB";
        else if (result>66.5) return "CB"; 
        else if (result>59.5) return "CC";     
        else if (result>52.5) return "DC";          
        else if (result>45.5) return "DD";
        else if (result>34.5) return "FD";    
        else                  return "FF";
    }
    public String courseResult(Course course) {
        isGradeInvalid(grade);
        if(!isCourseTaken(course))
            throw new CourseNotFoundException(course, this); 
             if (course.getGrade()>=59.5) return               "Passed";              
        else if (course.getGrade()>=45.5) return "Conditionally Passed";  
        else                              return               "Failed";
    }
    @Override
    public String toString() throws GeneralErrorException{
        calculateGPA();  
        if(GPA<=4.00&&GPA>=0.00){
        // calculateGrade();
        return  super.toString() + " – GPA: " + getGPA(); 
        }
        else throw new GeneralErrorException("GPA is invalid");
    }
}

class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    GradStudent(String name, String email, Long number, Department department,
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
    public void passedAKTS(Course course){
            if(course.getGrade()>69.5)
        super.setPassedAKTS(course.getAKTS());
    }
    @Override
    public void addCourse(Course course, double grade) 
                        throws CourseNotFoundException{  
        isGradeInvalid(grade);
        if(!isCourseTaken(course)){
            course.setGrade(grade); 
            course.setGradeLetter(courseGradeLetter(course));
            course.setGradeResult(courseResult(course));
            course.setGPA(courseGPAPoints(course)); 
            super.addCourses(course);
            this.calculateAKTS(); 
            this.calculateGPA(); 
        }
        else
            throw new CourseNotFoundException(course, this); 
    }
    @Override
    public void calculateGPA(){ 
        double calculateGPA=0;
        for (int index = 0; index < getCourses().size(); index++) {
            Course c= getCourses().get(index);
            calculateGPA+=c.getAKTS()*courseGPAPoints(c);
        }
        calculateGPA=virgüldenSonra2Basamak(calculateGPA/getAKTS());
        setGPA(calculateGPA);
    }
    @Override
    public double courseGPAPoints(Course course){
        /////////
        isGradeInvalid(grade);
        double result=course.getGrade();
             if (result>89.5) return 4.0;
        else if (result>84.5) return 3.5;    
        else if (result>79.5) return 3.0;
        else if (result>74.5) return 2.5; 
        else if (result>69.5) return 2.0;    
        else                  return 0.0;
    }
    @Override
    public String courseGradeLetter(Course course) 
                    throws CourseNotFoundException{
        isGradeInvalid(grade);
        double result =course.getGrade();
        if      (result>89.5) return "AA";
        else if (result>84.5) return "BA";    
        else if (result>79.5) return "BB";
        else if (result>74.5) return "CB"; 
        else if (result>69.5) return "CC";  
        else                  return "FF";
    }
    @Override
    public String courseResult(Course course) 
               throws CourseNotFoundException{
        isGradeInvalid(grade);
        double result =course.getGrade();
        if (result>69.5) return               "Passed";  
        else             return               "Failed";
    }
    public String getLevel() throws GeneralErrorException{
             if(rank==1)return "Master’s Student " ;
        else if(rank==2)return "Doctoral Student"  ;
        else if(rank==3)return "Doctoral Candidate";
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
        calculateGPA();
        return super.toString();
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
    Student student;
    Course course;
    CourseNotFoundException(Course course, Student student){
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
            + person.getDepartmentCode() ;
        else if(course!=null)
            return "DepartmentMismatchException: " + 
            person.getName() + "(" + person.getID() + 
            ") cannot teach " + course.getDepartment().getCode() +
            " because he/she is currently assigned to "+
            person.getDepartmentCode();
        else throw new GeneralErrorException("some objects are null");
    }
}

