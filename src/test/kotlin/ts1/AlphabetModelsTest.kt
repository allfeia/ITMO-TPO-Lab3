package ts1

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

abstract class AlphabetModelsTest(browser: Browser) : BaseTest(browser) {
    @ParameterizedTest
    @ValueSource(strings = ["a", "s"])
    fun findModelsStartsWith(letter: String) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        wait.until {
            driver.findElement(By.xpath("//a[@href='/all-models']"))
        }.click()

        wait.until {
            driver.findElement(By.xpath("//a[@href='/all-models/$letter']"))
        }.click()

        assertTrue(driver.findElements(By.xpath("//span[contains(@class,'text')]']"))
            .none { name -> !name.text.lowercase().startsWith(letter) }
        )
    }
}