package ts6;

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class CardsPageChromeTest : CardsPageTest(Browser.CHROME)
class CardsPageFirefoxTest : CardsPageTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    CardsPageChromeTest::class,
    CardsPageFirefoxTest::class
)
class CardsPageSuite