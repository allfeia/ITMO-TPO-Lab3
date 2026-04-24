package ts5

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertAll
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test

abstract class SubsPageTest(browser: Browser) : BaseTest(browser){

    @Test
    fun openSubsPage() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // переход на нужную страницу
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@href,'followers')]")
        )).click()

        //проверяем, что отобразилось все нужное
        assertAll(
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'refer')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'pinned')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'moderated')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'followings')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'followers')]")).isNotEmpty()) }
        )
    }
}