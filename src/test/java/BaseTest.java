
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    String baseUrl = "https://www.demoblaze.com/index.html";
    @BeforeTest
    public void setup() {
//        WebDriverManager.chromedriver().browserVersion("108").setup();
        System.setProperty("webdriver.chrome.driver", "D:\\introduction_java\\introduction_project_java\\chromedriver.exe");

        ChromeOptions opt = new ChromeOptions();
//        opt.setBinary("C:\\tools\\GoogleChromePortable\\App\\Chrome-bin\\chrome.exe");
        opt.addArguments("--no-sandbox");
//        opt.addArguments("--headless");
        opt.addArguments("--incognito");
        opt.addArguments("--ignore-certificate-errors");
        opt.addArguments("--allow-running-insecure-content");
        opt.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36");

        //opt.addArguments("--start-maximized");
        opt.addArguments("--disable-infobars");
        opt.addArguments("–-disable-dev-shm-usage");
        //opt.addArguments("--window-size=3840x2160");

        driver = new ChromeDriver(opt);
        driver.manage().window().setSize(new Dimension(3840, 2160));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
