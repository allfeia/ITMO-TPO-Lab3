package ts8

import Browser;
import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite

class ProfileCorrectDataChromeTest : ProfileCorrectData(Browser.CHROME)
class ProfileCorrectDataFirefoxTest : ProfileCorrectData(Browser.FIREFOX)
class ProfileWrongDataChromeTest : ProfileWrongData(Browser.CHROME)
class ProfileWrongDataFirefoxTest : ProfileWrongData(Browser.FIREFOX)

@Suite
@SelectClasses(
    ProfileCorrectDataChromeTest::class, ProfileCorrectDataFirefoxTest::class,
    ProfileWrongDataChromeTest::class, ProfileWrongDataFirefoxTest::class
)
class ProfileDataTests