package ts1

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

abstract class EditViewTest(browser: Browser) : BaseTest(browser) {
    @ParameterizedTest
    @ValueSource(strings = ["big", "medium"])
    fun switchPictureSize(size: String) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        wait.until {
            driver.findElement(By.xpath("//input[@value='$size' and @type='radio']"))
        }.click()

        assertTrue(driver.findElements(
            By.xpath("//div[contains(@class,'$size')]")
        ).isNotEmpty())
    }

    @ParameterizedTest
    @ValueSource(strings = ["profile", "live"])
    fun switchPictureType(type: String) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        wait.until {
            driver.findElement(By.xpath("//div[contains(@class, 'filter')]"))
        }.click()

        wait.until {
            driver.findElement(By.xpath("//input[@value='$type' and @type='radio']"))
        }.click()

        val expected = if (type == "profile") "picture" else "img"

        assertTrue(driver.findElement(
            By.xpath("div[contains(@class, 'listing')]")).findElements(
            By.xpath("//$expected")).isNotEmpty()
        )
    }
}