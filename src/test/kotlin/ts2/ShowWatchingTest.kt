package ts2

import BaseTest
import Browser
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertAll
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.Test

abstract class ShowWatchingTest(browser: Browser) : BaseTest(browser) {

    @Test
    fun openShow() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // нажать на модель
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class,'lst_link')]")
        )).click()

        //проверяем, что отобразилось видео и чат
        assertAll(
            { assertTrue(driver.findElements(By.xpath("//video")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'chat')]")).isNotEmpty()) }
        )
    }

    @Test
    fun openSmallShow() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // нажать на модель
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class,'lst_link')]")
        )).click()

        // дожидаемся загрузки плеера
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//video")
        ))

        // возвращаемся на главную страницу
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//img[contains(@class,'logo')]")
        )).click()

        //проверяем, что видео отображается
        assertTrue(driver.findElements(By.xpath("//div[contains(@class, 'hover')]")).isNotEmpty())
    }

    @Test
    fun openMedia() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(20))

        // нажать на модель
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[contains(@class,'lst_link')]")
        )).click()

        // дожидаемся загрузки плеера
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//video")
        ))

        //проверяем, что секция с медиа отображается
        assertTrue(driver.findElements(By.xpath("//div[contains(@class, 'media')]")).isNotEmpty())

        //жмем на превью медиа
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//img[contains(@class, 'img')]")
        )).click()

        // проверяем, что отобразился интерфейс просмотра медиа
        assertAll(
            { assertTrue(driver.findElements(By.xpath("//button[contains(@class, 'close')]")).isNotEmpty()) },
            { assertTrue(driver.findElements(By.xpath("//div[contains(@class,'preview')]")).isNotEmpty()) }
        )
    }
}