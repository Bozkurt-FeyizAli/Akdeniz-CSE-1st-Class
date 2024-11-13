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
