package ts8

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import kotlin.test.Test

abstract class ProfileWrongData(browser: Browser) : BaseTest(browser) {
    @Test
    fun testInvalidProfileInfo() {
        driver.findElement(By.xpath("//a[@href='/profile']")).click()

        driver.findElement(By.xpath("//textarea[@name='bio']")).sendKeys("")

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click()

        val error = driver.findElement(By.xpath("//div[contains(@class,'error')]"))
        assertTrue(error.isDisplayed)
    }
}