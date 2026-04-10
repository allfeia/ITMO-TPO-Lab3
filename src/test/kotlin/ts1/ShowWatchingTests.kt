package ts1

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class ShowWatchingChromeTest : ShowWatchingTest(Browser.CHROME)
class ShowWatchingFirefoxTest : ShowWatchingTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    ShowWatchingChromeTest::class,
    ShowWatchingFirefoxTest::class
)
class ShowWatchingSuite