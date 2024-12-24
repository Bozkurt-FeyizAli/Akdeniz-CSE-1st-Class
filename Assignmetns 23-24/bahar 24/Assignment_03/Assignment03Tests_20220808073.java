import org.junit.*;
// @ FEYİZ ALİ BOZKURT @ SINCE 01.05.2024 
public class Assignment03Tests_20220808073 {
    private static int testNumber=1;
 
    @BeforeClass
    public static void start(){
        System.out.println("test is started.");
    }
    @Before
    public void display(){
        System.out.println("\nRunning test: "+ (++testNumber));
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("End of tests");
    }
    @After
    public void afterDisplay(){
        System.out.println("After the test: "+ testNumber);
    }
    public boolean checkStrsInExcToStr(Exception e, String... strings){
        for (String string : strings) {
            if(e.toString().toLowerCase().contains(string.toLowerCase()))
            continue;
            return false;
        }
        return true;
    }
    public double virgüldenSonraİkiBasamak(double number){
        return ((double)((int)(number*100)))/100;
    }
    ////////////// class Department /////////
    @Test
    public void tc001_Department_IsThere_1(){
        new Department("alii", "alii");
    }
    @Test
    public void tc002_Department_Code_1(){
        try {
            new Department("nu", "alii");
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc003_Department_Code_2(){
        try {
        new Department("nulll", "alii");
    } catch (Exception e) {
        assert(true);
        return;
    }
        assert(false);
    }
    @Test
    public void tc004_Department_Code_3(){
        new Department("TECH", "alii");
    }
    @Test
    public void tc005_Department_Code_4(){
        new Department("CSE", "alii");
    }
    @Test
    public void tc006_Department_SetCode_1(){
        Department d= new Department("alii", "alii");
        d.setCode("fab");
        assert(d.getCode().equals("fab"));
    }
    @Test
    public void tc007_Department_SetCode_2(){
        Department d= new Department("ali", "alii");
        d.setCode("fabb");
        assert(d.getCode().equals("fabb"));
    }
    @Test
    public void tc008_Department_SetCode_3(){
        Department d= new Department("alii", "alii");
        try {
        d.setCode("fabbb");      
    } catch (Exception e) {
        assert(true);
        return;
    }
        assert(false);
    }
    @Test
    public void tc009_Department_SetCode_4(){
        Department d= new Department("alii", "alii");
        try{
        d.setCode("fa");
    } catch (Exception e) {
        assert(true);
            return;
          }
        assert(false);
    }
    @Test
    public void tc010_Department_SetName(){
        Department d= new Department("alii", "alii");
        d.setName("CSE102T");
        assert(d.getName().equals("CSE102T"));
    }
    @Test
    public void tc021_Department_Constructor(){
        Department d= new Department("alii", "Tech");
        assert(d.getName().equals("Tech"));
    }
    @Test
    public void tc011_Department_GetChair_1(){
        Department d= new Department("alii", "alii");
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 1);
        d.setChair(t);
        assert(d.getChair()==t);
    }
    @Test
    public void tc012_Department_GetChair_2(){
        Department d= new Department("alii", "alii");
        Department d2= new Department("alii", "alii");
        Teacher t=new Teacher(null, "a@a.a", 1L, d2, 1);
        try {
        d.setChair(t);
    } catch (DepartmentMismatchException e) {
        assert(true);
            return;
    }
        assert(false);
    }
    @Test
    public void tc019_Department_SetChair_2(){
        Department d= new Department("alii", "alii");
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 1);
        Teacher t2=new Teacher(null, "a@a.a", 1L, d, 1);
        d.setChair(t);
        d.setChair(t2);
        assert(d.getChair()==t2);
    }
    //////////// class Course ///////////

