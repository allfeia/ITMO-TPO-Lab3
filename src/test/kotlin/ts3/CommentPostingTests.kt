package ts3

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class CommentPostingChromeTest : CommentPostingTest(Browser.CHROME)
class CommentPostingFirefoxTest : CommentPostingTest(Browser.FIREFOX)

@Suite
@SelectClasses(
    CommentPostingChromeTest::class,
    CommentPostingFirefoxTest::class
)
class CommentPostingSuite