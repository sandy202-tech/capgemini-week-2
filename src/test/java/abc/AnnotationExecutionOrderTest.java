package abc;

import org.testng.annotations.*;

public class AnnotationExecutionOrderTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BS");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BT");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BC");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BM");
    }

    @Test
    public void testOne() {
        System.out.println("TM1");
    }

    @Test
    public void testTwo() {
        System.out.println("TM2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AM");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AS");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AT");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AS");
    }
}
