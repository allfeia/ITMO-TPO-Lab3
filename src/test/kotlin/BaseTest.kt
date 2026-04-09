import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration

open class BaseTest {
    lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
//        driver = ChromeDriver()
         driver = FirefoxDriver()

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
        driver.manage().window().maximize()
        driver.get("http://www.bongacams.com/")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}