package ts9

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class MyWallChromeTest : MyWallTest(Browser.CHROME)
class MyWallFirefoxTest : MyWallTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    MyWallChromeTest::class,
    MyWallFirefoxTest::class
)
class MyWallSuite