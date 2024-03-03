import org.testng.annotations.*;

public class BaseTest {

    protected static int counter = 0;
    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        calculator = new Calculator();
        counter++;
        System.out.println("BeforeSuite: ..." + counter);
    }

    @BeforeTest
    public void beforeTest() {
        counter++;
        System.out.println("beforeTest: ..." + counter);
    }

    @BeforeClass
    public void beforeClass() {
        counter++;
        System.out.println("BeforeClass: ..." + counter);
    }

    @BeforeMethod
    public void beforeMethod() {
        counter++;
        System.out.println("BeforeMethod: ..." + counter);
    }

    @BeforeGroups
    public void beforeGroups() {
        counter++;
        System.out.println("BeforeGroups: ..." + counter);
    }

    @AfterSuite
    public void afterSuite() {
        counter++;
        System.out.println("AfterSuite: ..." + counter);
    }

    @AfterTest
    public void afterTest() {
        counter++;
        System.out.println("AfterTest: ..." + counter);
    }

    @AfterSuite
    public void afterClass() {
        counter++;
        System.out.println("AfterSuite: ..." + counter);
    }

    @AfterMethod
    public void afterMethod() {
        counter++;
        System.out.println("AfterMethod: ..." + counter);
    }

    @AfterGroups
    public void afterGroups() {
        counter++;
        System.out.println("AfterGroups: ..." + counter);
    }

    @Test
    public void archTest1() {
        counter++;
        System.out.println("Test1: ..." + counter);
    }

    @Test
    public void archTest2() {
        counter++;
        System.out.println("Test2: ..." + counter);
    }
}
