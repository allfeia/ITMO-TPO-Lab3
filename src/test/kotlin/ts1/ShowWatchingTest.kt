package ts1

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertAll
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test

abstract class ShowWatchingTest(browser: Browser) : BaseTest(browser) {

    @Test
    fun openShow() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // нажать на модель
        val model = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class,'lst_link')]")
        ))
        model.click()

        //проверяем, что отобразилось видео и чат
        assertAll(
            { assertTrue(driver.findElements(By.xpath("//video")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'chat')]")).isNotEmpty()) }
        )
    }
}