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

