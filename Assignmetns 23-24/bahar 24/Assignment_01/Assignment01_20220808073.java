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
