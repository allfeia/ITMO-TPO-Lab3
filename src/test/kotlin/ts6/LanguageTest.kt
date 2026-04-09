package ts6

import BaseTest
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.assertTrue

class LanguageTest : BaseTest() {

    @Test
    fun testChangeLanguage() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        // 1. Объявляем переменные ДО блоков try, чтобы они были видны в конце теста
        var before: String? = null
        var after: String? = null

        // popup (если есть)
        val popup1 = driver.findElements(By.xpath("//*[@id='warning_popup']//a"))
        if (popup1.isNotEmpty()) {
            popup1[0].click()
        }
        val popup2 = driver.findElements(By.xpath("//*[@id='member_join_popup']//a"))
        if (popup2.isNotEmpty()) {
            popup2[0].click()
        }
        //*[@id="member_join_popup"]/div[4]/button

        // 2. Получаем начальный текст
        println("🔍 [DEBUG] Поиск заголовка (before)...")
        try {
            val titleLocator = By.xpath("//h1[contains(@class,'title_h1')]")
            before = wait.until { driver.findElement(titleLocator) }.text
            println("✅ [DEBUG] before = '$before'")
        } catch (e: Exception) {
            logDebugInfo(driver, "BEFORE_LANG_SWITCH")
            throw e
        }

        // 3. Открываем меню языка
        try {
            println("🔍 [DEBUG] Клик по lang_button...")
            wait.until { driver.findElement(By.id("lang_button")) }.click()
        } catch (e: Exception) {
            logDebugInfo(driver, "CLICK_LANG_BUTTON")
            throw e
        }

        // 4. Выбираем другой язык
        try {
            println("🔍 [DEBUG] Клик по change_lang...")
            wait.until { driver.findElement(By.xpath("//*[@id='change_lang']//a")) }.click()
        } catch (e: Exception) {
            logDebugInfo(driver, "CLICK_CHANGE_LANG")
            throw e
        }

        // 5. Ждём обновления и получаем новый текст
        println("🔍 [DEBUG] Ожидание обновления заголовка...")
        // Небольшая пауза, чтобы страница успела начать перезагрузку
        Thread.sleep(1000)

        try {
            val titleLocator = By.xpath("//h1[contains(@class,'title_h1')]")
            after = wait.until { driver.findElement(titleLocator) }.text
            println("✅ [DEBUG] after = '$after'")
        } catch (e: Exception) {
            logDebugInfo(driver, "AFTER_LANG_SWITCH")
            throw e
        }

        // 6. Финальная проверка (переменные здесь уже видны)
        println("🔍 [ASSERT] Сравнение: '$before' != '$after'")
        assertTrue(before != after, "Expected text to change, but before='$before', after='$after'")
    }

    // Вспомогательная функция для логирования (чтобы не дублировать код)
    private fun logDebugInfo(driver: WebDriver, label: String) {
        println("\n❌ [ERROR DEBUG $label]")
        println("   URL: ${driver.currentUrl}")
        println("   Title: ${driver.title}")

        val h1Elements = driver.findElements(By.tagName("h1"))
        println("   Найдено <h1>: ${h1Elements.size}")
        h1Elements.forEachIndexed { i, el ->
            println("   h1[$i] text='${el.text}', class='${el.getAttribute("class")}'")
        }

        // Вывод первых 1500 символов HTML для контекста
        println("   HTML snippet: ${driver.pageSource.take(1500)}")
        println("   ----------------------\n")
    }
}