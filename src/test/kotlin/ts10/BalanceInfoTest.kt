package ts10

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class BalanceInfoTest(browser: Browser) : BaseTest(browser){

    @ParameterizedTest
    @ValueSource(ints = [0])
    fun checkBalance(expected: Long) {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        val bal = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[contains(@class,'number') and contains(@class,'tokens')]")
        ))

        // проверяем, что отображается нужный баланс
        assertTrue(bal.text.toLong() == expected)
    }
}