public class a{

    public static void main(String[] args) {
Teacher t= new Teacher("null", "nul@l.s", 123L, "null", 2);
     
    }
}
//    CLASS  1
class Course{
    private String departmentCode;
    private int courseNumber;
    private String title;
    private String description;
    private int AKTS;
    // private String syntaxTimeError="This is a syntax/compile error!!!";z
    
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
