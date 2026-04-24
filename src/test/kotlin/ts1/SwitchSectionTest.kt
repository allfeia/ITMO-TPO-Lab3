package ts1

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

abstract class SwitchSectionTest(browser: Browser) : BaseTest(browser) {
    @ParameterizedTest
    @ValueSource(strings = ["male", "pair", "new-models", "spy-mode", "female"])
    fun switchSection(section: String) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        wait.until {
            driver.findElement(By.xpath("//li[@data-type,'$section']')]"))
        }.click()

        assertTrue(driver.currentUrl.contains("/$section"))
    }
}