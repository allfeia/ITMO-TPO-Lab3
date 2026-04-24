package ts10

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class BalanceInfoChromeTest : BalanceInfoTest(Browser.CHROME)
class BalanceInfoFirefoxTest : BalanceInfoTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    BalanceInfoChromeTest::class,
    BalanceInfoFirefoxTest::class
)
class BalanceInfoSuite