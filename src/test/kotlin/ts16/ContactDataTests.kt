package ts16

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class ContactCorrectDataChromeTest : ContactCorrectData(Browser.CHROME)
class ContactCorrectDataFirefoxTest : ContactCorrectData(Browser.FIREFOX)
class ContactWrongDataChromeTest : ContactWrongData(Browser.CHROME)
class ContactWrongDataFirefoxTest : ContactWrongData(Browser.FIREFOX)

@Suite
@SelectClasses(
    ContactCorrectDataChromeTest::class, ContactCorrectDataFirefoxTest::class,
    ContactWrongDataChromeTest::class, ContactWrongDataFirefoxTest::class
)
class ContactDataTests