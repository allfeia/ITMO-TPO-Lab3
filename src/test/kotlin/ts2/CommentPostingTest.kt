package ts2

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertTrue

abstract class CommentPostingTest(browser: Browser) : BaseTest(browser) {

    @Test
    fun postComment() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // нажать на модель
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class,'lst_link')]")
        )).click()

        // отправляем
        val text = "hi, it's me Mario!"
        driver.findElements(
            By.xpath("//div[contains(@class,'ccp_input') and contains(., 'text')]")
        )[0].sendKeys(text + "\n")

        // проверка, что сообщение появилось
        assertTrue(driver.findElements(
            By.xpath("//span[@class='msg' and contains(., '$text')]")
        ).isNotEmpty())
    }
}