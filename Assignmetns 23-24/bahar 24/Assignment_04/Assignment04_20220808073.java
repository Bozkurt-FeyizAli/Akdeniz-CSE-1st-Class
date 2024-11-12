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
