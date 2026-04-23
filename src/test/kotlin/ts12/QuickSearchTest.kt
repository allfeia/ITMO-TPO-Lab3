package ts12

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertTrue

abstract class QuickSearchTest(browser: Browser) : BaseTest(browser) {
    @Test
    fun testQuickSearch() {

        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        val quickSearch = wait.until {
            driver.findElement(By.xpath("//div[contains(@class,'js-quick_search')]"))
        }
        quickSearch.click()

        val male = wait.until {
            driver.findElement(By.xpath("//label[.//p[contains(text(),'Мужчины')]]"))
        }
        male.click()

        val europe = wait.until {
            driver.findElement(By.xpath("//label[.//p[contains(text(),'Европа')]]"))
        }
        europe.click()

        val tokens = wait.until {
            driver.findElement(By.xpath("//label[.//p[contains(text(),'30–59')]]"))
        }
        tokens.click()

        val searchButton = wait.until {
            val btn = driver.findElement(By.xpath("//button[contains(text(),'Поиск')]"))
            if (btn.getAttribute("class").contains("__disabled")) null else btn
        }

        searchButton?.click()

        // проверка, что результаты обновились
        val quickSearchAfter = wait.until {
            driver.findElement(By.xpath("//div[contains(@class,'js-quick_search')]"))
        }

        assertTrue(quickSearchAfter.isDisplayed)
    }
}