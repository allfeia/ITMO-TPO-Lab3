package ts6

import BaseTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class ChangeLanguageTest : BaseTest(){

    @ParameterizedTest
    @ValueSource(strings = ["es", "ru", "lt", "pl", "fi"])
    fun langTest(langCode: String) {
        assertTrue(langCode in changeLanguage(langCode), "Ошибка при переключении на $langCode")
    }

    private fun changeLanguage(lang: String): String {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        try {

            // открыть панель с языками
            val langDiv = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'lang')]")
            ))
            Actions(driver).moveToElement(langDiv).perform()

            // выбор языка
            val newLang = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@data-lang='$lang']")
            ))
            newLang.click()

            return driver.currentUrl
        } finally {
            driver.quit()
        }
    }
}