package ts12

import BaseTest
import Browser
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertTrue

abstract class OpenAllCategoriesTest(browser: Browser) : BaseTest(browser) {
    @Test
    fun testOpenAllCategories() {

        val wait = WebDriverWait(driver, Duration.ofSeconds(20))


        val plusButton = wait.until {
            driver.findElement(By.xpath("//div[contains(@class,'ht_items_toggle')]"))
        }


        plusButton.click()

        val allTags = wait.until {
            driver.findElement(
                By.xpath("//a[contains(@class,'ht_view_all') and contains(text(),'Посмотреть')]")
            )
        }


        allTags.click()

        wait.until {
            driver.currentUrl.contains("/tags")
        }

        assertTrue(driver.currentUrl.contains("/tags"))
    }
}