    @Test
    public void tc025_Course_constructor_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 100, null, null, 1, t);
    }
    @Test
    public void tc026_Course_constructor_2(){
        try {
            Department d= new Department("alii", null);
            new Course(d, 100, null, null, 1, null);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc027_Course_constructor_3(){
        try {
            Department d= new Department("alii", "alii");
            Teacher t= new Teacher("alii", "a@a.q", 1L, d, 1);
            new Course(null, 100, null, null, 1, t);
        }
        catch(DepartmentMismatchException e){
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc028_Course_constructor_4(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c =new Course(d, 100, null, null, 1, t);
        assert(c.getDepartment()== d);
    }
    @Test
    public void tc029_Course_constructor_5(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        int invalidValue=99;
        try{
            new Course(d, invalidValue, null, null, 1, t);
        }
        catch(Exception e){
            assert(true);
            
            return;
        }
        assert(false);
    }
    @Test
    public void tc030_Course_constructor_6(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 100, null, null, 1, t); 
    }
    @Test
    public void tc031_Course_constructor_7(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 999, null, null, 1, t);
    }
    @Test
    public void tc032_Course_constructor_8(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try{
            new Course(d, 1000, null, null, 1, t);
        }
        catch(Exception e){
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc033_Course_constructor_9(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 5000, null, null, 1, t);
    }
    @Test
    public void tc034_Course_constructor_10(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try{
            new Course(d, 4999, null, null, 1, t);
        }
        catch(Exception e){
            assert(true);
            return;
            
        }
        assert(false);
    }
    @Test
    public void tc035_Course_constructor_11(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 5999, null, null, 1, t);
    }
    @Test
    public void tc036_Course_constructor_12(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try{
            new Course(d, 6000, null, null, 1, t);
        }
        catch(Exception e){
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc037_Course_constructor_13(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 7000, null, null, 1, t);

    }
    @Test
    public void tc038_Course_constructor_14(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try{
            new Course(d, 6999, null, null, 1, t);
        }
        catch(Exception e){
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc039_Course_constructor_15(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        new Course(d, 7999, null, null, 1, t);
    }
    @Test
    public void tc040_Course_constructor_16(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try{
            new Course(d, 8000, null, null, 1, t);
        }
        catch(Exception e){
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc041_Course_constructor_17(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try {
        new Course(d, 7999, null, null, -1, t);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc042_Course_constructor_18(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try {
        new Course(d, 7999, null, null, 0, t);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc043_Course_constructor_19(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=new Course(d, 7999, null, null, 1, t);
        assert(c.getAKTS()==1);
    }
    @Test
    public void tc044_Course_constructor_20(){
        Department d= new Department("aaa", "b");
        Department d2= new Department("ccc", "d");
        Teacher t= new Teacher("f", "a@a.q", 1L, d2, 1);
        try {
            new Course(d, 7999, null, null, 1, t);       
        } catch (DepartmentMismatchException e) {
            assert(true);
            return;
        }
        assert(false);
    }

    @Test
    public void tc045_Course_constructor_21(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c= new Course(d, 7999, null, null, 1, t);
        assert(c.getTeacher()==t);
    }
    @Test
    public void tc046_Course_constructor_22(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c =new Course(d, 100, "alii", null, 1, t);
        assert(c.getTitle().equals("alii"));
    }
    @Test
    public void tc047_Course_constructor_23(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c =new Course(d, 100, null, "alii", 1, t);
        assert(c.getDescription().equals("alii"));
    }
    @Test
    public void tc051_Course_constructor_27(){
        Department d= new Department("alii", null);
        Teacher t1 = new Teacher("fab", "a@a.a", 1L, d, 1);
        Teacher t2= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=new Course(d, 7999, null, null, 1, t1);  
        c.setTeacher(t2);
        assert(c.getTeacher()==t2);
    }
    @Test
    public void tc052_Course_constructor_28(){
        Department d= new Department("alii", null);
        Teacher t2= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c2=null;
        new Course(d, 7999, null, null, 1, t2);  
        c2 =new Course(d, 7999, null, null, 1, t2);  
        assert(c2.getTeacher()==t2);
    }
    @Test
    public void tc053_Course_GetTitle_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=new Course(d, 7999, "FeyizAli", null, 1, t);      
        assert(c.getTitle().equals("FeyizAli"));
    }
    @Test
    public void tc054_Course_SetTitle_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=new Course(d, 7999, null, null, 1, t);       
        c.setTitle("Artificial Intelligence");
        assert(c.getTitle().equals("Artificial Intelligence"));
    }
    @Test
    public void tc057_Course_SetTeacher_2(){
        Department d= new Department("aaa", null);
        Department d2= new Department("bbb", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Teacher t2= new Teacher(null, "a@a.q", 1L, d2, 1);
        Course c= null;
        try {
            c =new Course(d, 7999, null, null, 1, t);  
            c.setTeacher(t2);
        } catch (DepartmentMismatchException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc058_Course_SetTeacher_3(){
        Department d= new Department("alii", null);
        Department d2= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        c.setDepartment(d2); 
        assert(c.getDepartment()==d2);    
    }
    @Test
    public void tc060_Course_GetTeacher_1(){
        Department d= new Department("alii", null);
        Department d2= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Teacher t2= new Teacher(null, "a@a.q", 1L, d2, 1);
        Course c=new Course(d, 7999, null, null, 1, t);  
        c.setDepartment(d2);
        c.setTeacher(t2);
        assert(c.getTeacher()==t2);    
    }
    @Test
    public void tc063_Course_setDepartment_2(){
        Department d= new Department("aaa", "b");
        Department d2= new Department("ccc", "d");
        Teacher t= new Teacher("f", "a@a.q", 1L, d, 1);
        Course c=new Course(d, 7999, null, null, 1, t); 
        c.setDepartment(d2); 
        assert(c.getDepartment()==d2);
    }
    @Test
    public void tc065_Course_SetCourseNumber_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        try {
            c.setCourseNumber(99); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc066_Course_SetCourseNumber_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=null;
        c =new Course(d, 7999, null, null, 1, t);  
        assert(c.getCourseNumber()==7999);
    }
    @Test
    public void tc068_Course_SetCourseNumber_4(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        try {
            c.setCourseNumber(1000); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc069_Course_SetCourseNumber_5(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        try {
            c.setCourseNumber(4999); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc072_Course_SetCourseNumber_8(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        try {
            c.setCourseNumber(6000); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc073_Course_SetCourseNumber_9(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        try {
            c.setCourseNumber(6999); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc076_Course_SetCourseNumber_12(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        try {
            c.setCourseNumber(8000); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc078_Course_setTitle(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        c.setTitle("alii");
        assert(c.getTitle().equals("alii"));
    }
    @Test
    public void tcf079_Course_setDescription(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t);  
        c.setDescription("alii");
        assert(c.getDescription().equals("alii"));
    }
    @Test
    public void tc080_Course_getAKTS_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        try {
            new Course(d, 7999, null, null, -5, t); 
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc081_Course_getAKTS_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 5, t); 
        assert(c.getAKTS()==5);
    }
    @Test
    public void tc082_Course_SetAKTS_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=null;
        try {
            c =new Course(d, 7999, null, null, 1, t); 
            c.setAKTS(0);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc084_Course_SetAKTS_3(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c;
        c =new Course(d, 7999, null, null, 1, t); 
        c.setAKTS(5);
        assert(c.getAKTS()==5);
    }
    @Test
    public void tc085_Course_CourseCode(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.q", 1L, d, 1);
        Course c=new Course(d, 7999, null, null, 1, t); 
        assert(c.courseCode().equals("alii7999"));
    }
    ///////////// Class Teacher //////////
    @Test
    public void tc092_Teacher_constructor_1(){
        new Teacher(null, "a@a.a", 1L, null, 1);
        assert(true);
        // As a person, teacher do not have to have a department
        // I could as an if statement in setDepartment mh. to assign it null
    } 
    @Test
    public void tc094_Teacher_constructor_3(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher("FeyizAli", "a@a.a", 1L, d, 1);
        assert(t.getName().equals("FeyizAli"));
    }
    @Test
    public void tc095_Teacher_constructor_4(){
        Department d= new Department("alii", null);
        try {
            new Teacher("FeyizAli", "a", 1L, d, 1);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc095_Teacher_constructor_4K(){
        Department d= new Department("alii", null);
        try {
            new Teacher("FeyizAli", "a.a.a", 1L, d, 1);
        } catch (Exception e) {
           assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc096_Teacher_constructor_5(){
        Department d= new Department("alii", null);
        try {
            new Teacher("FeyizAli", "a@", 1L, d, 1);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc097_Teacher_constructor_6(){
        Department d= new Department("alii", null);
        Teacher t=new Teacher("FeyizAli", "username@universityname.domain", 1L, d, 1);
        assert(t.getEmail().equals("username@universityname.domain"));
    } 
    @Test
    public void tc098_Teacher_constructor_7(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher("FeyizAli", "a@a.a", 1L, d, 1);
        assert(t.getID()==1L);
    }
    @Test
    public void tc099_Teacher_constructor_8(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        assert(t.getDepartment()==d);
    }
    @Test
    public void tc101_Teacher_constructor_10(){
        Department d= new Department("alii", null);
        try {
            new Teacher(null, "a@a.a", 1L, d, 0);       
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
        /* As my code throw wrong exception this test fails
         * I would write throw InvalidRankException instead of custom Exception
         *  and throw it  */
    }
    @Test
    public void tc102_Teacher_constructor_11(){
        Department d= new Department("alii", null);
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 1);
        assert(t.getTitle().equals("Teaching Assistant"));
        // As a wrote wrong test fails
        // i could write as Teaching Assistant instead of Teaching  Assistant
    }
    @Test
    public void tc102_Teacher_constructor_12(){
        Department d= new Department("alii", null);
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 2);
        assert(t.getTitle().equals("Lecturer"));
    }
    @Test
    public void tc102_Teacher_constructor_13(){
        Department d= new Department("alii", null);
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 3);
        assert(t.getTitle().equals("Assistant Professor"));
    }
    @Test
    public void tc102_Teacher_constructor_14(){
        Department d= new Department("alii", null);
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 4);
        assert(t.getTitle().equals("Associate Professor"));
    }
    @Test
    public void tc103_Teacher_constructor_12(){
        Department d= new Department("alii", null);
        Teacher t=new Teacher(null, "a@a.a", 1L, d, 5);
        assert(t.getTitle().equals("Professor"));
    }
    @Test
    public void tc104_Teacher_constructor_13(){
        Department d= new Department("alii", null);
        try {
            new Teacher(null, "a@a.a", 1L, d, 6);       
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
        /* As my code throw wrong exception this test fails
         * I should write throw InvalidRankException instead of Exception*/
    }
    @Test
    public void tc107_Teacher_setName(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        t.setName("FeyizAli");
        assert(t.getName().equals("FeyizAli"));
    }
    @Test
    public void tc109_Teacher_setEmail_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        t.setEmail("username@universityname.domain");
        assert(t.getEmail().equals("username@universityname.domain"));
    }
    @Test
    public void tc109_Teacher_setEmail_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        try {
            t.setEmail("a@aa");
        } catch (Exception e) {
           assert(true);
           return;
        }
        assert(false);
    }
    @Test
    public void tc109_Teacher_setEmail_3(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        try {
            t.setEmail("a.aa");
        } catch (Exception e) {
           assert(true);
           return;
        }
        assert(false);
    }
    @Test
    public void tc111_Teacher_setID(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        t.setID(20220808073L);
        assert(t.getID()==20220808073L);
    }
    @Test
    public void tc117_Teacher_promote_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        t.promote();
    }
    @Test
    public void tc118_Teacher_promote_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 4);
        t.promote();
    }
    @Test
    public void tc119_Teacher_promote_3(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 5);
        try {
            t.promote();
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
        // As i used && my if case is everytime false and never runs
        // I should write rank<0||rank>4 instead of rank<0&&rank>3
    }

    @Test
    public void tc120_Teacher_demote_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        try {
            t.demote();
        } catch (Exception e) {
           assert(true);
           return;
        }
        assert(false);
        // As i used && my if case is everytime false and never runs
        // I should write rank<0||rank>4 instead of rank<0&&rank>3
    }

    @Test
    public void tc121_Teacher_demote_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 2);
        t.demote();
    }
    @Test
    public void tc122_Teacher_demote_3(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 5);
        t.demote();
    }
    @Test
    public void tc123_Teacher_setDepartment_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 5);
        t.setDepartment(null);
        assert(t.getDepartment()==null);
        // As a person, teacher do not have to have a department
        // I could as an if statement in setDepartment mh. to assign it null
    }
    @Test
    public void tc124_Teacher_setDepartment_2(){
        Department d= new Department("alii", null);
        Department d2= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 5);
        d.setChair(t);
        t.setDepartment(d2);
        assert(d.getChair()==null);
    }
    @Test
    public void tc124_Teacher_setDepartment_2_1(){
        Department d= new Department("alii", null);
        Department d2= new Department("alii", null);
        Teacher t= new Teacher("q", "a@a.a", 1L, d, 5);
        d.setChair(t);
        t.setDepartment(d2);
        assert(t.getDepartment()==d2);
    }
    ////////////// class Student ///////////
    @Test
    public void tc132_Student_Constructor_1(){
        Department d= new Department("null", null);
        new Student(null, "a@a.a",1L , d);
    }
    @Test
    public void tc133_Student_Constructor_2(){
        Department d= new Department("null", null);
        try {
            new Student(null, "a@",1L, d);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc134_Student_Constructor_3(){
            new Student(null, "a@a.a",1L , null);
        // As a person, student do not have to have a department
        // I could as an if statement in setDepartment mh. to assign it null
    }
    @Test
    public void tc135_Student_Constructor_4(){
        new Student(null, "username@universityname.domain",1L , null);
    }
    @Test
    public void tc136_Student_Constructor_5(){
        new Student(null, "username@universityname.domain",20220808073L , null);
    }
    @Test
    public void tc137_Student_Constructor_6(){
        Department d= new Department("alii", null);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        assert(s.getDepartment()==d);
    }
    @Test
    public void tc138_Student_addCourse_7(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
    }
    @Test
    public void tc139_Student_getAKTS_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        assert(s.getAKTS()==2);
    }
    @Test
    public void tc140_Student_getAKTS_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        assert(s.getAttemptedAKTS()==3);
    }
    @Test
    public void tc141_Student_getAKTS_3(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        try {
            s.addCourse(c, -1);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to check throw the right exception
    }

    @Test
    public void tc142_Student_getAKTS_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        try {
            s.addCourse(c, 101);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to check throw the right exception
    }
    @Test
    public void tc143_Student_getAKTS_5(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c, 90);
        assert(s.getGPA()==4.0);
        // My code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        // change value if it has been taken again 
    }
    @Test
    public void tc144_Student_getAKTS_6(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        try {
            s.addCourse(c, -1);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to throwing the right exception   
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        // change value if it has been taken  again 
    }
    @Test
    public void tc145_Student_getAKTS_7(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        try {
            s.addCourse(c, 101);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to throwing the right exception
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        // change value if it has been taken again    
    }
    @Test
    public void tc146_Student_courseGPAPoints_1(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 0);
        assert(s.courseGPAPoints(c)==0.0);
    }
    @Test
    public void tc147_Student_courseGPAPoints_2(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 34);
        assert(s.courseGPAPoints(c)==0);
    }
    @Test
    public void tc146_Student_courseGPAPoints_3(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 34.5);
        assert(s.courseGPAPoints(c)==0.5);
        // My code allow if only garde is bigger than 34.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 45);
        assert(s.courseGPAPoints(c)==0.5);
    }
    @Test
    public void tc146_Student_courseGPAPoints_5(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 45.5);
        assert(s.courseGPAPoints(c)==1.0);
        // My code allow if only garde is bigger than 45.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_6(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 52);
        assert(s.courseGPAPoints(c)==1.0);
    }
    @Test
    public void tc146_Student_courseGPAPoints_7(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 52.5);
        assert(s.courseGPAPoints(c)==1.5);
        // My code allow if only garde is bigger than 52.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_8(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 59);
        assert(s.courseGPAPoints(c)==1.5);
    }
    @Test
    public void tc146_Student_courseGPAPoints_9(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 59.5);
        assert(s.courseGPAPoints(c)==2.0);
        // My code allow if only garde is bigger than 59.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_10(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 66);
        assert(s.courseGPAPoints(c)==2.0);
    }
    @Test
    public void tc146_Student_courseGPAPoints_11(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 66.5);
        assert(s.courseGPAPoints(c)==2.5);
        // My code allow if only garde is bigger than 66.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_12(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 73);
        assert(s.courseGPAPoints(c)==2.5);
    }
    @Test
    public void tc146_Student_courseGPAPoints_13(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 73.5);
        assert(s.courseGPAPoints(c)==3.0);
        // My code allow if only garde is bigger than 73.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_14(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 80);
        assert(s.courseGPAPoints(c)==3.0);
    }
    @Test
    public void tc146_Student_courseGPAPoints_15(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 80.5);
        assert(s.courseGPAPoints(c)==3.5);
        // My code allow if only garde is bigger than 80.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc147_Student_courseGPAPoints_16(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 87);
        assert(s.courseGPAPoints(c)==3.5);
    }
    @Test
    public void tc147_Student_courseGPAPoints_17(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 87.5);
        assert(s.courseGPAPoints(c)==4.0);
        // My code allow if only garde is bigger than 87.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc146_Student_courseGPAPoints_18(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 100);
        assert(s.courseGPAPoints(c)==4.0);
    }
    @Test
    public void tc148_Student_courseGPAPoints_19(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c, 87.5);
        assert(s.courseGPAPoints(c)==4.0);
        // My code allow if only garde is bigger than 87.5 not equal to itself
        // I could change to equal or bigger
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again
    }
    @Test
    public void tc149_Student_courseGPAPoints_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, null, null, 2, t);
        Student s=new Student(null, "username@universityname.domain",2L , d);
        try {
            s.courseGPAPoints(c);
        } catch (CourseNotFoundException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc150_Student_courseGradeLetter_1(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 0);
        assert(s.courseGradeLetter(c).equals("FF"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_2(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 34);
        assert(s.courseGradeLetter(c).equals("FF"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_3(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 34.5);
        assert(s.courseGradeLetter(c).equals("FD"));
        // My code allow if only garde is bigger than 34.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 45);
        assert(s.courseGradeLetter(c).equals("FD"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_5(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 45.5);
        assert(s.courseGradeLetter(c).equals("DD"));
        // My code allow if only garde is bigger than 45.5 equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_6(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 52);
        assert(s.courseGradeLetter(c).equals("DD"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_7(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 52.5);
        assert(s.courseGradeLetter(c).equals("DC"));
        // My code allow if only garde is bigger than 52.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_8(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 59);
        assert(s.courseGradeLetter(c).equals("DC"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_9(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 59.5);
        assert(s.courseGradeLetter(c).equals("CC"));
        // My code allow if only garde is bigger than 59.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_10(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 66);
        assert(s.courseGradeLetter(c).equals("CC"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_11(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 66.5);
        assert(s.courseGradeLetter(c).equals("CB"));
        // My code allow if only garde is bigger than 66.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_12(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 73);
        assert(s.courseGradeLetter(c).equals("CB"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_13(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 73.5);
        assert(s.courseGradeLetter(c).equals("BB"));
        // My code allow if only garde is bigger than 73.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_14(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 80);
        assert(s.courseGradeLetter(c).equals("BB"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_15(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 80.5);
        assert(s.courseGradeLetter(c).equals("BA"));
        // My code allow if only garde is bigger than 80.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_16(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 87);
        assert(s.courseGradeLetter(c).equals("BA"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_17(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 87.5);
        assert(s.courseGradeLetter(c).equals("AA"));
        // My code allow if only garde is bigger than 87.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc150_Student_courseGradeLetter_18(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 100);
        assert(s.courseGradeLetter(c).equals("AA"));
    }
    @Test
    public void tc150_Student_courseGradeLetter_19(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c, 87.5);  
        assert(s.courseGPAPoints(c)==4.0);
        // My code allow if only garde is bigger than 87.5 not equal to itself
        // I could change to equal or bigger
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again   
    }
    @Test
    public void tc152_Student_courseGradeLetter_20(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c, 87.5);
        assert(s.courseGradeLetter(c).equals("AA"));
        // My code allow if only garde is bigger than 87.5 not equal to itself
        // I could change to equal ol bigger
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again
    }
    @Test
    public void tc153_Student_courseGradeLetter_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, null, null, 2, t);
        Student s=new Student(null, "username@universityname.domain",2L , d);
        try {
            s.courseGradeLetter(c);
        } catch (CourseNotFoundException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc154_Student_courseResult_1(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 0);
        assert(s.courseResult(c).equals("Failed"));
    }
    @Test
    public void tc154_Student_courseResult_2(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 45);
        assert(s.courseResult(c).equals("Failed"));
    }
    @Test
    public void tc155_Student_courseResult_3(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 45.5);
        assert(s.courseResult(c).equals("Conditionally Passed"));
    }
    @Test
    public void tc155_Student_courseResult_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 59);
        assert(s.courseResult(c).equals("Conditionally Passed"));
    }
    @Test
    public void tc155_Student_courseResult_5(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 59.5);
        assert(s.courseResult(c).equals("Passed"));
    }
    @Test
    public void tc155_Student_courseResult_6(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 100);
        assert(s.courseResult(c).equals("Passed"));
    }
    @Test
    public void tc156_Student_courseResult_3(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Student s=new Student(null, "username@universityname.domain",1L , d);
        s.addCourse(c, 10);
        s.addCourse(c, 59.5);
        assert(s.courseResult(c).equals("Passed"));
        // My code allow if only garde is bigger than 59.5 not equal to itself
        // I could change to equal ol bigger
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again 
    }
    @Test
    public void tc157_Student_courseResult_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, null, null, 2, t);
        Student s=new Student(null, "username@universityname.domain",2L , d);
        try {
            s.courseResult(c);
        } catch (CourseNotFoundException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc158_Student_studentGPATest(){
        Department cse = new Department("CSE", "Computer Engineering");
        Teacher t = new Teacher("Joseph Ledet", "j@akdeniz.edu.tr", 123L, cse, 1);
        Course c101 = new Course(cse, 101, "Programing 1", "İntroduction to Programing", 6, t);
        Course c102 = new Course(cse, 102, "Programing 2", "Object oriented programing", 4, t);
        Student s = new Student("Test Student", "me@gmail.com", 123L, cse);
        s.addCourse(c101, 80);
        s.addCourse(c102, 30);
        assert(s.getGPA()==1.8);
    }
    ////////////// class GradStudent /////////////
    @Test
    public void tc170_GradStudent_Constructor_1(){
        new GradStudent(null, "a@a.a",1L , null, 1, null);
    }
    @Test
    public void tc170_GradStudent_Constructor_2(){
        try {
            new GradStudent(null, "a@",1L , null, 1, null);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc170_GradStudent_Constructor_2_1(){
        try {
            new GradStudent(null, "a.a.a",1L , null, 1, null);
        } catch (Exception e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc170_GradStudent_Constructor_4(){
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , null, 1, null);
        assert(s.getEmail().equals("username@universityname.domain"));
    }
    @Test
    public void tc170_GradStudent_Constructor_5(){
        GradStudent s=new GradStudent(null, "a@a.a",20220808073L , null, 1, null);
        assert(s.getID()==20220808073L);
    }
    @Test
    public void tc170_GradStudent_Constructor_6(){
        Department d= new Department("alii", null);
        GradStudent s=new GradStudent(null, "a@a.a",1L , d, 1, null);
        assert(s.getDepartment()==d);
    }
    @Test
    public void tc170_GradStudent_Constructor_7(){
        try {
            new GradStudent(null, "a@a.a",1L , null, -1, null);
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc170_GradStudent_Constructor_8(){
        GradStudent s=new GradStudent(null, "a@a.a",1L , null, 1, null);
        assert(s.getLevel().equals("Master’s Student"));
        // actually there is no differnece between pdf and that writing
        // solution is not to use a keyboard type which java does not use
    }
    @Test
    public void tc170_GradStudent_Constructor_9(){
        GradStudent s=new GradStudent(null, "a@a.a",1L , null, 2, null);
        assert(s.getLevel().equals("Doctoral Student"));
    }
    @Test
    public void tc170_GradStudent_Constructor_10(){
        GradStudent s=new GradStudent(null, "a@a.a",1L , null, 3, null);
        assert(s.getLevel().equals("Doctoral Candidate"));
    }
    @Test
    public void tc170_GradStudent_Constructor_11(){
        try {
            new GradStudent(null, "a@a.a",1L , null, 4, null);
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
    }

    @Test
    public void tc170_GradStudent_Constructor_12(){
        GradStudent s=new GradStudent(null, "a@a.a",1L , null, 3, "AI");
        assert(s.getThesisTopic().equals("AI"));
    }
    @Test
    public void tc170_GradStudent_Constructor_12L(){
        GradStudent s=new GradStudent(null, "a@a.a",1L , null, 3, "I");
        s.setThesisTopic("AI");
        assert(s.getThesisTopic().equals("AI"));
    }
    @Test
    public void tc170_GradStudent_addCourse_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
    }
    @Test
    public void tc170_GradStudent_addCourse_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        assert(s.getGPA()==virgüldenSonraİkiBasamak(8/3.0)||(s.getGPA()==8/3.0));
    }
    @Test
    public void tc170_GradStudent_addCourse_3(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c, 90);   
        assert(s.getGPA()==4.0);
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again
    }
    @Test
    public void tc170_GradStudent_addCourse_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        try {
            s.addCourse(c, -1);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to check ant throw the right exception
    }
    @Test
    public void tc170_GradStudent_addCourse_5(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        try {
            s.addCourse(c, 101);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to check throw the right exception
    }
    @Test
    public void tc170_GradStudent_addCourse_6(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 102, "T", null, 1, t);
        Course c3= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
            s.addCourse(c, 10);
            s.addCourse(c, 90);
            s.addCourse(c2, 70);
            s.addCourse(c3, 50);
        assert(s.getGPA()==2.0);
        // Also my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again     
    }
    @Test
    public void tc170_GradStudent_addCourse_7(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        try {
            s.addCourse(c, -1);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to check throw the right exception
    }

    @Test
    public void tc170_GradStudent_addCourse_8(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        try {
            s.addCourse(c, 101);
        } catch (InvalidGradeException e) {
            assert(true);
            return;
        }
        assert(false);
        // i forgot check if grade value is valid or not
        // I could add an if statement to check throw the right exception    
    }
    @Test
    public void tc170_GradStudent_setRank_1(){
        Department d= new Department("alii", null);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        try {
            s.setRank(0);
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc170_GradStudent_setRank_2(){
        Department d= new Department("alii", null);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        try {
            s.setRank(4);
        } catch (InvalidRankException e) {
            assert(true);
            return;
        }
        assert(false);
    }
    @Test
    public void tc170_GradStudent_setRank_3(){
        Department d= new Department("alii", null);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.setRank(2);
    }    
    @Test
    public void tc170_GradStudent_getAKTS_1(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        assert(s.getAKTS()==2);
    }
    @Test
    public void tc170_GradStudent_getAKTS_1L(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        assert(s.getAttemptedAKTS()==3);
    }
    @Test
    public void tc170_GradStudent_getAKTS_2(){
        Department d= new Department("alii", null);
        Teacher t= new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        Course c2= new Course(d, 101, null, null, 2, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c2, 90);
        assert(s.getGPA()==(8.0/3)||s.getGPA()==virgüldenSonraİkiBasamak(8.0/3));
        // As my code divide total GPA to passed AKTS 
        // not total i get bigger result mot osf the time
        // I could use attemted AKTS while calculating AKTS
    }
    @Test
    public void tc170_GradStudent_getAKTS_5(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 10);
        s.addCourse(c, 90);
        assert(s.getGPA()==4.0);
        // my code does not allw you add the same course again
        // I should change the mechanism and add statement to 
        //change value if it has been taken again     
    }
    @Test
    public void tc170_GradStudent_courseGPAPoints_0(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 0);
        assert(s.courseGPAPoints(c)==0.0);
    }
    @Test
    public void tc170_GradStudent_courseGPAPoints_1(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 69);
        assert(s.courseGPAPoints(c)==0.0);
    }
    @Test
    public void tc170_GradStudent_courseGPAPoints_2(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 69.50);
        assert(s.courseGPAPoints(c)==2.0);
        // My code allow if only garde is bigger than 69.5 not equal to itself
        // I could change to equal or bigger
    }
    @Test
    public void tc170_GradStudent_courseGPAPoints_3(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 74);
        assert(s.courseGPAPoints(c)==2.0);
    }
    @Test
    public void tc170_GradStudent_courseGPAPoints_4(){
        Department d= new Department("alii", null);
        Teacher t = new Teacher(null, "a@a.a", 1L, d, 1);
        Course c= new Course(d, 102, "T", null, 1, t);
        GradStudent s=new GradStudent(null, "username@universityname.domain",1L , d, 1, null);
        s.addCourse(c, 74.50);
        assert(s.courseGPAPoints(c)==2.5);
        // My code allow if only garde is bigger than 74.5 not equal to itself
        // I could change to equal or bigger
    }
