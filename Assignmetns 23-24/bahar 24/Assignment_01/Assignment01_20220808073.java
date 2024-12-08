//  @FEYİZ ALİ BOZKURT    @since 2 March 2024 
// import java.util.*;
public class Assignment01_20220808073{

    public static void main(String[] args) {

     
    }
}
//    CLASS  1
class Course{
    private String departmentCode;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;
    // private String syntaxTimeError="This is a syntax/compile error!!!";
    
    public boolean isDepartmentCodeVaild(String department){
        return (department.length()==3||department.length()==4);
    }

    public boolean isCourseNumberValid(int courseNumber){
        if     (courseNumber>=100&&courseNumber<1000)
            return true;
        else if(courseNumber>=5000&&courseNumber<6000)
            return true;
        else if(courseNumber>=7000&&courseNumber<8000)
            return true;
        else 
            return false;
    }
    public boolean isAKTSValid(int AKTS){
        return AKTS>0;
    }
    Course(String departmentCode,int courseNumber,
           String title, String description, int AKTS){
        setDepartmentCode(departmentCode);
        setCourseNumber(courseNumber);
        setTitle(title);
        setDescription(description);
        setAKTS(AKTS); 
    }
    public String getDepartmentCode(){
       return departmentCode;
    }
    public void setDepartmentCode(String departmentCode){
        if(isDepartmentCodeVaild(departmentCode))
            this.departmentCode=departmentCode;
        else {
            System.out.println("ERROR");
            // Error.runTimeError();
            Error.runTimeError();
        }
    } 
    public int getCourseNumber(){
        return courseNumber;
    }
    public void setCourseNumber(int courseNumber){
        if(isCourseNumberValid(courseNumber))
            this.courseNumber=courseNumber;
        else{
            System.out.println("ERROR");
            Error.runTimeError();
        }
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
        else{
            System.out.println("ERROR");
            Error.runTimeError();
        }
    }
    public String courseCode(){
        return departmentCode+Integer.toString(courseNumber);
    }
    @Override
    public String toString(){
        return String.format
    ("%s%d - %s (%d)", departmentCode, courseNumber, title, AKTS);
    }
}
//   CLASS  2
class Person{
    private String name;
    private String email;
    private Long ID;
    private String departmentCode;
    
    // Course helperMethods= new Course(departmentCode, 0, email, 
                           //  departmentCode, 0);
    public boolean isDepartmentCodeVaild(String department){
        return (department.length()==3||department.length()==4);
    }

    //  {username}@{university name}.{domain}
    public boolean isEmailValid(String email){
        if     (!email.contains("@"))
            return false;
        else if(!email.contains("."))
            return false;
        else if((email.indexOf("@", 2)-email.indexOf(".",
                 email.indexOf("@")))>-2)
            return false;  
        // else if
        // (email.indexOf(".", email.indexOf("."))-email.indexOf(".")<1)
        // (email.indexOf(".", email.length()-2)==email.length()-1||
          //email.indexOf("@")==0)
            // return false;          
        else 
            return true;
    }
    public Person(String name, String email, long number, 
                  String departmentCode){
        setName(name);
        setEmail(email);
        setDepartmentCode(departmentCode);
        setID(number);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        if(isEmailValid(email))
            this.email=email;
        else {
            System.out.println("ERROR");   
            Error.runTimeError();
        }
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
    public void setDepartmentCode(String departmentCode){
        if(isDepartmentCodeVaild(departmentCode))
            this.departmentCode=departmentCode;   
        else {
            System.out.println("ERROR");
            Error.runTimeError();
        }
    }
    public static void runtimeError(){
        System.out.println(0/0);
    }
    @Override
    public String toString(){
        return String.format("%s (%d) - %s", name, ID, email);
    }
    
}
//    CLASS  3
class Teacher extends Person{
    private int rank;
    // private String runTimeError="This is a runtimr error!!!";
    // char runTime=runTimeError.charAt(-10);
    // int a=5/0;
    public Teacher(String name, String email, Long number,
                   String department, int rank){
        super(name,email, number, department);
        ////////////////////////////
        setRank(rank);
    }
    public boolean isRankValid(int rank){
        return (rank>0&&rank<=4);
    }
    public void setRank(int rank){
        if(isRankValid(rank))
            this.rank=rank;
        else {
            System.out.println("ERROR: out of rank.");
            Error.runTimeError();
        }
    }
    public String getTitle(){
        if     (rank==1)
            return "Lecturer";
        else if(rank==2)
            return "Assistant Professor";
        else if(rank==3)
            return "Associate Professor";
        else if(rank==4)
            return "Professor";
        else 
            return "ERROR";
    }
    public void promote(){
        if(rank<4&&rank>0)
            rank++;
            else {
                System.out.println("ERROR");
                Error.runTimeError();
            }
    }
    public void demote(){
        if(rank>1&&rank<5)
            rank--;
            else {
                System.out.println("ERROR");
                Error.runTimeError();
            }
    }
    @Override
    public String toString(){
        return String.format
        ("%s + %s", getTitle(), super.toString());
    }
}
//      CLASS 4
class Student extends Person{
    private int AKTS;
    // Course fab=new Course("d", 541, "2", "itle,a", AKTS);
    public Student(String name, String email, Long number, String department){
        super(name, email, number, department);
        this.AKTS=0;
    }
    public boolean isAKTSValid(int AKTS){
        return AKTS>0;
    }
    public int getAKTS(){
        return AKTS;
    }
    public void setAKTS(int AKTS){
        if(isAKTSValid(AKTS))
            this.AKTS=AKTS;
        else{
            System.out.println("ERROR");
            Error.runTimeError();
            // runtimeError();
        }
    }
    public void passCourse(Course course){
        AKTS+=course.getAKTS();
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
//      CLASS 5
class GradStudent extends Student{
    private int rank;
    private String thesisTopic;
    GradStudent(String name, String email, Long number, String department, 
                int rank, String thesisTopic){
        super(name, email, number, department);
        setRank(rank);
        setThesisTopic(thesisTopic);

    }
    public void setRank(int rank){
        if(rank>0&&rank<4)
            this.rank=rank;
        else {
            System.out.println("ERROR");
            Error.runTimeError();
        }
    }
    public String getLevel(){
        if     (rank==1)
        // check that later
            return "Master’s Student ";
        else if(rank==2)
            return "Doctoral Student";
        else if(rank==3)
            return "Doctoral Candidate";
        else 
            return "ERROR";
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

class Error{
    public static void runTimeError(){
       System.out.println(0/0);
    }
}