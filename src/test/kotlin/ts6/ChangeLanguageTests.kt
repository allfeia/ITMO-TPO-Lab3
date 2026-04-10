package ts6;

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class ChangeLanguageChromeTest : ChangeLanguageTest(Browser.CHROME)
class ChangeLanguageFirefoxTest : ChangeLanguageTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    ChangeLanguageChromeTest::class,
    ChangeLanguageFirefoxTest::class
)
class ChangeLanguageSuite