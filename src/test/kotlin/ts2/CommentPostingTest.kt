package ts2

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test

abstract class CommentPostingTest(browser: Browser) : BaseTest(browser) {

    @Test
    fun postComment() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // нажать на модель
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class,'lst_link')]")
        )).click()

        // отправляем
        driver.findElements(
            By.xpath("//div[contains(@class,'ccp_input') and contains(@contenteditable, 'text')]")
        )[0].sendKeys("hi, it's me Mario!\n")
    }
}