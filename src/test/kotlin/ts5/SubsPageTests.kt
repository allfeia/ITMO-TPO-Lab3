package ts5;

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class SubsPageChromeTest : SubsPageTest(Browser.CHROME)
class SubsPageFirefoxTest : SubsPageTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    SubsPageChromeTest::class,
    SubsPageFirefoxTest::class
)
class SubsPageSuite