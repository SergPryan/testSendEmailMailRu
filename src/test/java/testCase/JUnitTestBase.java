package testCase;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

//  protected static URL gridHubUrl;
//  protected static String baseUrl;
//  protected static Capabilities capabilities;

  WebDriver driver;

  @ClassRule
  public static ExternalResource webDriverProperties = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      SuiteConfiguration config = new SuiteConfiguration();
//      baseUrl = config.getProperty("site.url");
//      if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
//        gridHubUrl = new URL(config.getProperty("grid.url"));
//      }
//      capabilities = config.getCapabilities();
      System.setProperty("webdriver.gecko.driver",config.getProperty("webdriver.gecko.driver"));
    }
  };

  @Rule
  public ExternalResource webDriver = new ExternalResource() {
    @Override
    protected void before() {
//      driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
      driver = new FirefoxDriver();
    }
  };
}
