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
