package ts1

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertTrue

abstract class CategoryFilterTest(
    browser: Browser,
    private val categoryUrlPart: String
) : BaseTest(browser) {

    @Test
    fun testCategoryFilter() {

        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // клик по категории
        val category = wait.until {
            driver.findElement(By.xpath("//a[contains(@href,'$categoryUrlPart')]"))
        }
        category.click()

        // проверка URL
        wait.until {
            driver.currentUrl.contains("/female/tags/$categoryUrlPart")
        }

        assertTrue(driver.currentUrl.contains("/female/tags/$categoryUrlPart"))
    }
}