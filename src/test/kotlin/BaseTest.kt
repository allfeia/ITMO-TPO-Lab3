import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration
enum class Browser {
    CHROME,
    FIREFOX
}

open class BaseTest(private val browser: Browser) {
    lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        driver = when (browser) {
            Browser.CHROME -> ChromeDriver()
            Browser.FIREFOX -> FirefoxDriver()
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
        driver.manage().window().maximize()
        driver.get("https://ru14.bongacams.com/continue-18-plus")
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }
}