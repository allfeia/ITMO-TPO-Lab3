package ts8

import BaseTest
import Browser
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import kotlin.test.assertTrue

abstract class ProfileCorrectData(browser: Browser) : BaseTest(browser) {
//    @Test
//    fun testValidProfileInfo() {
//        driver.findElement(By.xpath("//a[@href='/profile']")).click()
//
//        driver.findElement(By.xpath("//textarea[@name='bio']")).clear()
//        driver.findElement(By.xpath("//textarea[@name='bio']")).sendKeys("Hello, I'm a tester")
//
//        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click()
//
//        val success = driver.findElement(By.xpath("//div[contains(@class,'success')]"))
//        assertTrue(success.isDisplayed)
//    }
}