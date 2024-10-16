package tests;

import common.Configurations;
import common.TestBase;
import org.testng.annotations.*;


public class TestCase {
    public TestBase testBase = new TestBase();
    public final String CONFIGFILE = System.getProperty("user.dir") + "src/main/resources/Config.properties";
    public Configurations config = new Configurations(CONFIGFILE);

    @BeforeMethod
    public void setUp() {
        testBase.openSingleBrowser(config.getConfigValueByKey("url"), "chrome");
    }

    @AfterMethod
    public void tearDown() {
        testBase.closeWeb();
    }
}
