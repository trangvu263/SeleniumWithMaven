package tests;

import common.TestBase;
import org.testng.annotations.*;


public class TestCase {
    public TestBase testBase = new TestBase();
    @BeforeMethod
    public void setUp() {
        testBase.openWeb();
    }

    @AfterMethod
    public void tearDown() {
        testBase.closeWeb();
    }
}
