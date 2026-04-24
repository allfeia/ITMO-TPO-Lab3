package ts9

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertAll
import org.openqa.selenium.*
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test

abstract class MyWallTest(browser: Browser) : BaseTest(browser){

    @Test
    fun openMyWallPage() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // переход на нужную страницу
        val avatar = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//img[contains(@class,'avatar')]")
        ))

        Actions(driver).moveToElement(avatar).perform() //наведение на аватар

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@href,'profile')]")
        ))

        //проверяем, что отобразилось все нужное
        assertAll(
            { assertTrue(driver.findElements(By.xpath("//a[contains(@href,'info')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//img[contains(@src,'profile')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'comments')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'status')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'about')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'actions')]")).isNotEmpty()) }
        )
    }
}