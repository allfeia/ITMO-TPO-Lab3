package ts6

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertAll
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test

abstract class CardsPageTest(browser: Browser) : BaseTest(browser){

    @Test
    fun openCardsPage() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // переход на нужную страницу
        wait.until(
            ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@href,'gift') and contains(@class,'cards')]")
        )).click()

        //проверяем, что отобразилось все нужное
        assertAll(
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'purchase')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'progress')]")).isNotEmpty()) }
        )
    }
}