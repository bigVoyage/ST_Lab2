import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class QQ {
  private static WebDriver driver;
  private static String baseUrl;
  private static String[][] a = new String[][]{{"3014218132","https://github.com/bigVoyage/"}};
  
  private String number;
  private String address;
  
  public QQ(String number, String address){
	  this.number = number;
	  this.address = address;
  }
  
  @Parameters
  public static Collection prepare() {  
	  CSV.getData();
	  return Arrays.asList(CSV.testData);
  }
  
  @BeforeClass
  public static void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testQQ() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(number);
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys(number.substring(4));
    driver.findElement(By.id("submit")).click();
    
    WebElement ele = driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]"));
    assertEquals(address, ele.getText());
  }

  @AfterClass
  public static void tearDown() throws Exception {
    driver.quit();
  }
}
